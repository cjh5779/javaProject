package exam;

import java.util.Scanner;

public class ControlEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int notebook = 1200000;
		int digitercamera = 400000;
		int productId, quantity, totalPrice, discountAmount = 0, finalPrice;
		
		System.out.println("******* 상품 정보 *******");
		System.out.println("1 노트북 : " + notebook + " 원");
		System.out.println("2 디지털카메라 : " + digitercamera + " 원");
		System.out.println("**********************");
		
		System.out.print("상품번호 입력 : ");
		productId = sc.nextInt();
		if(productId == 1 || productId == 2) {
			System.out.print("주문 수량 입력 : ");
			quantity = sc.nextInt();
			
			System.out.println("******* 주문 내용 *******");
			if (productId == 1) {
				System.out.println("상품명 : 노트북");
				System.out.println("가격 : " + notebook + " 원");
				System.out.println("주문 수량 : " + quantity + " 개");
				totalPrice = notebook * quantity;
				System.out.println("주문액 : " + totalPrice);
				if (totalPrice >= 1000000) {
					discountAmount = (int) (totalPrice * 0.1);
					System.out.println("할인액 : " + discountAmount);
				} else if (totalPrice < 1000000 && totalPrice < 500000) {
					discountAmount = (int) (totalPrice * 0.05);
					System.out.println("할인액 : " + discountAmount);
				}
				finalPrice = totalPrice - discountAmount;
				System.out.println("총 지불액 : " + finalPrice);
			} else if (productId == 2) {
				System.out.println("상품명 : 디지털카메라");
				System.out.println("가격 : " + digitercamera + " 원");
				System.out.println("주문 수량 : " + quantity + " 개");
				totalPrice = digitercamera * quantity;
				System.out.println("주문액 : " + totalPrice + " 원");
				if (totalPrice >= 1000000) {
					discountAmount = (int) (totalPrice * 0.1);
					System.out.println("할인액 : " + discountAmount + " 원");
				} else if (totalPrice < 1000000 && totalPrice < 500000) {
					discountAmount = (int) (totalPrice * 0.05);
					System.out.println("할인액 : " + discountAmount + " 원");
				}
				finalPrice = totalPrice - discountAmount;
				System.out.println("총 지불액 : " + finalPrice + " 원");
			}
		} else {
			System.out.println("잘못 입력하였습니다. 종료합니다.");
		}
		
		System.out.println("**********************");
		
		sc.close();
		
	}

}
