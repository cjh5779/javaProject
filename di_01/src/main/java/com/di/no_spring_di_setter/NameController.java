package com.di.no_spring_di_setter;

public class NameController {
	// NameController 입장에서 nameService에 종속적(의존관계)
	NameService nameService;
	// NameService nameService = new NameService(); // 결합방식
	// setter 통한 주입
	public void setNameService(NameService nameSerivce) {
		this.nameService = nameSerivce;
	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
	
}
