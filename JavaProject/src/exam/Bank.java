package exam;

import java.util.Scanner;

public class Bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int balance = 0;
		int depositAmount, withdrawAmount;
		int option;
		
		while(true) {
			System.out.println("======================");
			System.out.println("1.예금|2.출금|3.잔금|4.종료");
			System.out.println("======================");
			
			System.out.print("선택> ");
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.print("예금액> ");
					depositAmount = sc.nextInt();
					balance += depositAmount;
					System.out.println();
					break;
				case 2:
					System.out.print("출금액> ");
					withdrawAmount = sc.nextInt();
					balance -= withdrawAmount;
					System.out.println();
					break;
				case 3:
					System.out.println("잔고> " + balance);
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.print("프로그램 종료");
					break;
				default:
					System.out.println();
			}
			
			if(option == 4) break;
		
		}
		
		sc.close();
		
	}

}
