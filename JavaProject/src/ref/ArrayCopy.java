package ref;

public class ArrayCopy {
	public static void main(String[] args) {
		// 배열의 복사
		// (1) 얕은 복사 : 객체를 새로 생성하는 것이 아니라 객체의 주소를 복사함
		// 변수의 이름만 다르고 같은 객체(배열)를 참조하게 됨
		// a 참조해서 수정하면 b를 통해 접근 시 결과 확인됨
		int a[] = {1, 2, 3, 4};
		int b[] = a; // a 참조변수에 저장된 참조 주소값이 b 변수에 저장됨
		
		// 변경 전 출력 - a, b 변수 출력값이 동일
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		for(int i=0; i<a.length; i++) {
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		// a 변수 변경 진행
		a[0] = 10;
		
		// 변경 후 출력
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		for(int i=0; i<a.length; i++) {
			System.out.print(b[i] + " ");
		}
		
		// 두 배열 변수가 동일한 배열 객체를 참조
		
		// (2) 깊은 복사
		// 1. 배열 객체를 새로 생성해서 원본의 원소를 하나씩 저장
		// Object.clone()
		// Arrays.copyOf()
		// Arrays.copyOfRange()
		// System.arraycopy()
		
		// 1
		int[] a1 = {1, 2, 3, 4};
		int[] b1 = new int[a1.length];
		
		// 각 원소 값을 하나씩 저장
		
		
		
	}

}
