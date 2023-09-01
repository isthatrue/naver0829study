package bit701.day0901;

import java.util.Scanner;

public class Ex5_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 숫자 n을 입력받은 후 1부터 n까지의 총합계를 출력하시오. (단일 for문)
		/* 2. 구구단 숫자 2 ~ 9 사이의 숫자를 입력받은 후 범위를 벗어날 경우
		 * 		"잘못 입력하여 종료합니다"라고 종료!
		 * 		제대로 입력 시 해당 구구단 출력
		 * 
		 *		** 5단 **
		 *		5 X 1 = 5
		 *		5 X 2 = 5
		 *		.
		 * 		.
		 * 		5 X 9 = 5
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		
		
		/* 1번
		int num = 0;
		int sum = 0;
		System.out.printf("숫자를 입력하시오 : ");
		num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			sum+=i;
		}
		System.out.printf("1부터 %d까지의 합은 %d입니다.", num, sum);
		*/
		
		
		
		// 2번
		int dan = 0;
		System.out.printf("숫자를 입력하시오 : ");
		dan = sc.nextInt();
		if (dan < 2 || dan > 9)	{
			System.out.println("잘못된 숫자입니다");
			return;
		}
		System.out.println("** " + dan + "단 **\n");
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d X %d = %2d\n", dan, i, dan*i);
		}
		
		
		
		
	}

}
