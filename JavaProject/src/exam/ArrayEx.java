package exam;

import java.util.Scanner;

public class ArrayEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name[] = new String[5];
		int gram[] = new int[5];
		int list[] = new int[5];
		int read[] = new int[5];
		String ch;
		int count = 0;
		int total = 0;
		int grade;
		
		System.out.println("*** 영어 시험 점수 입력 ***");
		
		while(true) {
			System.out.printf("%d번 성명 입력 : ", count+1);
			name[count] = sc.nextLine();
			System.out.printf("%d번 문법 점수 입력 : ", count+1);
			gram[count] = sc.nextInt();
			System.out.printf("%d번 듣기 점수 입력 : ", count+1);
			list[count] = sc.nextInt();
			System.out.printf("%d번 독해 점수 입력 : ", count+1);
			read[count] = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			System.out.print("계속 입력하시겠습니까? (y입력하면 계속)");
			ch = sc.nextLine();
			
			
			count++;
			
			if(!ch.equals("y")) break;
		}
		
		System.out.println("*** 영어 시험 결과 ***");
		
		for(int i=0; i<count; i++) {
			total = gram[i] + list[i] + read[i];
			
			switch(total / 100) {
				case 10:
				case 9:
				case 8:
					grade = 1;
					break;
				case 7:
				case 6:
					grade = 2;
					break;
				case 5:
				case 4:
					grade = 3;
					break;
				default:
					grade = 4;
					
			}
			
			System.out.printf("%d번 %s %d %d등급\n", i+1, name[i], total, grade);
		}
		
		sc.close();		
		
		
	}

}
