package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바에서 시간이나 날짜 출력하는 방법
		Date date = new Date();
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		
		int hh = date.getHours();
		int mm = date.getMinutes();
		int ss = date.getSeconds();
		
		System.out.println("현재 년도 : " + year + "-" + month + "-" + day);
		System.out.printf("현재 년도 : %d-%02d-%2d\n", year, month, day); 	//%0
		System.out.printf("현재 시간 : %02d:%02d:%02d\n\n", hh, mm, ss);
		
		System.out.println("Calendar 클래스를 이용해서 시간, 날짜 구하기");
		// Calendar cal = new Calendar();	// 오류, 생성자가 public이 아니라 생성 안됨
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;	// 0-11의 값을 반환
		day = cal.get(Calendar.DATE);
		
		System.out.printf("현재 년도 : %d-%02d-%02d\n", year, month, day);
		
		
		// 요일 구하기
		int weekInt = date.getDay();	// 0:일, 1:월....6:토
		System.out.println("요일숫자: " + weekInt);
		
		String week = weekInt==0?"일요일":weekInt==1?"월요일":weekInt==2?"화요일":weekInt==3?"수요일":weekInt==4?"목요일":weekInt==5?"금요일":"토요일";
		System.out.println("오늘은 " + week + "입니다.");
		
	}

}
