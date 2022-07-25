package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "champion")
public class ChampionDto {
	@Id
	private int code;
	private String name;
	@Column(name = "e_name")
	private String eName;
	@Column(name = "c_img")
	private String cImg;
	@Column(name = "spell_p")
	private String spellP;
	@Column(name = "spell_q")
	private String spellQ;
	@Column(name = "spell_w")
	private String spellW;
	@Column(name = "spell_e")
	private String spellE;
	@Column(name = "spell_r")
	private String spellR;
	@Column(name = "main_rune")
	private String mainRune;
	@Column(name = "main_rune_img")
	private String mainRuneImg;
	@Column(name = "sub_rune")
	private String subRune;
	@Column(name = "sub_rune_img")
	private String subRuneImg;
	@Column(name = "stats_rune")
	private String statsRune;
	@Column(name = "stats_rune_img")
	private String statsRuneImg;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code",insertable = false,updatable = false)
	private RuneRateDto rldto;
	
}
