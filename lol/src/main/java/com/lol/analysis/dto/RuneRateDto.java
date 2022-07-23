package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "rune_rate")
@Entity
public class RuneRateDto {
	@Id
	private int code;
	private String name;
	@Column(name = "main_rune")
	private String mainRune;
	@Column(name = "sub_rune")
	private String subRune;
	@Column(name = "stats_rune")
	private String statsRune;
	@Column(name = "main_rune_code")
	private String mainRuneCode;
	@Column(name = "main_rune_img")
	private String mainRuneImg;
	@Column(name = "rune_pick_game")
	private String runePickGame;
	@Column(name = "main_rune_code2")
	private String mainRuneCode2;
	@Column(name = "main_rune_img2")
	private String mainRuneImg2;
	@Column(name = "rune_pick_game2")
	private String runePickGame2;
}
