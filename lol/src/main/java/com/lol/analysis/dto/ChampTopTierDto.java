package com.lol.analysis.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "win_late")
	private String winLate;
	@Column(name = "pick_late")
	private String pickLate;
	@Column(name = "ban_late")
	private String banLate;
	private String tier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code",insertable = false,updatable = false)
	private ChampionDto cpdto;
	
}




