package bit701_Study;

public class Solution0926_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 3;
		int total = 6;
		int tmptotal = 0;
		int[] answer = new int [num];
		
		for (int i=0; i<=num; i++) {
			tmptotal = total-(total-1);
			total -= tmptotal;
			System.out.println(total);
			System.out.println(tmptotal);
			
//			answer[i] = tmptotal;
		}
				

	}

}
