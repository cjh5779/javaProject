package exam;

public class Aarray2DEx2 {
	public static void main(String[] args) {
		int[][] score = {
	            {100, 100, 100},
	            {20, 20, 20},
	            {30, 30, 30},
	            {40, 40, 40},
	            {50, 50, 50}
	     };
		
		int korTotal = 0;
        int engTotal = 0;
        int mathTotal = 0;
        int sum = 0;
        float avg = 0;
        
        System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
        System.out.println("==============================================");
        
        for (int i = 0; i < score.length; i++) {
        	System.out.printf("%2d", i+1);
        	
        	for (int j = 0; j < score[i].length; j++) {
        		sum += score[i][j];
        		System.out.printf("\t%3d", score[i][j]);
        	}
        	
        	korTotal += score[i][0];
            engTotal += score[i][1];
            mathTotal += score[i][2];
            
            avg = (float)sum / score[i].length;
            
            System.out.printf("\t%3d\t%.1f\n", sum, avg);
        }
        
        System.out.println("==============================================");
        
        System.out.printf("총점 : \t%3d\t%3d\t%3d\n", korTotal, engTotal, mathTotal);
        
        
	}

}
