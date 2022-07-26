package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
@Table(name = "champion_top_tier")
@Entity
public class ChampTopTierDto {
	@Id
	private int code;
	private String name;
	@Column(name = "win_rate")
	private String winRate;
	@Column(name = "pick_rate")
	private String pickRate;
	@Column(name = "ban_rate")
	private String banRate;
	private String tier;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code",insertable = false,updatable = false)
	private ChampionDto cpdto;
	
}




