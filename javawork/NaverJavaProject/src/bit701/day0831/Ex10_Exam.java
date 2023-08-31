package bit701.day0831;

import java.util.Scanner;
import java.text.NumberFormat;

public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 상품명과 수량, 단가를 각각 입력받은 후 총 금액을 출력하시오.
		 * 그리고 수량이 5개 이상 일 경우 10프로 할인된 최종 금액도 출력해 주세요.
		 * 
		 * (예)
		 * 상품명 : 딸기
		 * 수량 : 6
		 * 단가 : 10000
		 * 
		 * 총 금액 : 6000원
		 * 5개 이상 10프로 할인된 금액 : 5400원 
		 */
		
		Scanner sc = new Scanner(System.in);
		NumberFormat numberFormat1 = NumberFormat.getInstance();
		
		
		System.out.print("상품명 : ");
		String product = sc.nextLine();
		System.out.print("수량 : ");
		int count = sc.nextInt();
		System.out.print("단가 : ");
		int price = sc.nextInt();
		
//		double discountPrice = 0;
//		if (count >= 5)
//			discountPrice = price*count*0.9;
//		
//		
//		System.out.println("총 금액 : " + numberFormat1.format(count * price));
//		System.out.println("5개 이상 10프로 할인된 금액 : " + numberFormat1.format((int)discountPrice));		
		
		int totalPrice = price * count;
		int discountPrice = 0;
		if (count >= 5)
			discountPrice = totalPrice - totalPrice/10;
		
		System.out.println(totalPrice/10);
		System.out.println("총 금액 : " + numberFormat1.format(totalPrice));
		System.out.println("5개 이상 10프로 할인된 금액 : " + numberFormat1.format((int)discountPrice));		
		
		
	}

}
