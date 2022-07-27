package com.lol.analysis.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.repository.ChampionRepository;
import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.repository.PredDetailRepository;
import com.lol.analysis.repository.PredRepository;
import com.lol.analysis.vo.MemGenderCntVo;
import com.lol.analysis.vo.MemberVo;
import com.lol.analysis.vo.PredDetailVo;
import com.lol.analysis.vo.PredVo;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	
	@Autowired
	MemberRepository mr;
	
	@Autowired
	ChampionRepository cr;
	
	@Autowired
	PredRepository pr;
	
	@Autowired
	PredDetailRepository pdr;
	
	@GetMapping("/test1.do")
	public String case1(Model model, HttpSession session){
	    MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		Iterable<ChampionDto> chList=cr.findAllByOrderByNameAsc();
		PredVo prePred = pr.findAllWithPredDetailWithChampion(memberVo.getId()).get(0);
		model.addAttribute("chList", chList);
		model.addAttribute("prePred", prePred);
		return "service/test1";
	}
	
	@PostMapping("/test1.do")
	public String case1(String reddata1, String reddata2,String reddata3,String reddata4,String reddata5,
			String bluedata1,String bluedata2,String bluedata3,String bluedata4,String bluedata5, 
			Model model, HttpSession session,RedirectAttributes rttr) throws Exception{
		
//		bluedata1="777"; 	//요네
//		bluedata2="888"; 	//레나타글라스크
//		bluedata3="131"; 	//다이애나
//		bluedata4="157"; 	//야스오
//		bluedata5="429"; 	//칼리스타
//		reddata1="104"; 	//그레이브즈
//		reddata2="81"; 		//이즈리얼
//		reddata3="43"; 		//카르마
//		reddata4="268"; 	//아지르
//		reddata5="223";	 	//탐켄치
			
		System.out.println("Python3 Call test");
		
		String[] command = new String[12];
		command[0] = "python3";
        command[1] = resolvePythonScriptPath("predwin.py");
        
        System.out.println("현재경로 : "+ command[1]);
        
        String[] input_arr= {bluedata1,bluedata2,bluedata3,bluedata4,bluedata5,reddata1,reddata2,reddata3,reddata4,reddata5};
        List<ChampionDto> chDtoList = new ArrayList<ChampionDto>();
        
        
        for(int i=0;i<input_arr.length;i++) {
        	chDtoList.add(cr.findByCode(Integer.parseInt(input_arr[i])));
        	if(i<5) {
            	input_arr[i]="blue_"+input_arr[i];
        	}else {
        		input_arr[i]="red_"+input_arr[i];
        	}
        	
        }
        
        for(int i=2,j=0;i<12;i++,j++) {
        	command[i]=input_arr[j];
        }
        
        System.out.println("////////////////////////////red/////////////////////////////////////");
        System.out.println(chDtoList.size());
        for(ChampionDto testDto:chDtoList) {
        	System.out.println(testDto.getName());
        }
        
	    MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");

	    String predresult ="";
		
		try {
			predresult=execPython(command); 
			//predresult="sasad0.4545568791";	//개인환경 테스트용
			predresult=predresult.substring(predresult.length()-12);
			PredVo predVo=new PredVo();
		    predVo.setId(memberVo.getId());
		    predVo.setResult(Float.parseFloat(predresult));
		    pr.save(predVo);
		    List<PredVo> pred_list=pr.findLastPredTuple();
		    PredVo pred_last=pred_list.get(0);
		    
		    for(int i=0; i<input_arr.length;i++) {
		    	PredDetailVo preddeVo=new PredDetailVo();
		    	String[] str_arr=input_arr[i].split("_");
		    	preddeVo.setPredno(pred_last.getPredno());
		    	preddeVo.setTeam(str_arr[0]);
		    	preddeVo.setChcode(Integer.parseInt(str_arr[1]));
		    	pdr.save(preddeVo);
		    }
		    
			rttr.addFlashAttribute("predresult", predresult);
			rttr.addFlashAttribute("chDtoList", chDtoList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "redirect:/service/test1.do";
	}
    
    
	public static String execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
            System.out.print(command[i]+" ");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        System.out.println("output: " + outputStream.toString());
        return outputStream.toString();

    }  
	
	
    private String resolvePythonScriptPath(String filename) {
        File file = new File("src/PyStorage/" + filename);
        return file.getAbsolutePath();
    }
    

}