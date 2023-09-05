package bit701.day0905;

import java.util.Scanner;

public class Ex1_JuminNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String juminNo = "";
		String nation = "";
		String gender = "";
		
		Exit:
		while (true) {
		System.out.print("주민번호 입력(종료 시 q/Q)> ");
		juminNo = sc.nextLine();
		
		// q or Q 입력 시 종료
		if (juminNo.equalsIgnoreCase("q"))
			break;
		
		String yearStr = juminNo.substring(0,2);
		String monthStr = juminNo.substring(2,4);
		String dayStr = juminNo.substring(4,6);
		char check = juminNo.charAt(7);
		
		switch (check) {
		case '1': case '3':
			nation = "내국인";
			gender = "남성";
			break;
		case '2': case '4':
			nation = "내국인";
			gender = "여성";
			break;
		case '5':
			nation = "외국인";
			gender = "남성";
			break;
		case '6':
			nation = "외국인";
			gender = "여성";
			break;
		default:
			System.out.println("주민번호가 올바르지 않습니다. 다시 입력해주세요.");
			continue Exit;
		
		}
		System.out.println(yearStr+ "년 "+ monthStr + "월 " + dayStr + "일생");
		System.out.println(nation);
		System.out.println(gender);
		
	}
	System.out.println("프로그램을 종료합니다.");
 }

}
