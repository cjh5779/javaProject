package extendsex.abstractex;

public class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
	public void show() {
		System.out.println("강아지 입니다");
	}
}
