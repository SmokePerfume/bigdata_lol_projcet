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
import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.vo.MemGenderCntVo;
import com.lol.analysis.vo.MemberVo;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	MemberRepository mr;
	
	@GetMapping("/case1.do")
	public ModelAndView case2(ModelAndView model){
		model.setViewName("test/case1");
		

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
		
		return model;
	}
	
	@PostMapping("/case1.do")
	public String case1(String inputdata1, String inputdata2) throws Exception{
		////////////////
		System.out.println("Python3 Call");
        String[] command = new String[4];
        command[0] = "python3";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        command[1] = resolvePythonScriptPath("hello.py");
        System.out.println("현재경로 : "+ command[1]);
        command[2] = inputdata1;
        command[3] = inputdata2;
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
