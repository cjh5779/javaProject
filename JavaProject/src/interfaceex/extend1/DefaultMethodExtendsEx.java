package interfaceex.extend1;

public class DefaultMethodExtendsEx {
	public static void main(String[] args) {
		// 익명 구현 객체 사용 - 1회성 클래스
		ChildInterface1 ci1 = new ChildInterface1() {
			
			@Override
			public void method1() {
				System.out.println("c1-m1()");
			}
		}
	}

}
