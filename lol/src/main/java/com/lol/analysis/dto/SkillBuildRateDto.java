package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "champion_skill_build_rate")
public class SkillBuildRateDto {
	@Id
	private int code;
	private String name;
	@Column(name = "skill_build")
	private String skillBuild;
	@Column(name = "skill_build_rate")
	private String skillBuildRate;
	@Column(name = "main_skill1")
	private String mainSkill1;
	@Column(name = "main_skill2")
	private String mainSkill2;
	@Column(name = "main_skill3")
	private String mainSkill3;
	@Column(name = "main_skill_mini1")
	private String mainSkillMini1;
	@Column(name = "main_skill_mini2")
	private String mainSkillMini2;
	@Column(name = "main_skill_mini3")
	private String mainSkillMini3;
}
