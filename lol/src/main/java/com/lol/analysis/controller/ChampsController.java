package com.lol.analysis.controller;



import java.util.List;

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



@Controller
@RequestMapping("/champs")
public class ChampsController {
	@Autowired
	ChampionRepository cr;
	
	@Autowired
	ChampTopTierRepository ct;
	
	@Autowired
	ChampJungleTierRepository cj;
	
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
	public String champDetail(Model model,ChampionDto CpDto,@PathVariable int code){
		ChampionDto cpCode=cr.findByCode(CpDto.getCode());
		model.addAttribute("cpCode", cpCode);
		return "champs/champ_detail";
	}
	
	@GetMapping("/detail/champ_name/{name}")
	public String champDetailName(Model model,ChampionDto cpdto,@PathVariable String name) {
		ChampionDto cpCode=cr.findByName(cpdto.getName());
		model.addAttribute("cpCode",cpCode);
		
		List<ChampionDto> likeList=cr.findLikeName(name);
		for(ChampionDto en:likeList) {
			System.out.println(en.getName());
		}
		
		return "champs/champ_detail";
	}
	
	
	
}








