package sort;

public class MergeSort {
	// 정렬 동안에 정렬하여 원소를 담을 임시공간
	private static int[] sorted;
	
	public static void mergeSort(int a[]) {
		sorted = new int[a.length];
		mergeSort(a, 0, a.length-1);
		sorted = null;
	}
	
	private static void mergeSort(int[] a, int left, int right) {
		/*
		 * left == right 즉, 부분리스트가 1개의 원소만 갖고 있는 경우
		 * 더 이상 쪼갤 수 없을 때 return
		 */
		
		if(left == right) return;
		
		// 분할하고 결합하는 과정을 반복
		int mid = (left + right) / 2; // 절반 위치
		mergeSort(a, left, mid);
		mergeSort(a, mid+1, right);
		
		merge(a, left, mid, right); // 병합작업 메소드 호출
	}
	
	/*
	 * 결합할 부분 리스트는 a배열의 left ~ right 까지
	 * 
	 * a : 정렬할 배열
	 * left : 배열의 시작
	 * right : 배열 끝
	 * mid : 배열의 중간점
	 */
	
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left; // 왼쪽 부분리스트의 시작점
		int r = mid + 1; // 오른쪽 부분 리스트의 시작점
		int idx = left; // 정렬 결과를 넣은 idx
		
		// 각 부분리스트의 끝점을 지나지 않는동안 반복
		while(l <= mid && r <= right) {
			/*
			 * 왼쪽 부분 리스트의 첫번째 원소 값이 더 작으면 임시배열에 왼쪽 부분 리스트의 원소를 저장
			 */
			if(a[l]<=a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			} else {
				sorted[idx] = a[r];
				idx++;
				l++;
			}
		}
	}
}
