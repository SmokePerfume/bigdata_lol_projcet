package com.lol.analysis.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lol.analysis.dto.ChampBottomTierDto;
import com.lol.analysis.dto.ChampJungleTierDto;
import com.lol.analysis.dto.ChampMiddleTierDto;
import com.lol.analysis.dto.ChampTopTierDto;
import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.dto.ChampionName;
import com.lol.analysis.repository.ChampBottomTierRepository;
import com.lol.analysis.repository.ChampJungleTierRepository;
import com.lol.analysis.repository.ChampMiddleTierRepository;
import com.lol.analysis.repository.ChampTopTierRepository;
import com.lol.analysis.repository.ChampionNameRepository;
import com.lol.analysis.repository.ChampionRepository;



@Controller
@RequestMapping("/champs")
public class ChampsController {
	@Autowired
	ChampionRepository cr;
	
	@Autowired
	ChampTopTierRepository ct;
	
	@Autowired
	ChampJungleTierRepository cj;
	
	@Autowired
	ChampMiddleTierRepository cm;
	
	@Autowired
	ChampBottomTierRepository cb;
	
	@Autowired
	ChampionNameRepository cn;
	
	@GetMapping("/list")
	public String champs(Model model) {
		Iterable<ChampionDto> cpList=cr.findAllByOrderByNameAsc();
		model.addAttribute("cpList",cpList);
		Iterable<ChampTopTierDto> ctList=ct.findAllByOrderByTierAsc();
		model.addAttribute("ctList",ctList);
		Iterable<ChampJungleTierDto> cjList=cj.findAllByOrderByTierAsc();
		model.addAttribute("cjList",cjList);
		Iterable<ChampMiddleTierDto> cmList=cm.findAllByOrderByTierAsc();
		model.addAttribute("cmList",cmList);
		Iterable<ChampBottomTierDto> cbList=cb.findAllByOrderByTierAsc();
		model.addAttribute("cbList",cbList);

		return "champs/list";
	}

	@GetMapping("/detail/champ_code/{code}")
	public String champDetail(Model model,ChampionDto CpDto,@PathVariable int code){
		ChampionDto cpCode=cr.findByCode(CpDto.getCode());
		model.addAttribute("cpCode", cpCode);
		return "champs/champ_detail";
	}
	
	
	@GetMapping("/detail/champ_name/{name}")
	public String champDetailName(Model model,ChampionDto cpdto,@PathVariable String name) throws IOException{
		ChampionDto cpCode=cr.findByName(cpdto.getName());

		model.addAttribute("cpCode",cpCode);		
		return "champs/champ_detail";
	}
	
	@GetMapping("/detail/champ_name")
	@ResponseBody
	public List<ChampionName> champName() throws IOException{
		List<ChampionName> cpName = cn.findName();
		return cpName;
	}
	
}








