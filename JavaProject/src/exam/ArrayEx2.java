package exam;

import java.util.Random;

public class ArrayEx2 {
	public static void main(String[] args) {
		Random rd = new Random();
		int num[] = new int[6];
		
		for(int i=0; i<num.length; i++) {
			num[i] = rd.nextInt(45) + 1;
			System.out.print(num[i] + " ");
		}
		
	}

}
