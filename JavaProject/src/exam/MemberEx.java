package exam;

import java.util.Scanner;

public class MemberEx {
	public static void main(String[] args) {
		Member member1 = new Member("hkd", "홍길동", 30, "010-1234-5678", "서울시 강남구 대치동");
        member1.showMember();

        System.out.println("--------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        
        System.out.print("아이디 입력 : ");
        String id = sc.next();
        
        System.out.print("성명 입력 : ");
        String name = sc.next();
        
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        
        System.out.print("전화번호 입력 : ");
        String phone = sc.next();
        
        System.out.print("주소 입력 : ");
        String address = sc.next(); 

        Member member2 = new Member(id, name, age, phone, address);
        member2.showMember();
        
        sc.close();
	}

}
