package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 증감 연산자 : ++(1씩 증가), --(1씩 감소)
		// 변수 앞에 붙일 경우 (전치) 1순위
		// 변수 뒤에 붙일 경우 (후치) 끝순위
		// 단, 단항으로 사용할 경우 상관없다.
		
		int a = 5;
		int b = 5;
		// 단항으로 연산할 경우
		++a; // 1 증가
		b++; // 1 증가
		System.out.println(a); 	// 6
		System.out.println(b); 	// 6
		System.out.println(++a);// 먼저 증가 후 출력 : 7
		System.out.println(b++);// 먼저 출력 후 증가 : 6
		System.out.println("a = "+ a + " b = "+ b ); // 7, 7
		
		a = b = 5;
		int m = ++a;	// 증가 후 대입
		int n = b++;	// 대입 후 증가
		System.out.printf("a = %d, b = %d, m = %d, n = %d \n", a, b, m, n);
	}

}
