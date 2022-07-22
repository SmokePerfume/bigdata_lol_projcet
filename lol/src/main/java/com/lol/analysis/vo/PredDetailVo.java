package com.lol.analysis.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.List;

import javax.persistence.Basic;


import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;


@Entity
@Table(name = "preddetail")
@DynamicInsert
@DynamicUpdate
public class PredDetailVo {
	
	@Id
	@Column(insertable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int preddeno;
	private String team;
	private int predno;
	private int chcode;
	public int getPreddeno() {
		return preddeno;
	}
	public void setPreddeno(int preddeno) {
		this.preddeno = preddeno;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getPredno() {
		return predno;
	}
	public void setPredno(int predno) {
		this.predno = predno;
	}
	public int getChcode() {
		return chcode;
	}
	public void setChcode(int chcode) {
		this.chcode = chcode;
	}
	@Override
	public String toString() {
		return "PredDetailVo [preddeno=" + preddeno + ", team=" + team + ", predno=" + predno + ", chcode=" + chcode
				+ "]";
	}
	
}
