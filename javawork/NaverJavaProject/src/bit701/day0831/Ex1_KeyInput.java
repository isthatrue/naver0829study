package bit701.day0831;

import java.util.Scanner;

public class Ex1_KeyInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// static 변수나 메소드는 new로 객체 생성하지 않고 호출한다.
		// 대표적으로 Math 클래스의 모든 메소드는 static이다.
		System.out.println("3의 5승 : " + (int)Math.pow(2, 2)); // 기본 값 double
		System.out.println("5, 7 중 더 큰 값은? " + Math.max(5, 7));
		
		// new로 객체를 생성, 이 변수를 인스턴스 변수라고 한다.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 나이를 입력하세요.");
		int age = sc.nextInt();
		System.out.println("응 나는 "+ age +"세야");
		
		// 숫자 입력 후 문자열을 입력 받는 경우 입력 안되는 현상 발생
		// 숫자 입력 후 발생하는 엔터값이 버퍼에 저장되는데 문자열 입력 시 
		// 이 버퍼를 먼저 읽고 없을 경우 키보드로 읽는다.
		
		// 방법1 : 버퍼의 엔터문자를 먼저 읽어서 없앤다.
		sc.nextLine();
		// 방법2 : 숫자를 읽을 경우도 무조건 nextLine으로 문자열로 입력 후 변환해서 사용한다.
		
		
		System.out.println("이름을 입력하세요..");
		String name = sc.nextLine();
		System.out.println("내 이름은 "+name+"입니다.");
		
		
	}
	
}