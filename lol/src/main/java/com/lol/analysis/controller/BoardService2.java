package com.lol.analysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lol.analysis.repository.BoardRepository;
import com.lol.analysis.vo.BoardVo;



@Service
public class BoardService2 {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void write(BoardVo board) {
		
		boardRepository.save(board);
	}
	
	public List<BoardVo> boardList(){
		return boardRepository.findAll();
		
	}
	
	public  BoardVo boardView(Integer Nu) {
		
		return boardRepository.findById(Nu).get();
	}
	
	public void boardDelete(Integer Num) {
		
		boardRepository.deleteById(Num);
	}
	
	
}
