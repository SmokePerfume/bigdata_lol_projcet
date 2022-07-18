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

public class BoardVo {
	
	@Id
	@Column(name="num")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Num;
	@Column(name="member_id")
	private String memberId;
	private String title;
	private String contents;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="post_time", insertable =false,updatable = false)
	private Date postTime;
	private int score;
	
	
	

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public Integer getNum() {
		return Num;
	}


	public void setNum(Integer num) {
		Num = num;
	}


	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	

	public Date getPostTime() {
		return postTime;
	}


	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}


	@Override
	public String toString() {
		return "BoardVo [Num=" + Num + ", memberId=" + memberId + ", title=" + title + ", contents=" + contents
				+ ", postTime=" + postTime + "]";
	}





	

}
