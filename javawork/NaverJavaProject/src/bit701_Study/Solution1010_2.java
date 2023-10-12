package bit701_Study;

public class Solution1010_2 {
	public int solution(int[] common) {
        int answer = 0;
        if ((common[1] - common[0]) == (common[2] - common[1])) 
        	answer = (common[common.length-1]) + (common[2] - common[1]);
		
		else if ((common[1] / common[0]) == (common[2] / common[1])) { 
	        answer = (common[common.length-1]) * (common[2] / common[1]);
		}
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1010_2 soul = new Solution1010_2();
		int[] arr = {15, 30, 60, 120};
		
		System.out.println(soul.solution(arr));
	}

}
