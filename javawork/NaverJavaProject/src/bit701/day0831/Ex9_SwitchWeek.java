package bit701.day0831;

import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 연도와 월일 입력하면 며칠까지 있는지 출력해 보자.
		// 일단 해당 연도가 윤년인지 아닌지부터 판단해 보자.
		System.out.println("연도 4자리 숫자 입력");
		int year = sc.nextInt();
		System.out.println("월(1~12) 입력");
		int month = sc.nextInt();
		
		// 잘못 월을 입력한 경우 종료한다.
		if (month < 1 || month > 12) {
			System.out.println("월을 잘못 입력했어요!!");
			return;
		}
		
		System.out.printf("입력한 연도와 월 : %d년 %d월 ", year, month);
		int days = 0;
		boolean b = year%4==0 && year%100!=0 || year%400==0;
//		if (b==true) System.out.println("윤년");
		if (b) System.out.println("(윤년)\n");	// 조건에서 true는 생략 가능 (b==false의 경우에는 !b로 표시 가능)
		else System.out.println("(평년)\n");
		
		switch (month) {
		case 2:
			days = b?29:28;	// b가 true면 윤년이므로 29일, 아닐 경우 평년이므로 28을 days에 저장
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
		}
		
		System.out.printf("%d년 %d월 %d일까지 있어요!!\n", year, month, days);
		
	}

}
