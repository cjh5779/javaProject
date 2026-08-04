package exam.collection;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> dictionary = new HashMap<>();
		
		while(true) {
			System.out.print("영어 단어 입력 : ");
			String eng = sc.next();
			
			if(eng.equals("stop")) {
				break;
			}
			
			System.out.print("한글 뜻 입력 : ");
			String kor = sc.next();
			
			dictionary.put(eng, kor);
		}
		
		while(true) {
			System.out.print("찾고 싶은 단어는? ");
			String searchWord = sc.next();
			
			if(searchWord.equals("exit")) {
				System.out.println("종료합니다...");
				break;
			}
			
			if(dictionary.containsKey(searchWord)) {
				System.out.println(dictionary.get(searchWord));
			} else {
				System.out.println(searchWord + "는 없는 단어 입니다.");
			}
		}
		
		sc.close();
		
	}

}
