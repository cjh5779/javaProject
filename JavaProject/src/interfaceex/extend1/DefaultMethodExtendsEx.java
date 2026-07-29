package interfaceex.extend1;

public class DefaultMethodExtendsEx {
	public static void main(String[] args) {
		// 익명 구현 객체 사용 - 1회성 클래스
		// ChildInterface1을 익명 객체로 구현
		ChildInterface1 ci1 = new ChildInterface1() {
			@Override
			public void method1() {
				System.out.println("c1-m1()");
			}
			
			@Override
			public void method3() {
				System.out.println("c1-m3()");
			}
			// ParentInterface에서 상속되어진 default method도 포함하게 됨
		};
		
		ci1.method1();
		ci1.method2(); // default 메소드 상속 받음
		ci1.method3();
		
		// ChildInterface2(default 메소드)를 구현하는 익명객체
		ChildInterface2 ci2 = new ChildInterface2() {
			@Override
			public void method1() {
				System.out.println("c2-m1()");
			}

			@Override
			public void method3() {
				System.out.println("c2-m3()");
			}
			// ChildInterface2의 재정의된 default 메소드 포함
		};
		
		ci2.method1();
		ci2.method2(); // ChildInterface2의 재정의된 default 메소드
		ci2.method3();
		
		// ChildInterface3(default 메소드를 추상메소드로 재선언)를 구현하는 익명객체
		ChildInterface3 ci3 = new ChildInterface3() {
			@Override
			public void method1() {
				System.out.println("c3-m1()");
				
			}
			
			@Override
			public void method2() { // 부모 인터페이스에서는 default 였지만, 상속받아 추상으로 재선언
				System.out.println("c3-m2()");
			}

			@Override
			public void method3() {
				System.out.println("c3-m3()");
				
			}
		};
		
		ci3.method1();
		ci3.method2(); // ChildInterface2의 재정의된 default 메소드
		ci3.method3();
	}
}
