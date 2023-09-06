package bit701.day0906;

import java.util.Scanner;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  score에 5개의 배열 할당 후 키보드로 직접 점수를 입력하여 배열에 저장 후
		 *  총점과 평균을 구하세요
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언
		int[] score = new int[5];
		int sum = 0;
		double avg = 0;
		
		// 입력, 계산
		System.out.println("숫자 5개를 입력하세요.");
		for (int i=0; i<score.length; i++) {
			System.out.print(i+1+"번 점수 입력 : ");
			score[i]=sc.nextInt();
			
			// 조건 추가 : 0보다 작거나 100보다 크면 "0~100 사이 점수로 입력 바람!" 출력 후 다시 입력
			if (score[i] < 0 || score[i] > 100) {
				System.out.println("0 ~ 100 사이 점수로 입력 바람!");
				i--;
				continue;
			}
			sum+=score[i];
		}
		
		// 계산
		avg = (double)sum/score.length;
		
		// 출력
		System.out.println("입력한 점수들");
		
		for (int n : score)
			System.out.printf("%5d", n);
		
		System.out.println("\n총점: "+ sum);
		System.out.println("평균: "+ avg);
		
	}

}
