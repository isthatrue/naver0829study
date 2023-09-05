package bit701.day0905;

import java.util.Scanner;


public class Ex0_Study_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean atm = true;		// while 문의 조건식을 위한 변수 선언
		int total = 0;
		int money = 0;
		
		
		Exit:
		while(atm) {
			System.out.println("------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			
//			String select = scanner.nextLine();
//			int num = Integer.valueOf(select);
			
			int num = scanner.nextInt();
			
			if (num < 1 || num > 4) {
				System.out.println("다시 입력해주세요");
				continue;
			}
			
			switch (num) {
			case 1:
				System.out.print("예금액> ");
				money = scanner.nextInt();
				System.out.println();
				total+=money;
				break;
			
			case 2:
				System.out.print("출금액> ");
				money = scanner.nextInt();
				System.out.println();
				total-=money;
				break;
				
			case 3:
				System.out.println("잔고> "+ total);
				break;
				
			case 4:
				atm = false;
				break;
				}
	
		}
		System.out.println("프로그램 종료");
	
	}
}
