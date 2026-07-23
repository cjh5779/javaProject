package exam;

import java.util.Random;

public class ArrayEx3 {
	public static void main(String[] args) {
		Random rd = new Random();
		int num[] = new int[10];
		int count[] = new int[10];
		
		for(int i=0; i<num.length; i++) {
			num[i] = rd.nextInt(10) + 1;
			System.out.print(num[i]);
			
			count[num[i]]++;
		}
		
		System.out.println();
		
		for(int i=0; i<count.length; i++) {
			System.out.println(i + "의 개수 : " + count[i]);
		}
		
		
	}

}
