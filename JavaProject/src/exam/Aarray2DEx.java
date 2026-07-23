package exam;

import java.util.Scanner;

public class Aarray2DEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] words = {{"chair", "의자"}, {"computer", "컴퓨터"}, {"integer", "정수"}};
		String answer;
		
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은? : ", i+1, words[i][0]);
			answer = sc.nextLine();
			
			if(answer.equals(words[i][1])) {
				System.out.println("정답입니다.");
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다.\n", words[i][1]);
			}
			
			System.out.println();
			
		}
		
		sc.close();
		
	}

}
