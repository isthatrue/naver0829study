package bit701.day0908;

import bit701.day0908hello.*;

public class Ex1_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHello my = new MyHello();
		my.hello();
		
		// 같은 패키지에 있는 클래스 선언
		Test t = new Test();
		System.out.println("public 멤버 변수 출력"+t.str1);
		System.out.println("protected 멤버 변수 출력"+t.str2);
		System.out.println("default 멤버 변수 출력"+t.str3);
		// System.out.println("private 멤버 변수 출력"+t.str4);		// 에러 발생 - 접근 안됨
		
	}

}
