package bit701.day0901;

public class Ex4_BreakContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a = 1; a <= 10; a++) {
			System.out.printf("%3d", a);
				// break;	 // 5 출력 전 반복문을 빠져나간다.
			if (a == 5)
				break;	// 5 출력 후 반복문을 빠져나간다.
		}
		System.out.println();
		System.out.println("-".repeat(30));

		
		for (int a = 1; a <= 10; a++) {
			if (a % 2 == 1)
				continue;	// a++ 증감식으로 이동
			System.out.printf("%3d", a);
		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		// 다중 for문의 경우 한꺼번에 2개의 반복문을 빠져나가고자 할 경우
		Exit:	// 레이블(label)명은 자기 마음대로 지정
		for (int i = 1; i <= 3; i++) {
			System.out.println("i = " + i);
			
			for (int j = 1; j <= 5; j++) {
				System.out.printf("%3d", j);
				if (j == 3)
					break Exit;	// j가 3이 될 경우 모든 반복문을 빠져나간다.
			}
			
			System.out.println();	
		}
		
		System.out.println("-".repeat(30));
	}
	

}
