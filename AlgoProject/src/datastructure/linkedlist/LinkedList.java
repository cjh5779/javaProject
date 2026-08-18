package datastructure.linkedlist;

public class LinkedList {
	private ListNode head;
	
	// 생성자
	public LinkedList() {
		head = null;
	}
	
	// Node 삽입 (마지막에 삽입)
	public void insertNode(String data) {
		ListNode newNode = new ListNode(data);
		
		if(head == null) { // List에 노드가 없는 경우
			this.head = newNode;
		} else { // List에 노드가 1개 이상 있는 경우 - 마지막 노드를 찾아서 연결
			ListNode tempNode = head;
			while(tempNode.link != null) {
				tempNode = tempNode.link;
			}
			// 마지막 노드를 찾았으면 link에 새로운 노드 참조
			tempNode.link = newNode;
		}
	}
	
	// 노드 중간에 새로운 노드 삽입 (preNode 뒤에 삽입)
	public void insertNode(ListNode preNode, String data) {
		if (preNode == null) {
			System.out.println("오류: 기준 노드(preNode)가 null입니다.");
			return;
		}
		
		ListNode newNode = new ListNode(data);
		newNode.link = preNode.link; // 나머지 리스트를 새 노드에 연결
		preNode.link = newNode;      // 이전 노드에 새 노드 연결
	}
	/// Node 삭제
	
	// 마지막 노드 삭제(data 상관 없이 무조건 마지막 노드 삭제)
	public void deleteNode(String data) {
		ListNode preNode; // 마지막 노드 이전 노드
		ListNode tempNode; // 마지막 노드
		
		if(head == null) return;
		
		// 노드가 1개인 경우
		if(head.link == null) {
			head = null;
		} else { // 2개 이상인 경우 마지막 노드 찾아야 함 (마지막 노드의 링크는 null)
			preNode = head;
			tempNode = head.link;
			
			while(tempNode.link != null) {
				
			}
			
			// 반복이 종료되면 마지막노드는 tempNode가 참조 마지막 이전 노드는 preNode가 참조
			// preNode.link를 null로 설정해서 tempNode가 참조하는 노드의 연결을 끊는다
			preNode.link = null;
		}
	}
	
	public ListNode searchNode(String data) {
		ListNode tempNode = this.head;
		
		while(tempNode != null) { // 다음 노드가 있는 동안 반복
			if(data.equals(tempNode.getData())) {
				// data 탐색되면 탐색된 node의 참조 주소가 반환됨
				return tempNode;
			} else {
				tempNode = tempNode.link;
			}
		}
		return tempNode;
	}
	
	// 테스트용: 리스트의 모든 노드를 출력하는 메서드 (추가)
	public void printList() {
		ListNode tempNode = this.head;
		
		// head부터 시작하여 마지막 노드까지 순회하면서 출력
		while(tempNode != null) {
			System.out.println(tempNode.getData() + " ");
			tempNode = tempNode.link;
		}
		
		System.out.println();
		
	}
}