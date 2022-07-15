package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table (name = "champion")
@Data
public class ChampionDto {
	
	@Id 
	private int code;
	
	private String name;
	
	@Column(name = "e_name")
	private String eName;
	
	@Column(name = "c_img")
	private String cImg;
	
	

}
