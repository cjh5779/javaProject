package exam.abstractex;

public class Main {
	public static void main(String[] args) {
		DrawingObject line = new Line("red");
		line.draw();
		
		DrawingObject circle = new Circle("blue");
		circle.draw();
		
		DrawingObject rect = new Rect("red");
		rect.draw();
	}

}
