package exception.classcast;

public class ClassCastExcept {
	public static void main(String[] args) {
		// 상속 관계에 있는 두 클래스
		Child child = new Child();
		Child2 child2;
		
		Parent parent;
		
		parent = child;
		
		// Parent 클래스를 Child 클래스와 Child2 클래스가 상속
		child2 = (Child2)parent; // ClassCastException, parent 참조변수는 Child 인스턴스 참조
	}
}