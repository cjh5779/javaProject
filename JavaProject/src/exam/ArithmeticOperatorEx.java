package exam;

import java.util.Scanner;

public class ArithmeticOperatorEx {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int kor, eng, math;
		 float total, average;
		 
		 System.out.print("국어 점수 입력 : ");
		 kor = sc.nextInt();
		 System.out.print("영어 점수 입력 : ");
		 eng = sc.nextInt();
		 System.out.print("수학 점수 입력 : ");
		 math = sc.nextInt();
		 
		 System.out.println("====================");
		 
		 total = kor + eng + math;
		 average = total / 3;
		 
		 System.out.println("총점 : " + total);
		 System.out.println("평균 : " + average);
	}
}
