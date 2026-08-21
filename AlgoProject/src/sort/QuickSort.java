package sort;
/*
 * 퀵정렬
 * pivot이라는 기준값을 결정해서 pivot 기준 두 개의 부분 리스트로 나눔
 * 작은 / pivot / 큰
 * 비교하면서 데이터를 찾기 때문에 비교정렬
 * 정렬 대상 데이터 외에 추가적인 공간을 필요로 하지 않는다 : in-palce sort
 * 
 * 1. pivot 선택
 * 2. pivot 기준 왼쪽에서부터는 피벗보다 큰 값을 오른쪽에서부터는 피벗보다 작은값을 찾는다
 * 3. 양방향에서 찾아지면 교환한다
 * 4. 양쪽 위치 idx가 서로 교차되지 않을때까지 2,3번 반복
 * 5. 교차지점을 기준으로 두 개의 부분리스트로 나누고 각 부분리스트에 퀵정렬 과정(1~4)을 반복(Divide)
 * 6. 인접한 부분리스트끼리 합친다 (Conqure)
 * 
 * pivot 선택하는 방법
 * 현재 부분리스트
 */

public class QuickSort {
	public static void sort(int[] a) {
		l_pivot_sort(a, 0, a.length-1);
	}
	
	/*
	 * 왼쪽 피벗 선택 방식
	 * @param a : 정렬할 배열
	 * @param lo : 현재 부분 리스트 왼쪽 인덱스
	 * @param hi : 현재 부분 리스트 오른쪽 원소 인덱스
	 */
	
	private static void l_pivot_sort(int[] a, int lo, int hi) {
		if(lo >= hi) { // 정렬할 원소가 없거나 1개
			return;
		}
	}
}
