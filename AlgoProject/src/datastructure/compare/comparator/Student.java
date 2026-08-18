package datastructure.compare.comparator;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	// age 값으로 대소 비교
	int age;
	int classNumber; // 반 번호로 대소 비교
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compare(Student o1, Student o2) { // 기준 o1, 비교대상 o2
		return this.age - o.age;
	}

}
