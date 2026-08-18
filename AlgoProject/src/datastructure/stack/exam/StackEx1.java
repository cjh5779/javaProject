package datastructure.stack.exam;

import java.util.Scanner;

import datastructure.stack.Stack;

public class StackEx1 {
	public static boolean check(String exp) {
		Stack stack = new Stack(exp.length());
		
		for(int i=0; i<exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if(ch == '(' | ch == '{' | ch == '[') {
				stack.push(ch);
			} else if(ch == ')' | ch == '}' | ch == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				
				char openExp = stack.pop();
				
				if((ch == ')' && openExp != '(') ||
					(ch == '}' && openExp != '{') ||
					(ch == ']' && openExp != '[')) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수식을 입력하세요 : ");
		String ex = sc.nextLine();
		
		boolean result = check(ex);
		
		System.out.println(result);
		
		sc.close();
	}
}
