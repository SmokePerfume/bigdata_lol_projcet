package com.lol.analysis.vo;






public class MemGenderCntVo {

	private String gender;
	private int cnt;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "MemGenderCntVo [gender=" + gender + ", cnt=" + cnt + "]";
	}
	
	
	
	

}
