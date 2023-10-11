package bit701_Study;

public class Solution1010_1 {
	public int solution(int n) {
		int townNumber = 0; 
		int count = 0;

		while(n > count) {
			townNumber++;
			if(townNumber % 3 == 0 || Integer.toString(townNumber).contains("3"))
				continue;
		
			count++;
		}	
		return townNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1010_1 soul = new Solution1010_1();
		System.out.println(soul.solution(40));
	}

}
