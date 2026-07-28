package exam.abstractex;

public class Line extends DrawingObject {
	public Line(String color) {
		super(color);
	}
	
	public void draw() {
		System.out.println(color + "색상으로 선 그리기");
	}
}
