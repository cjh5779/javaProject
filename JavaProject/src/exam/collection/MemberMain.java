package exam.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IMemberDAO dao = new MemberDAO();
		
		while(true) {
			System.out.println("**** 1.회원정보 입력 | 2. 회원정보 삭제 | 3. 전체 회원 조회 | 4. 회원 조회 | 5. 회원 정보 수정 | 6. 종료***");
			System.out.println("메뉴를 선택하세요 : ");
			int menu = sc.nextInt();
			
			if (menu == 1) {
				System.out.println("회원정보를 입력합니다");
				System.out.println("id 입력 : ");
				String id = sc.next();
				System.out.println("pass 입력 : ");
				String pass = sc.next();
				System.out.println("이름 입력 : ");
				String name = sc.next();
				System.out.println("전화번호 입력 : ");
				String phone = sc.next();
				
				sc.nextLine(); // 버퍼 비우기 (주소의 공백 입력을 위해 필수)
				
				System.out.println("주소 입력 : ");
				String address = sc.nextLine(); 
				
				MemberDTO memDto = new MemberDTO(id, pass, name, phone, address);
				dao.insertMember(memDto);
				
			} else if (menu == 2) {
				System.out.println("회원정보를 삭제합니다");
				System.out.println("id 입력 : ");
				String id = sc.next();
				dao.deleteMember(id);
				
			} else if (menu == 3) {
				System.out.println("전체 회원정보를 조회합니다");
				ArrayList<MemberDTO> list = dao.getAllMember();
				
				if (list == null || list.isEmpty()) {
					System.out.println("조회할 회원 정보가 없습니다");
				} else {
					for (MemberDTO m : list) {
						System.out.println(m.getMemId() + "\t" + m.getMemPass() + "\t" + m.getMemName() + "\t" + m.getMemPhone() + "\t" + m.getMemAddress());
					}
				}
				
			} else if (menu == 4) {
				System.out.println("회원정보를 조회합니다");
				System.out.println("id 입력 : ");
				String id = sc.next();
				
				MemberDTO memDto = dao.searchMember(id);
				if (memDto != null) {
					System.out.println(memDto.getMemId() + "\t" + memDto.getMemPass() + "\t" + memDto.getMemName() + "\t" + memDto.getMemPhone() + "\t" + memDto.getMemAddress());
				} else {
					System.out.println("해당 id 정보가 없습니다");
				}
				
			} else if (menu == 5) {
				System.out.println("회원정보를 수정합니다");
				System.out.println("수정 회원 id 입력 : ");
				String id = sc.next();
				
				MemberDTO m = dao.searchMember(id);
				if (m != null) {
					System.out.println("기존 정보 출력");
					System.out.println(m.getMemId() + "\t" + m.getMemPass() + "\t" + m.getMemName() + "\t" + m.getMemPhone() + "\t" + m.getMemAddress());
					
					System.out.println("pass 입력 : ");
					String pass = sc.next();
					System.out.println("이름 입력 : ");
					String name = sc.next();
					System.out.println("전화번호 입력 : ");
					String phone = sc.next();
					
					sc.nextLine(); // 버퍼 비우기
					
					System.out.println("주소 입력 : ");
					String address = sc.nextLine();
					
					MemberDTO updateDto = new MemberDTO(id, pass, name, phone, address);
					dao.updateMember(updateDto);
				} else {
					System.out.println("해당 id 정보가 없습니다");
				}
				
			} else if (menu == 6) {
				System.out.println("회원 관리 프로그램을 종료 합니다");
				break;
			}
		}
		
		sc.close();
	}
}