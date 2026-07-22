package exam;

import java.util.Scanner;

public class ForEx5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentCount, score;
		float total = 0;
		float avg;
		
		System.out.print("학생 수 입력 : ");
		studentCount = sc.nextInt();
		
		for(int i=1; i<=studentCount; i++) {
			System.out.print("학생" + i + " 점수 입력 : ");
			score = sc.nextInt();
			total += score;
		}
		
		avg = (float)(total / studentCount);
		
		System.out.println("평균 : " + avg);
		
		sc.close();
		
	}

}
