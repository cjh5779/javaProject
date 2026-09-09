package com.di.spring_di_annotation_ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
// Speaker 객체 필요 : DI(생성자)
public class Tv {
	private Speaker speaker;
	
	@Autowired
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
