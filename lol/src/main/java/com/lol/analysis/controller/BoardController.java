package com.lol.analysis.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lol.analysis.repository.BoardRepository;
import com.lol.analysis.repository.MemberRepository;
import com.lol.analysis.vo.BoardVo;





@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	MemberRepository mr;
	
	@Autowired
	BoardRepository br;
	
    @GetMapping("/list.do/{page}")
    public String pageableList( @PathVariable int page,
                                @RequestParam(defaultValue = "postdate") String sort,
                                @RequestParam(defaultValue = "desc") String desc, 
                                Model model) {
        int size=5;
        Pageable pageable=null;
        if(desc.equals("desc")){
            pageable=PageRequest.of(page-1, size,Sort.by(sort).descending());
        }else if(desc.equals("asc")){
            pageable=PageRequest.of(page-1, size,Sort.by(sort).ascending());
        }
        Page<BoardVo> boardList=br.findAll(pageable);
        model.addAttribute("boardList",boardList);
        return "board/pageableList";
    }
    
	
	@GetMapping("/insert.do")
	public String insert() {
		return "board/insert";
	}
//	
//	@PostMapping("/inserted")
//	public String insert(String title,String memberId,String contents){
//		
//		    BoardVo board=new BoardVo();
//			board.setMemberId(memberId);
//			board.setTitle(title);
//			board.setContents(contents);
//			br.save(board); //기존의 값이 없으면 insert  
//		
//		return "redirect:/member/list/1";
//	}
	
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
