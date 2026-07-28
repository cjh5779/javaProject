package exam.instarray;

import java.util.Scanner;

public class CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Customer[] customers = new Customer[3];

		System.out.println("****고객 정보 입력****");

		for (int i = 0; i < customers.length; i++) {
			System.out.print("고객번호 : ");
			String customerNo = scanner.next();

			System.out.print("고객명 : ");
			String customerName = scanner.next();

			System.out.print("전화번호 : ");
			String phoneNumber = scanner.next();

			System.out.print("직업 : ");
			String job = scanner.next();

			System.out.print("성별 : ");
			String gender = scanner.next();

			System.out.print("나이 : ");
			int age = scanner.nextInt();
			System.out.println();

			customers[i] = new Customer(customerNo, customerName, phoneNumber, job, gender, age);
		}

		System.out.println("***고객 정보 출력***");

		for (int i = 0; i < customers.length; i++) {
			customers[i].showCustomerInfo();
		}

		scanner.close();
	}

}
