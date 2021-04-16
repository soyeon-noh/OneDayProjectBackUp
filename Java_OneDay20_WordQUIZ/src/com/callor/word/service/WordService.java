package com.callor.word.service;

public interface WordService {
	public void loadWord();
	public void seletMenu();
	public void viewWord(int point) throws InterruptedException;
	public void printWord();

}
