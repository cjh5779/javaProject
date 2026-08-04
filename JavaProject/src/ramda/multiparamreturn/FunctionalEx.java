package ramda.multiparamreturn;

public class FunctionalEx {
	public static void main(String[] args) {
		// 함수형 인터페이스 구현 객체 구성(람다식)
		// 매개변수 없고 반환문 없는 람다식, 실행문자 2문자 이상
		MyFunctionalInterface fi = (int x, int y) -> {
			int result = x + y;
			return result;
		};

		fi.method(5, 6);

		fi = (x, y) -> { // 호출 시 대입되는 파라미터로 타입을 유추
			return x + y;
		};

		fi.method(5, 6);

		// 람다식 실행블럭이 return 한줄 문장이면 중괄호 return 생략 가능
		fi = (x, y) -> {
			return x + y;
		};

		fi.method(5, 6);

		// 매개변수가 2개 이상인 경우 소괄호 필요
		fi = (x, y) -> {
			return x + y;
		};

		fi.method(5, 6);
	}
}
