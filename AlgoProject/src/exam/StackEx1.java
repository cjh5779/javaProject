package exam;

import java.util.Scanner;

public class StackEx1 {
	public static void main(String[] args) {
		/*
		 * 수식의 괄호 매칭 점검 프로그램
		 * 모든 괄호는 왼쪽 괄호가 나오고 오른쪽 괄호가 나옴
		 * 괄호는 가장 늦게 열린 괄호가 가장 먼저 닫힘
		 * ({[ ]})
		 * 
		 * 점검 1 : stack이 empty인데 ]}) 만나서 pop 호출
		 * 점검 2 : 수식의 괄호 검증이 끝났는데 스택이 비어있지 않은 경우
		 * 점검 3 : 스택에서 pop한 결과가 현재 보고있는 오른쪽 괄호가 아닐 때 - 괄호 짝이 안맞는 경우
		 */
		
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack(100);
		
		String correct = sc.nextLine();
		int answer = 0;
		char[] arr = correct.toCharArray(); // 문자열을 한 문자씩 저장된 char 배열로 반환
		
		for(char chr : arr) {
			stackPush(stack, chr);
			answer = check(stack, chr);
			if(answer != 0) break; 
		}
		if(stack.isEmpty() && answer == 0) {
			System.out.println("수식의 괄호가 모두 정상입니다");
		} else {
			System.out.println("수식 괄호에 오류가 있습니다");
		}
	}
	
	private static void stackPush(Stack stack, char c) {
		if((c == '(' || c == '{' || c == '[')) {
			stack.push(c);
		}
	}
	
	private static int check(Stack stack, char c) {
		if((c == ')' || c == '}' || c == ']')) {
			if(stack.isEmpty()) {
				return 1;
			} else {
				char p = stack.pop();
				if((p == '(' && c == ')') || (p == '{' && c == '}') || (p == '[' && c == ']')) {
					return 0;
				} else {
					return 3;
				}
			} 
		}
		return 0;
	}
}
