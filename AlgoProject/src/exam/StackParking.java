package exam;

import java.util.Scanner;
import java.util.Stack;

public class StackParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> parkingLot = new Stack<>();

        System.out.println("주차장을 구성합니다");
        System.out.print("주차면을 입력하세요 : ");
        
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            scanner.next();
            System.out.print("주차면을 입력하세요 : ");
        }
        
        int capacity = scanner.nextInt();
        System.out.println(capacity + "대를 주차할 수 있는 주차장이 구성되었습니다\n");

        System.out.println("자동차 주차 프로그램 실행 완료");

        while (true) {
            System.out.println("\n버튼을 눌러주세요.");
            System.out.print("0.주차현황 / 1. 자동차 주차 / 2. 자동차 출차 / 3. 만차여부 / 4. 종료 : ");
            
            String choice = scanner.next();

            switch (choice) {
                case "0":
                    if (parkingLot.isEmpty()) {
                        System.out.println("주차된 차량이 없습니다.");
                    } else {
                        System.out.println("현재 주차 현황 (최근 주차된 차량이 나중에 출력됨): " + parkingLot);
                    }
                    break;

                case "1":
                    if (parkingLot.size() >= capacity) {
                        System.out.println("주차장이 만차입니다. 더 이상 주차할 수 없습니다.");
                    } else {
                        System.out.print("주차할 자동차 이름 입력: ");
                        String carName = scanner.next();
                        parkingLot.push(carName);
                        System.out.println(carName + " 자동차 주차 완료");
                    }
                    break;

                case "2":
                    if (parkingLot.isEmpty()) {
                        System.out.println("주차장이 비어있어 출차할 차량이 없습니다.");
                    } else {
                        String outCar = parkingLot.pop();
                        System.out.println(outCar + " 자동차 출차 완료");
                    }
                    break;

                case "3":
                    int currentCount = parkingLot.size();
                    System.out.print("현재 주차장에 자동차 " + currentCount + "대가 주차되어 있습니다.");
                    if (currentCount >= capacity) {
                        System.out.println("만차입니다.");
                    } else {
                        System.out.println("여유공간이 존재합니다.");
                    }
                    break;

                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다.다시 재실행 해주세요.");
                    break;
            }
        }
    }
}
