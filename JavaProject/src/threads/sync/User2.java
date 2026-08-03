package threads.sync;

// thread로 등록할 클래스
public class User2 extends Thread {
	private Calculator calculator; // 공통 사용 객체에 대한 필드
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
