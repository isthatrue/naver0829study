package bit701.day0905;

import java.util.Scanner;

public class KeyControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean run = true;		// while 문의 조건식을 위한 변수 선언
		int speed = 0;
		
		while(run) {			// run의 변수의 값에 따라 while문의 반복 여부가 결정됨
			System.out.println("----------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("----------------------------");
			System.out.print("선택 : ");
			
			String strNum = scanner.nextLine();
			
			if (strNum.equals("1")) {
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if (strNum.equals("2")) {
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if (strNum.equals("3")) {
				run = false;		// while 문의 조건식을 false로 만듦
			}	
		}
		
		System.out.println("프로그램 종료");
	}

}
