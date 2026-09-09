package com.di.spring_di_xml_setter_ex1;

// Speaker 객체 필요 : DI(생성자)
public class Tv {
	private Speaker speaker;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
