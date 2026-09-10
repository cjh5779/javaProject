package com.spring_aop.xml2;

public class Evaluation {
	private int kor;
	private int eng;
	private int math;
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public void showResult() {
		int total = kor + eng + math;
		double average = total / 3.0;
		
		System.out.println("국어 점수: " + kor);
		System.out.println("영어 점수: " + eng);
		System.out.println("수학 점수: " + math);
		System.out.println("총점: " + total);
		System.out.printf("평균: %.2f%n", average);
	}
}
