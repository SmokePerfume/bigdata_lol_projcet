package com.lol.analysis.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lol.analysis.repository.BoardRepository;
import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.service.BoardService2;
import com.lol.analysis.vo.BoardVo;
import com.lol.analysis.vo.MemberVo;





@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository mr;
	
	@Autowired
	BoardRepository br;
	
	@Autowired
	private BoardService2 boardService2;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		Iterable<MemberVo> memList = mr.findAll();
		model.addAttribute("memList", memList);
		System.out.println(memList);
		return "member/list";
	}
	
	@GetMapping("/login.do")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("/member/login");
		return model;
	}
	
	@PostMapping("/login.do")
	public String login(String id, String pw, HttpSession session) {
		MemberVo memberVo=mr.findByIdAndPw(id, pw);
		if(memberVo!=null) {
			session.setAttribute("memVo", memberVo);
			return "redirect:/";
		}else {
			return "redirect:/member/login.do";
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
	
	@GetMapping("/list/{page}")
	public String pageableList( @PathVariable int page,
								@RequestParam(defaultValue = "postTime") String sort,
								@RequestParam(defaultValue = "desc") String desc,
								Model model) {
		int size=5;
		Pageable pageable=null;
		if(desc.equals("desc")) {
			pageable=PageRequest.of(page-1, size, Sort.by(sort).descending()); //mysql limit(start,size)			
		}else if(desc.equals("asc")) {
			pageable=PageRequest.of(page-1, size, Sort.by(sort).ascending()); //mysql limit(start,size)			
		}
		
		Page<BoardVo> itemList=br.findAll(pageable);
		
		
		
		model.addAttribute("memberList", itemList);
		return "/member/pageableList";
	}
	
	@PostMapping("/update.do")
	public String update(BoardVo board) {
		//System.out.println(basketVo);
		br.save(board);
		return "redirect:/member/list/1";
	}
	
	@PostMapping("/delete.do")
	public String delete(BoardVo board) {
		br.delete(board);
		return "redirect:/member/list/1";
	}

	
	@GetMapping("/inserted")
	public String insertForm() {
		return "/member/inserted";
	}
	
	@PostMapping("/inserted")
	public String insert(String title,String memberId,String contents){
		
		    BoardVo board=new BoardVo();
			board.setMemberId(memberId);
			board.setTitle(title);
			board.setContents(contents);
			br.save(board); //기존의 값이 없으면 insert  
		
		return "redirect:/member/list/1";
	}
	
	@GetMapping("/board/view")
	public String boardView(Model model, Integer id) {
		
		model.addAttribute("board", boardService2.boardView(id));
		return "boardview";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Integer id) {
		
		boardService2.boardDelete(id);
		
		return "redirect:/member/list/1";
	}
	
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable("id") Integer Nu, Model model) {
		model.addAttribute("board", boardService2.boardView(Nu));
		
		return "boardmodify";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable("id") Integer um, BoardVo board) {
		
		BoardVo boardTemp = boardService2.boardView(um);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContents(board.getContents());
		
		boardService2.write(boardTemp);
		
		return "redirect:/member/list/1";
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
}
