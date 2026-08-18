package datastructure.queue;

import java.util.Scanner;

public class QueueParking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("주차장을 구성합니다.");
        System.out.print("주차면을 입력하세요 : ");
        int capacity = sc.nextInt();
        sc.nextLine();

        MyQueueMove q = new MyQueueMove(capacity);
        
        char nextCarName = 'A';

        System.out.println(capacity + "대를 주차할 수 있는 주차장이 구성되었습니다.");
        System.out.println("자동차 주차 프로그램 실행 완료");

        while (true) {
            System.out.println("\n버튼을 눌러주세요.");
            System.out.println("0.주차가능여부 | 1.자동차 주차 | 2.자동차 출차 | 3.만차여부 | 4.종료");
            System.out.print("메뉴 선택 : ");
            
            String input = sc.nextLine();
            int menu = -1;

            try {
                menu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하셨습니다. 다시 재실행 해주세요.");
                continue;
            }

            switch (menu) {
                case 0:
                    int available = capacity - q.size();
                    System.out.println("현재 주차 가능한 여유 공간은 " + available + "대 입니다.");
                    q.showQueue(); // 현재 주차된 상태 출력
                    break;

                case 1:
                    if (q.size() == capacity) {
                        System.out.println("주차장이 만차입니다. 더 이상 주차할 수 없습니다.");
                    } else {
                        q.enqueue(nextCarName);
                        System.out.println(nextCarName + " 자동차 주차 완료");
                        nextCarName++; 
                    }
                    break;

                case 2:
                    if (q.size() == 0) {
                        System.out.println("현재 주차장에 차량이 없습니다.");
                        break;
                    }

                    System.out.print("출차할 차량의 고유문자를 입력하세요 (예: A) : ");
                    String carStr = sc.nextLine().toUpperCase();
                    if (carStr.isEmpty()) {
                        System.out.println("잘못된 입력입니다.");
                        break;
                    }
                    char target = carStr.charAt(0);

                    boolean found = false;
                    for (int i = 0; i < q.size(); i++) {
                        char temp = q.dequeue();
                        if (temp == target) {
                            found = true;
                        }
                        q.enqueue(temp);
                    }

                    if (!found) {
                        System.out.println("해당 차량(" + target + ")은 주차장에 없습니다.");
                        break;
                    }

                    if (q.peek() == target) {
                        q.dequeue();
                        System.out.println(target + " 자동차 출차 완료");
                    } else {
                        System.out.print("주차한 지 1시간이 경과했습니까? (Y/N): ");
                        String timePass = sc.nextLine();

                        if (timePass.equalsIgnoreCase("Y")) {
                            int currentSize = q.size();
                            char hold = ' ';
                            
                            for (int i = 0; i < currentSize; i++) {
                                char temp = q.dequeue();
                                if (temp == target) {
                                    hold = temp;
                                } else {
                                    q.enqueue(temp);
                                }
                            }
                            q.enqueue(hold);
                            
                            System.out.println("먼저 주차된 차가 있어 패널티가 적용되었습니다.");
                            System.out.println(target + " 차량의 출차 순서가 마지막으로 밀렸습니다.");
                        } else {
                            System.out.println("주차시간이 1시간 경과되지 않았으며, 먼저 주차한 차가 있어 출차할 수 없습니다.");
                        }
                    }
                    break;

                case 3:
                    if (q.size() == capacity) {
                        System.out.println("현재 주차장에 자동차 " + capacity + "대가 주차되어 있습니다. 만차입니다.");
                    } else {
                        System.out.println("현재 주차장에 자동차 " + q.size() + "대가 주차되어 있습니다. 여유공간이 존재합니다.");
                    }
                    break;

                case 4:
                    System.out.println("주차관리 프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다. 0~4번 사이의 번호를 입력해주세요.");
                    break;
            }
        }
    }
}