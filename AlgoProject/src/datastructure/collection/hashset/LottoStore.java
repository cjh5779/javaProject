package datastructure.collection.hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoStore {
	Scanner scan = new Scanner(System.in);
	
	// 메뉴를 출력하고 실행할 메뉴 번호 입력 반환하는 메소드
	public int displayMenu() { // 대소문자 수정 (displaymenu -> displayMenu)
		System.out.println("============================");
		System.out.println("==== Lotto 프로그램 ====");
		System.out.println("============================");
		System.out.println("1. Lotto 구입 2. 프로그램 종료");
		System.out.println("============================");
		System.out.print("메뉴 선택 : "); // 사용자 입력을 위한 안내 추가
		int num = scan.nextInt();
		return num;
	}
	
	public void lottoStoreStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1: // Lotto 구입
				buyLotto();
				break;
			case 2: // 프로그램 종료
				System.out.println();
				System.out.println("프로그램을 종료합니다.");
				return; // break 대신 return을 사용하여 while 루프 및 메서드 완전 종료
			default:
				System.out.println("메뉴를 다시 선택하세요. 번호가 없습니다");
			}
		}
	}
	
	// 로또 구매 메소드
	public void buyLotto() {
		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("Lotto 한 장 1000원");
		System.out.print("금액 입력 : ");
		int money = scan.nextInt();
		
		if(money < 1000) {
			System.out.println("금액이 모자랍니다. 로또 구입 실패!");
			return;
		} else if(money >= 1001000) {
			System.out.println("입력 금액이 너무 많습니다. 로또 구입 실패!");
			return;
		}
		
		getLotto(money); // 로또 생성 메소드
		
		System.out.println("받은 금액은 " + money + "원이고, 거스름돈은 " + (money % 1000) + "원 입니다");
	}
	
	public void getLotto(int money) {
		Set<Integer> lottoSet = new HashSet<>();
		
		int num = money / 1000; // 로또 구매 개수
		System.out.println();
		System.out.println("로또는 아래와 같습니다.");
		
		// 반복 횟수 수정: i=1부터 num까지 (1000원이면 1번 반복)
		for(int i = 1; i <= num; i++) {
			while(lottoSet.size() < 6) {
				lottoSet.add((int)(Math.random() * 45 + 1));
			}
			ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
			Collections.sort(lottoList);
			System.out.println("로또번호 " + i + " : " + lottoList);
			lottoSet.clear(); // 다음 로또 생성을 위해 Set 비우기
		}
	}
	
	public static void main(String[] args) {
		// 프로그램 실행을 위한 객체 생성 및 시작 메서드 호출
		LottoStore store = new LottoStore();
		store.lottoStoreStart();
	}
}