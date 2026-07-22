package exam;

import java.util.Scanner;

public class ForEx4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;
		
		for(int i=1; i<=10; i++) {
			System.out.print("숫자" + i + " 입력 : ");
			num = sc.nextInt();
			
			if (num > 0) {
				positiveCount++;
			} else if (num < 0) {
				negativeCount++;
			} else {
				zeroCount++;
			}
		}
		
		System.out.println("양의 개수 : " + positiveCount);
		System.out.println("음의 개수 : " + negativeCount);
		System.out.println("0의 개수 : " + zeroCount);
		
		sc.close();
	}

}
