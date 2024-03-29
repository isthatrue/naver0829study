package bit701.day0831;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex6_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 입력한 년, 월, 일에 해당하는 요일 구하기
		System.out.println("년, 월, 일을 순서대로 입력해주세요");
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		// Date 클래스 생성
		Date date = new Date(year-1900, month-1, day);
	
		// 요일 구하기
		int weekInt = date.getDay();	// 0:일, 1:월....6:토
		System.out.println("요일숫자: " + weekInt);
		String week = weekInt==0?"일요일":weekInt==1?"월요일":weekInt==2?"화요일":weekInt==3?"수요일":weekInt==4?"목요일":weekInt==5?"금요일":"토요일";
		System.out.println("오늘은 " + week + "입니다.");		
		
		
	}

}
