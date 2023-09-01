package bit701.day0901;

public class Ex1_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 대입 연산자 : =, +=, -=, /=, %=
		// 대입 연산자나 증감 연산자를 이용 시 해당 변수는 반드시 값이 들어있어야 한다.
		int a = 5;
		
		// a = a + 3;
		a += 3;	// 위 수식과 같음
		
		System.out.println(a);	// 8
		
		a -= 1;	// 1을 빼거나 더할 때는 a++, a-- 사용
		System.out.println(a);	// 7
		
		a *= 5;
		System.out.println(a); // 35
		
		a /= 3;
		System.out.println(a); // 11
		
		a %= 4;
		System.out.println(a); // 3
		
		
	}

}
