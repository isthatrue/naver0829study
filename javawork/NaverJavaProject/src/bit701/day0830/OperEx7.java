package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 비교 연산자와 논리 연산자, 결과 값은 무조건 참(true), 거짓(false)
		int kor = 100, eng = 90, mat = 100;
		System.out.println(kor>=80);	// true
		System.out.println(kor>=80 || kor != mat);	// true	
		System.out.println(kor<80 || kor != mat);	// false
		System.out.println(kor>=80 && kor != mat);	// false
		System.out.println(kor<80 && kor != mat);	// false
		System.out.println(!(kor==mat));			// false
		System.out.println(kor>=95 && eng>=95 && mat>=95);	// false
		System.out.println(kor>=95 && eng>=95 || mat>=95);	// true
		System.out.println(kor>=95 || eng>=95 && mat>=95);	// true
		System.out.println();
		System.out.println(kor<=20 || eng >=60 || mat <=50); // true
		System.out.println(kor<=20 && eng >=60 || mat <=50); // false
		System.out.println(kor<=20 || eng >=60 && mat <=50); // false
		System.out.println(kor<=20 && eng >=60 && mat <=50); // false
		
		
		int year = 2023;
		System.out.println(year%4==0 && year%100!=0 || year%400==0);
		
	}

}
