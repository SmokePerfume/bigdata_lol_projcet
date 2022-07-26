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
@Table(name = "pred")
@DynamicInsert
@DynamicUpdate
public class PredVo {
	
	@Id
	@Column(insertable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int predno;
	private String id;
	@Column(insertable=true, updatable=false)
	private Date regdate;
	private float result;
	
	@OneToMany //fetch=FetchType.LAZY : default이다.
	@JoinColumn(name="predno", insertable=false, updatable=false)
	private List<PredDetailVo> PredDetail;
	
	public int getPredno() {
		return predno;
	}
	public void setPredno(int predno) {
		this.predno = predno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public float getResult() {
		return result;
	}
	public void setResult(float result) {
		this.result = result;
	}
	public List<PredDetailVo> getPredDetail() {
		return PredDetail;
	}
	public void setPredDetail(List<PredDetailVo> predDetail) {
		PredDetail = predDetail;
	}
	@Override
	public String toString() {
		return "PredVo [predno=" + predno + ", id=" + id + ", regdate=" + regdate + ", result=" + result
				+ ", PredDetail=" + PredDetail + "]";
	}
	

}
