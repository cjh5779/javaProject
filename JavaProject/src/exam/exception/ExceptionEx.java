package exam.exception;

import java.util.Scanner;

public class ExceptionEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		int result;
		
		System.out.print("정수1 입력 : ");
		num1 = sc.nextInt();
		
		System.out.print("정수2 입력 : ");
		num2 = sc.nextInt();
		
		try {
			result = num1 / num2;
			System.out.println("나누기 결과 : " + result);
		} catch(ArithmeticException e) {
			System.out.println(num2 + "으로 나눌 수 없습니다");
		}
	}
}
