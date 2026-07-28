package extendsex;

class Parent1 {
	
}

class Child1 extends Parent1 {
	
}

public class InstanceOf {
	public static void main(String[] args) {
		// 객체 타입 확인 예시
		Parent1 p = new Parent1();
		System.out.println(p instanceof Parent1); // true
		System.out.println(p instanceof Child1); // false
		
		Child1 c = new Child1();
		System.out.println(c instanceof Parent1); // true
		System.out.println(c instanceof Child1); // true
		
		Parent1 pc = new Child1(); // Child1 객체 인스턴스를 참조
		System.out.println(pc instanceof Parent1); // true (부모타입으로 형변환 되어서 참조가 저장됨)
		System.out.println(pc instanceof Child1); // true (참조하는 객체 인스턴스는 Child1 타입)
		
		Child1 c2 = (Child1)pc; // 강제형변환 가능
		
		// (p instanceof Child1) 진행 시 false가 반환되므로 실행 오류 발생 - 강제형변환 전에 instanceof 연산 진행 권장
	}

}
