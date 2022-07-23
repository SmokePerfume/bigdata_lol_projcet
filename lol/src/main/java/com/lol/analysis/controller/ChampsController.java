package com.lol.analysis.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lol.analysis.dto.ChampJungleTierDto;
import com.lol.analysis.dto.ChampTopTierDto;
import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.dto.RuneRateDto;
import com.lol.analysis.repository.ChampJungleTierRepository;
import com.lol.analysis.repository.ChampTopTierRepository;
import com.lol.analysis.repository.ChampionRepository;
import com.lol.analysis.repository.RuneLateRepository;



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
	RuneLateRepository rl;
	
	@GetMapping("/list")
	public String champs(Model model) {
		Iterable<ChampionDto> cpList=cr.findAllByOrderByNameAsc();
		model.addAttribute("cpList",cpList);
		Iterable<ChampTopTierDto> ctList=ct.findAllByOrderByTierAsc();
		model.addAttribute("ctList",ctList);
		Iterable<ChampJungleTierDto> cjList=cj.findAllByOrderByTierAsc();
		model.addAttribute("cjList",cjList);
		return "champs/list";
	}

	@GetMapping("/detail/champ_code/{code}")
	public String champDetail(Model model,ChampionDto CpDto,ChampTopTierDto CtDto,ChampJungleTierDto CjDto,@PathVariable int code){
		ChampionDto cpCode=cr.findByCode(CpDto.getCode());
		model.addAttribute("cpCode", cpCode);
		Iterable<RuneRateDto> rlcode=rl.findAll();
		model.addAttribute("rlCode",rlcode);
		return "champs/champ_detail";
	}
	
}








