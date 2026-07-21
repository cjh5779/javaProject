package exam;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ArithmeticOperatorEx {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int kor, eng, math, total;
		 float average;
		 
		 System.out.print("국어 점수 입력 : ");
		 kor = sc.nextInt();
		 System.out.print("영어 점수 입력 : ");
		 eng = sc.nextInt();
		 System.out.print("수학 점수 입력 : ");
		 math = sc.nextInt();
		 
		 System.out.println("====================");
		 
		 total = kor + eng + math;
		 average = total / 3;
		 
		 // 소수점 이하 자리수 두자리로 조정
		 DecimalFormat df = new DecimalFormat("0.00");
		 
		 System.out.println("총점 : " + total);
		 System.out.println("평균 : " + df.format(average));
		 
		 sc.close();
	}
}
