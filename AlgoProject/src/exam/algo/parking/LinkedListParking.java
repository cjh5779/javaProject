package exam.algo.parking;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> parkingLot = new LinkedList<>();

        System.out.println("주차장을 구성합니다.");
        System.out.print("주차면(가능대수)을 입력하세요: ");
        
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            scanner.next();
            System.out.print("주차면을 입력하세요: ");
        }
        int capacity = scanner.nextInt();
        System.out.println(capacity + "대를 주차할 수 있는 주차장이 구성되었습니다.\n");

        while (true) {
            System.out.println("\n--- 주차 관리 메뉴 ---");
            System.out.println("0. 주차여부 확인");
            System.out.println("1. 자동차 주차");
            System.out.println("2. 자동차 출차");
            System.out.println("3. 만차여부");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");

            String choice = scanner.next();

            switch (choice) {
                case "0":
                    System.out.print("확인할 자동차 고유문자 입력: ");
                    String checkCar = scanner.next();
                    if (parkingLot.contains(checkCar)) {
                        int position = parkingLot.indexOf(checkCar) + 1; 
                        System.out.println(checkCar + " 차량은 현재 주차되어 있습니다. (위치: " + position + "번째)");
                    } else {
                        System.out.println(checkCar + " 차량은 주차장에 없습니다.");
                    }
                    break;

                case "1":
                    if (parkingLot.size() >= capacity) {
                        System.out.println("주차장이 만차입니다. 입차를 제한합니다.");
                        break;
                    }
                    
                    System.out.print("주차할 자동차 고유문자 입력: ");
                    String newCar = scanner.next();
                    
                    if (parkingLot.contains(newCar)) {
                        System.out.println("이미 동일한 고유문자의 차량이 주차되어 있습니다.");
                        break;
                    }

                    System.out.print("주차 위치를 선택하세요 (1: 원하는 위치, 2: 마지막 위치): ");
                    String posChoice = scanner.next();
                    
                    if (posChoice.equals("1")) {
                        System.out.print("원하는 위치 (1 ~ " + (parkingLot.size() + 1) + ") 입력: ");
                        if (scanner.hasNextInt()) {
                            int pos = scanner.nextInt();
                            if (pos >= 1 && pos <= parkingLot.size() + 1) {
                                parkingLot.add(pos - 1, newCar);
                                System.out.println(newCar + " 차량이 " + pos + "번째 위치에 주차되었습니다.");
                            } else {
                                System.out.println("잘못된 위치입니다. 주차가 취소되었습니다.");
                            }
                        } else {
                            System.out.println("숫자를 입력해야 합니다. 주차가 취소되었습니다.");
                            scanner.next(); 
                        }
                    } else if (posChoice.equals("2")) {
                        parkingLot.add(newCar);
                        System.out.println(newCar + " 차량이 마지막 위치에 주차되었습니다.");
                    } else {
                        System.out.println("잘못된 선택입니다. 주차가 취소되었습니다.");
                    }
                    break;

                case "2":
                    if (parkingLot.isEmpty()) {
                        System.out.println("주차장이 비어있어 출차할 차량이 없습니다.");
                        break;
                    }
                    
                    System.out.print("출차할 자동차 고유문자 입력: ");
                    String outCar = scanner.next();
                    
                    if (parkingLot.remove(outCar)) {
                        System.out.println(outCar + " 자동차 출차 완료");
                    } else {
                        System.out.println(outCar + " 차량이 주차장에 존재하지 않아 출차할 수 없습니다.");
                    }
                    break;

                case "3":
                    int currentCount = parkingLot.size();
                    System.out.println("현재 주차장에 자동차 " + currentCount + "대가 주차되어 있습니다.");
                    if (currentCount >= capacity) {
                        System.out.println("현재 만차 상태입니다.");
                    } else {
                        System.out.println("여유 공간이 " + (capacity - currentCount) + "대 남았습니다.");
                    }
                    break;

                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return; 

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
                    break;
            }
        }
    }
}