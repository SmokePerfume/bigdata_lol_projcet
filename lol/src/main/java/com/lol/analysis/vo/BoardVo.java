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
@Table(name = "board")
@DynamicInsert
@DynamicUpdate
public class BoardVo {
	
	@Id
	private int bno;
	private String id;
	private String title;
	private String content;
	@Column(insertable=true, updatable=false)
	private Date postdate;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", id=" + id + ", title=" + title + ", content=" + content + ", postdate="
				+ postdate + "]";
	}
	
	
	
	

}
