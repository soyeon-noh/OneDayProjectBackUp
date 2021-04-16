package com.callor.word.model;

public class WordVO {

	private String english;
	private String koreak;
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKoreak() {
		return koreak;
	}
	public void setKoreak(String koreak) {
		this.koreak = koreak;
	}
	@Override
	public String toString() {
		return "WordVO [english=" + english + ", koreak=" + koreak + "]";
	}

	
}
