package com.lol.analysis.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.repository.ChampionRepository;
import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.vo.MemGenderCntVo;
import com.lol.analysis.vo.MemberVo;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	MemberRepository mr;
	

	@Autowired
	ChampionRepository cr;
	
	@GetMapping("/case1.do")
	public String case1(Model model){
			//정상 작동 확인 나중에 목록 넘길시 사용
		//System.out.println(cr.findAll());
		//model.addAttribute("chList", cr.findAll());
		
		

//		Gson gson = new Gson();
//		JsonArray jArray = new JsonArray();
//		System.out.println(mr.findGenderCountWithMember());
		//Iterator<MemGenderCntVo> it = mr.findGenderCountWithMember().iterator();
		//System.out.println(it);
		
		//while(it.hasNext()) {
		//	System.out.println(it.next().toString());
			//LogVO curVO = it.next();
//			JsonObject object = new JsonObject();
//			String userid = curVO.getLog_userid();
//			int cnt = curVO.getCnt();
//			
//		    object.addProperty("ID", userid);
//			object.addProperty("Count", cnt);
//			jArray.add(object);
	//	}
//				
//		String json = gson.toJson(jArray);
//		model.addAttribute("json", json);
		
		return "test/case1";
	}
	
//	@PostMapping("/case1.do")
//	public String case1(String reddata1, String reddata2) throws Exception{
//		System.out.println("Python3 Call");
//        String[] command = new String[4];
//        command[0] = "python3";
//        command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
//        command[1] = resolvePythonScriptPath("hello.py");
//        System.out.println("현재경로 : "+ command[1]);
//        command[2] = reddata1;
//        command[3] = reddata2;
//        try {
//            execPython(command);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/test/case1.do";
//	}
	
	@PostMapping("/case1.do")
	public String case1(String reddata1, String reddata2,String reddata3,String reddata4,String reddata5,
			String bluedata1,String bluedata2,String bluedata3,String bluedata4,String bluedata5) throws Exception{
		
		System.out.println("Python3 Call test1");
		String[] command = new String[12];
		command[0] = "python3";
        command[1] = resolvePythonScriptPath("testing1.py");
        System.out.println("현재경로 : "+ command[1]);
		command[2] = reddata1;
	    command[3] = reddata2;
		command[4] = reddata3;
	    command[5] = reddata4;
		command[6] = reddata5;
		
	    command[7] = bluedata1;
		command[8] = bluedata2;
	    command[9] = bluedata3;
		command[10] = bluedata4;
	    command[11] = bluedata5;
		
		try {
			execPython(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return "redirect:/test/case1.do";
	}

//    @GetMapping("/update.do")
//	public String update(Model model, @RequestParam(name="id") String id) {
//        Optional<MemberVo> memOption = mr.findById(id);
//        MemberVo memberVo=memOption.get();
//        model.addAttribute("memberVo",memberVo);
//		return "member/update";
//	}
    
    
	public static void execPython(String[] command) throws IOException, InterruptedException {
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
        System.out.println("result: " + result);
        System.out.println("output: " + outputStream.toString());

    }  
	
	
    private String resolvePythonScriptPath(String filename) {
        File file = new File("src/PyStorage/" + filename);
        return file.getAbsolutePath();
    }
}
