package bit701.day0830;

public class DataEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1 = 0xa3; // 16진수 a3는 10 * 16^1승 + 3 = 163
		System.out.println(a1);
		int a2 = 0xf4; // 16진수 f5는 15 * 16^1 + 4 = 244
		System.out.println(a2);
		int a3=0xa56;	// 16진수 a56은 10 * 16^2 + 5 * 16^1 + 6
		System.out.println(a3);
		
		
		// 8진수
		int a4 = 045;	// 앞에 0을 붙이면 8진수로 인식한다 : 4 * 8 + 5
		System.out.println(a4);
	}

}
