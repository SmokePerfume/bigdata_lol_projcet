package com.lol.analysis.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/case1.do")
	public ModelAndView case2(ModelAndView model){
		model.setViewName("test/case1");

		return model;
	}
	
	@PostMapping("/case1.do")
	public String case1(String data1, String data2) throws Exception{
		////////////////
		System.out.println("Python3 Call");
        String[] command = new String[4];
        command[0] = "python3";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        command[1] = resolvePythonScriptPath("hello.py");
        System.out.println("현재경로 : "+ command[1]);
        command[2] = "10";
        command[3] = "20";
        try {
            execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
	}

	
	public static void execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
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
