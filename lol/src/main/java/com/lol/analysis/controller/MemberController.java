package com.lol.analysis.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository mr;
	
	/*
	 * @GetMapping("/list.do") public String list(Model model) { Iterable<MemberVo>
	 * memList = mr.findAll(); model.addAttribute("memList", memList);
	 * System.out.println(memList); return "member/list"; }
	 */
	
	@GetMapping("/login.do")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("/member/login");
		return model;
	}
	
	@PostMapping("/login.do")
	public String login(String id, String pw, HttpSession session) {
		MemberVo memberVo=mr.findByIdAndPw(id, pw);
		if(memberVo!=null) {
			session.setAttribute("memberVo", memberVo);
			return "redirect:/";
		}else {
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/signup.do")
	public ModelAndView signup(ModelAndView model) {
		model.setViewName("/member/signup");
		return model;
	}
	
	@PostMapping("/signup.do")
    public String signup(MemberVo memberVo,HttpSession session) {
        boolean insert=false;
        try {
            Optional<MemberVo> memOption=mr.findById(memberVo.getId()); //id중복확인
            if(memOption.isEmpty()) {
                MemberVo insertMem=mr.save(memberVo);
                if(insertMem!=null) {insert=true;} //회원가입 성공
            }else {
                session.setAttribute("msg", "존재하는 아이디 입니다.");
            }
        }catch(Exception e){
            e.printStackTrace();
            session.setAttribute("msg", "Email이나 phone이 존재합니다.");
        }
        if(insert) {
            return "redirect:/";
        }else {
            return "redirect:/member/signup.do";
        }
    }
	@GetMapping("/ajax/findId/{id}")
    public @ResponseBody Optional<MemberVo> findId(@PathVariable String id) {
        return mr.findById(id);
    }
    @GetMapping("/ajax/findEmail/{email}")
    public @ResponseBody Optional<MemberVo> findEmail(@PathVariable String email) {
        return mr.findByEmail(email);
    }
    
    @GetMapping("/ajax/findPhone/{phone}")
    public @ResponseBody Optional<MemberVo> findPhone(@PathVariable String phone) {
        return mr.findByPhone(phone);
    }
    
    @GetMapping("/list.do/{page}")
    public String pageableList( @PathVariable int page,
                                @RequestParam(defaultValue = "regdate") String sort,
                                @RequestParam(defaultValue = "desc") String desc, 
                                Model model) {
        int size=5;
        Pageable pageable=null;
        if(desc.equals("desc")){
            pageable=PageRequest.of(page-1, size,Sort.by(sort).descending());
        }else if(desc.equals("asc")){
            pageable=PageRequest.of(page-1, size,Sort.by(sort).ascending());
        }
        Page<MemberVo> memberList=mr.findAll(pageable);
        model.addAttribute("memberList",memberList);
        return "member/pageableList";
    }
}
