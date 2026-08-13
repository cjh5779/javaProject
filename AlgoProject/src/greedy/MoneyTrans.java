package greedy;

import java.util.Scanner;

public class MoneyTrans {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 입력 : ");
		int money = sc.nextInt();
		
		int[] coinUnit = {5000, 1000, 500, 100, 50, 10};
		
		for(int i=0; i<coinUnit.length; i++) {
			int count = money / coinUnit[i];
			
			if(count > 0) {
				System.out.printf("%d원 : %d\n", coinUnit[i], count);
			} 
			
			money = money % coinUnit[i];
		}
		
		System.out.printf("나머지 : %d", money);

	}

}
