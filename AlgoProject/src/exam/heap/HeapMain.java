package exam.heap;

import java.util.Arrays;

public class HeapMain {
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();
		
		Integer[] arr = {2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
		System.out.println("정렬 전: " + Arrays.toString(arr));
		
		Object[] sortedArr = heap.sort(arr);
		
		System.out.println("정렬 후: " + Arrays.toString(sortedArr));
	}

}
