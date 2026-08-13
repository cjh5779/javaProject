package recursion;

public class Recurision1 {
	// sum(n) = n+(n-1)+(n-2)+(n-3)+...+1
	// sum(5) = 5+sum(4)
	// sum(4) = 4+sum(3)
	// sum(3) = 3+sum(2)
	// sum(2) = 2+sum(1)
	// sum(1) = 1+0
	// sum(0) : return 0
	
	public static void main(String[] args) {
		System.out.println(sum(10));
	}
	
	static int sum(int n) {
		if(n == 0) {
			return 0;
		} else {
			return n+sum(n-1);
		}
		
	}

}
