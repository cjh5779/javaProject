package threads.sync;

public class SyncMain {
	public static void main(String[] args) {
		// 동기화 없는 스레드간의 공통객체 사용 예
		Calculator calc = new Calculator(); // 동기화 되지 않은 공통객체
		Calculator calc2 = new Calculator(); // 동기화 된 공통객체 인스턴스
		
		User1 user1 = new User1();
		user1.setCalculator(calc); // 공통객체 전달
		user1.start(); // 스레드 실행, memory => 100 설정
		
		User2 user2 = new User2();
		user2.setCalculator(calc); // 공통객체 전달, User1과 User2 동일 객체 사용
		user2.start(); // 스레드 실행, memory => 50 설정
	}
}
