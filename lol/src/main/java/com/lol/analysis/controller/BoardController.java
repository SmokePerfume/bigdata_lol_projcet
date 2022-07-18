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
@RequestMapping("/board")
public class BoardController {
	@Autowired
	MemberRepository mr;
	
	@Autowired
	BoardRepository br;
	
	@Autowired
	private BoardService2 boardService2;

	
	@GetMapping("/insert.do")
	public String insert() {
		return "/member/inser";
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
	
//	@GetMapping("/board/view")
//	public String boardView(Model model, Integer id) {
//		
//		model.addAttribute("board", boardService2.boardView(id));
//		return "boardview";
//	}
//	
//	@GetMapping("/board/delete")
//	public String boardDelete(Integer id) {
//		
//		boardService2.boardDelete(id);
//		
//		return "redirect:/member/list/1";
//	}
//	
//	@GetMapping("/board/modify/{id}")
//	public String boardModify(@PathVariable("id") Integer Nu, Model model) {
//		model.addAttribute("board", boardService2.boardView(Nu));
//		
//		return "boardmodify";
//	}
//	
//	@PostMapping("/board/update/{id}")
//	public String boardUpdate(@PathVariable("id") Integer um, BoardVo board) {
//		
//		BoardVo boardTemp = boardService2.boardView(um);
//		boardTemp.setTitle(board.getTitle());
//		boardTemp.setContents(board.getContents());
//		
//		boardService2.write(boardTemp);
//		
//		return "redirect:/member/list/1";
//	}
//	
}
