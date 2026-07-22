package exam;

import java.util.Scanner;

public class WhileEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentCount, score;
		int i = 1;
		float total = 0;
		float avg;
		
		System.out.print("학생 수 입력 : ");
		studentCount = sc.nextInt();

		while (true) {
			System.out.print("학생" + i + " 점수 입력 : ");
			score = sc.nextInt();
			total += score;

			if (i == studentCount)
				break;

			i++;
		}

		avg = (float) (total / studentCount);

		System.out.println("평균 : " + avg);
		
		sc.close();

	}

}
