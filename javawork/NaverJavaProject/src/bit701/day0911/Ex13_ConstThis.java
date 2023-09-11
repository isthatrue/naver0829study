package bit701.day0911;

import java.nio.channels.WritableByteChannel;

/*
 *	this : 자기 자신을 의미하는 인스턴스 변수(iv)
 *		인스턴스 멤버 메소드는 this라는 변수를 기본적으로 가지고 있다.
 *	this() : 생성자에서 다른 생성자 호출 시 사용하는 이름이다.
 */
class Kiwi {
	String name;
	int age;
	
	Kiwi() {
//		System.out.println("생성자 호출");
		this("홍길동", 20);		// 3번째 생성자가 호출된다.
	}
	
	Kiwi(String name) {
		this(name, 30);			// 3번째 생성자가 호출된다.
		
	}
	
	Kiwi(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void writeData() {
		System.out.println("name: " + name + "\tage : " + age);
	}
}

public class Ex13_ConstThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kiwi[] karr = {
			new Kiwi(),
			new Kiwi("kim"),
			new Kiwi("Lee",35)
		};
		for (Kiwi k : karr)
			k.writeData();
	}

}
