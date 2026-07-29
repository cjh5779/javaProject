package exam.game_project.start;

// import를 통해 다른 패키지에 있는 클래스 사용 가능
import exam.game_project.game.*;
import exam.game_project.game.GaBaBo;
import exam.game_project.game.Guess;

import exam.game_project.info.AppInfo;


public class AppStart {
	public static void main(String[] args) {
		// 프로그램 시작과 끝
		// 게임 웰컴문구
		// 메뉴 출력
		// 1. 게임정보 2. 가위바위보게임 3. 숫자 알아맞히기 게임 4. 종료
		
		// 메뉴 선택
		
		// 선택된 메뉴의 기능을 수행
		
		// 종료는 종료 메뉴를 선택할 때 종료
		
		System.out.println("******************************************");
        System.out.println("     ★★게임에 오신 것을 환영합니다^^     ");
        System.out.println("******************************************");
        
        while(true) {
        	System.out.println("                   메뉴                   ");
            System.out.println("------------------------------------------");
            System.out.println("1. 애플리케이션 정보");
            System.out.println("2. 가위바위보 게임");
            System.out.println("3. 숫자 알아맞히기 게임");
            System.out.println("4. 종료");
            System.out.println("------------------------------------------");
            System.out.print("메뉴 번호 입력 : ");
        }
		
		
	}

}
