package exam.constructor_ex;

public class PartTimeWorker {
	public static void main(String[] args) {
		PartTime pt = new PartTime("990101-1034567", "홍길동", 6000, 60);
		
		System.out.println(pt); // 객체의 toString() 자동 호출
	}

}
