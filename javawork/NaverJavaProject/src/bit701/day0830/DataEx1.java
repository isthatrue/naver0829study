package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("apple\t");
		System.out.print("banana\t");
		System.out.println("oragne\n");
		
		// printf : 변환기호에 의한 출력, 정수:%d, 실수:%f, 문자:%c, 문자열:%s
		int age = 23;
		double weight = 56.7;
		char blood = 'A';
		String name = "캐서린";
		System.out.printf("이름 : %s\n\n", name);
		System.out.printf("나이 : %d세\n\n", age);
		System.out.printf("몸무게 :%5.1fKg\n\n", weight); // %5.1f : 전체자리수:5, 소수점자리수:1
		System.out.printf("혈액형 : %c형\n\n", blood);
		System.out.println("=====================\n");
		System.out.printf("이름:%s\n나이:%d세\n몸무게:%5.1fKg\n혈액형:%c형", name, age, weight, blood);
	}

}
