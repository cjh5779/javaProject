package exam;

import java.util.Scanner;

public class Score_ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		int studentCount = 0;
		int scores[] = null;
		int max;
		int sum = 0;
		float avg;
		
		
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("-------------------------------------");
			
			System.out.print("선택> ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("학생수> ");
					studentCount = sc.nextInt();
					scores = new int[studentCount];
					break;
				case 2:
					for(int i=0; i<studentCount; i++) {
						System.out.printf("scores[%d]> ", i);
						scores[i] = sc.nextInt();
					}
					break;
				case 3:
					for(int i=0; i<studentCount; i++) {
						System.out.printf("scores[%d] : %d\n", i, scores[i]);
					}
					break;
				case 4:
					max = scores[0];
					
					for(int i=0; i<studentCount; i++) {
						if(max < scores[i]) {
							max = scores[i];
						}
						sum += scores[i];
					}
					
					avg = (float)sum / scores.length;
					
					System.out.printf("최고 점수 : %d\n", max);
					System.out.printf("평균 점수 : %.1f\n", avg);
					break;
				case 5:
					System.out.println("프로그램 종료");
					break;
			}
			
			if(choice == 5) break;
		}
		
		sc.close();

	}

}
