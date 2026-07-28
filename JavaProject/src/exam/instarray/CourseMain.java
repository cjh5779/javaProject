package exam.instarray;

public class CourseMain {
	public static void main(String[] args) {
		Course[] course = new Course[3];
		
		System.out.println("****과목 정보 입력****\n");
		
		for (int i = 0; i < course.length; i++) {
            course[i] = new Course();
            course[i].input();
        }
		
		System.out.println("**** 과목 정보 출력 ****");
		
		for(int i=0; i<course.length; i++) {
			course[i].output();
		}
	}

}
