package bit701.day0901;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex2_Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름, 3과목의 점수(kor, eng, mat)를 입력받은 후 총점과 평균(소수점 1자리 출력 - NumberFormat)
		 * 그리고 등급을 출력(grade : 평균이 90 이상이면 "Excellent", 80 이상이면 "Good", 나머지는 "Try!"
		 * 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		NumberFormat numberFormat1 = NumberFormat.getInstance();
		numberFormat1.setMaximumFractionDigits(1);
		String name = "";
		int kor = 0, eng = 0, mat = 0;
		
		
		System.out.println("이름을 입력하시오.");
		name = sc.nextLine();
		System.out.println("국어 점수를 입력하시오.");
		kor = sc.nextInt();
		System.out.println("영어 점수를 입력하시오.");
		eng = sc.nextInt();
		System.out.println("수학 점수를 입력하시오.");
		mat = sc.nextInt();
		
		int sum = 0;
		double aver = 0;
		String grade = "";
		
		sum = kor + eng + mat;
		aver = (double)sum / 3;		// sum / 3.0
		
		if (aver >= 90)
			grade = "Excellent";
		else if (aver >= 80)
			grade = "Good";
		else
			grade = "Try!";
			
		
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + numberFormat1.format(aver));
		System.out.println("등급 : " + grade);
		
		
	}

}
