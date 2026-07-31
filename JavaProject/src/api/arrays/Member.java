package api.arrays;

public class Member implements Comparable<Member>{
	String name;
	
	Member(String name) {
		this.name = name;
	}

	// compareTo 리턴값
	// - 오름차순일 때 자신이 매개값보다 늦을 경우 음수, 같은 경우 0, 높으면 양수 반환
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
}
