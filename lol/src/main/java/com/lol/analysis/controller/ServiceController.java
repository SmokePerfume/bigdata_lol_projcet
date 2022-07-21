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
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	MemberRepository mr;
	

	@Autowired
	ChampionRepository cr;
	
	@GetMapping("/test1.do")
	public String case1(Model model){
		model.addAttribute("chList", cr.findAll());
		return "service/test1";
	}
	
	@PostMapping("/test1.do")
	public String case1(String reddata1, String reddata2,String reddata3,String reddata4,String reddata5,
			String bluedata1,String bluedata2,String bluedata3,String bluedata4,String bluedata5, Model model) throws Exception{
		
		System.out.println("Python3 Call test1");
		String[] command = new String[12];
		command[0] = "python3";
        command[1] = resolvePythonScriptPath("predwin.py");
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
			model.addAttribute("predresult", execPython(command));
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
        System.out.println("result: " + result);
        System.out.println("output: " + outputStream.toString());
        return outputStream.toString();

    }  
	
	
    private String resolvePythonScriptPath(String filename) {
        File file = new File("src/PyStorage/" + filename);
        return file.getAbsolutePath();
    }
}
