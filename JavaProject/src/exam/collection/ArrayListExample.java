package exam.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> wordList = new ArrayList<>();
		
		for(int i=0; i<4; i++) {
			System.out.print("단어를 입력하세요>>");
			String word = sc.next();
			wordList.add(word);
		}
		
		System.out.println("--------------------------------");
		
		for(String word : wordList) {
			System.out.print(word + " ");
		}
		
		System.out.println();
		
		String longStr = wordList.get(0);
		
		for(int i=1; i<wordList.size(); i++) {
			String currentStr = wordList.get(i);
			
			if(currentStr.length() > longStr.length()) {
				longStr = currentStr;
			}
		}
		
		System.out.println("가장 긴 단어는 : " + longStr);
		System.out.println("가장 긴 단어의 길이는 : " + longStr.length());
		
		sc.close();
	}
}
