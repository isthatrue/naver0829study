package bit701_Study;

public class Solution1010_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int townNumber = 0; 
		int count = 0;
		int n = 73;
		while(n > count) {
			townNumber++;
			if(townNumber % 3 == 0 || Integer.toString(townNumber).contains("3"))
				continue;
			
			count++;
		}	
			System.out.println(townNumber);
	}
	

}
