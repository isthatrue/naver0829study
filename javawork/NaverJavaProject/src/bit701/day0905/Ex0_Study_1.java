package bit701.day0905;

public class Ex0_Study_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i=1; i<=5; i++) {	// 행
			for (int j=1; j<=5; j++) {	// 열
		//  for (int j=i; j<=5; j++) // 출력 값 : ***** \n **** \n *** \n ** \n *
		//  for (int j=1; j<=i; j++) // 출력 값 : * \n ** \n *** \n **** \n *****		
				if (i == j)
					System.out.print(i);
				else
					System.out.print("*");
				
			}
			System.out.println();
		}
	}

}
