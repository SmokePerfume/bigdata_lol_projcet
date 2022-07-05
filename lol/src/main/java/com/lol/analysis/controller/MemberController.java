package com.lol.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository mr;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		Iterable<MemberVo> memList = mr.findAll();
		model.addAttribute("memList", memList);
		System.out.println(memList);
		return "member/list";
	}

}
