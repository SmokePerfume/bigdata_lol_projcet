package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "spell_rate")
public class SpellRateDto {
	@Id
	private int code;
	private String name;
	@Column(name = "summoner_spell0")
	private String summonerSpell0;
	@Column(name = "summoner_spell1")
	private String summonerSpell1;
	@Column(name = "summoner_spell_rate0")
	private String summonerSpellRate0;
	@Column(name = "summoner_spell2")
	private String summonerSpell2;
	@Column(name = "summoner_spell3")
	private String summonerSpell3;
	@Column(name = "summoner_spell_rate1")
	private String summonerSpellRate1;
}
