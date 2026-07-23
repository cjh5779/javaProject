package classInfo;

public class CarMain {
	public static void main(String[] args) {
		// 프로그램의 실행과 종료
		// 클래스는 사용자 정의 타입 - 클래스 타입의 변수 선언 가능
		Car c1 = new Car(); // 생성자 함수 호출
		Car c2 = new Car();
		Car c3 = new Car();
		
		c1.carNo = "11가 1234";
		c1.showCarInfo();
		c2.carNo = "22가 5678";
		c2.showCarInfo();
		c3.carNo = "33가 1111";
		c3.showCarInfo();
	}
}
