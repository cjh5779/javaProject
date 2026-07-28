package exam.instarray;

import java.util.Scanner;

public class Course {
	Scanner sc = new Scanner(System.in);
	String courseName;
	String professor;
	int grade;
	int credits;
	
	public void input() {
		System.out.print("과목명 : ");
		courseName = sc.next();
		
		System.out.print("교수 : ");
		professor = sc.next();
		
		System.out.print("학년 : ");
		grade = sc.nextInt();
		
		System.out.print("이수 학점 : ");
		credits = sc.nextInt();
		
		System.out.println();
	}
	
	public void output() {
		System.out.println(this.courseName + " " + this.professor + " " + this.grade + "학년 " + this.credits + "학점");
		
	}
}
