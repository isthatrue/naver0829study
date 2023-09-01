package bit701.day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *	구구단을 출력할 시작단 입력
		 *	4
		 *	구구단을 출력할 끝단 입력
		 *	6
		 *
		 *	4단		5단		6단		- 단일 for문
		 *	4x1=4	5x1=5	6x1=6	- 다중 for문
		 *	4x2=8	5x2=10	6x2=12
		 *
		 */
		Scanner sc = new Scanner(System.in);
		
		
		int start = 0;
		int end = 0;
		
		System.out.println("구구단을 출력할 시작단 입력");
		start = sc.nextInt();
		System.out.println("구구단을 출력할 끝단 입력");
		end = sc.nextInt();
		// start가 end보다 클 경우 두 변수의 값을 바꿔보자
		
		if (start > end) {
			int temp = start;	// start 값을 temp에 저장
			start = end;		// start는 비어 있는 상태, end 값을 start에 저장
			end = temp;			// end는 비어 있는 상태, temp 값을 end에 저장
		}
		
		
		for (int i = start; i <= end; i++) {
			System.out.printf("%7d단", i);
			
		}
		System.out.println();
		
		
//		for (int i = 1; i <= 9; i++) {
//			for (int j = start; j <= end; j++) {
//				System.out.printf("%dx%d=%d", j, i, j*i);
//			}
//			System.out.println(i);
//			System.out.println();
//		}
		
		for (int i = 1; i <= 9; i++) {
			for (int j = start; j <= end; j++) {
				System.out.printf("%5dx%d=%2d", j, i, j*i);
			}
		System.out.println();	
		}
		

	
	}

}
