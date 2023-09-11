package bit701.day0911;

import java.util.Scanner;

// 교재 클래스부분 20번 문제
public class Book_BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] account = new Account[10];
		Scanner sc = new Scanner(System.in);
		int count = 0;
		// 배열 10개가 꽉차면 "더이상 계좌생성이 안됩니다" 라고 출력
	
		while(true) {
			boolean noCheck;
			int money = 0;
			String accountNo = "";	// 계좌번호
			String accountName = "";	// 계좌주
			System.out.println("-".repeat(55));
			System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("-".repeat(55));
			System.out.print("선택> ");
			int num = Integer.parseInt(sc.nextLine());
			if (num == 5) {
				System.out.println("프로그램 종료!");
				break;
			}
	
			switch(num) { 
				case 1:
					if (count >= 10) {
						System.out.println("더 이상 계좌 생성이 안됩니다.");
						break;
					}
						
					System.out.println("-".repeat(10));
					System.out.println("계좌 생성");	
					System.out.println("-".repeat(10));
					System.out.print("계좌번호 : ");
					accountNo = sc.nextLine();
					System.out.print("계좌주 : ");
					accountName = sc.nextLine();
					System.out.print("초기 입금액 : ");
					money = Integer.parseInt(sc.nextLine());
					System.out.println("계좌가 생성되었습니다.\n");
					account[count] = new Account(accountNo, accountName, money);
					count++;
					break;
				case 2:
					System.out.println("-".repeat(10));
					System.out.println("계좌 목록");	
					System.out.println("-".repeat(10));
					for (int i=0; i<count; i++)
						account[i].accountWrite();
					break;
				case 3: 
					System.out.println("-".repeat(10));
					System.out.println("예금");	
					System.out.println("-".repeat(10));
					System.out.print("계좌번호 : ");
					accountNo = sc.nextLine();
					System.out.print("예금액 : ");
					money = Integer.parseInt(sc.nextLine());
					// 계좌번호를 찾은 후 그 배열 번지의 money에 추가
					for (int i=0; i<count; i++) {
						if (account[i].isAccount(accountNo)) {
							account[i].addMoney(money);
						}
					}
					System.out.println("결과 : 예금되었습니다");
					break;
				case 4:
					System.out.println("-".repeat(10));
					System.out.println("출금");	
					System.out.println("-".repeat(10));
					System.out.print("계좌번호 : ");
					accountNo = sc.nextLine();
					System.out.print("출금액 : ");
					money = Integer.parseInt(sc.nextLine());
					// 계좌번호를 찾은 후 그 배열 번지의 money에서 빼기
					for (int i=0; i<count; i++) {
						if (account[i].isAccount(accountNo)) {
							account[i].subMoney(money);
						}
					}
					System.out.println("결과 : 출금되었습니다");
					break;
			}
			
		}
	}

}
