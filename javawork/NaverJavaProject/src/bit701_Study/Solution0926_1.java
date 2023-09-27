package bit701_Study;

public class Solution0926_1 {
	public int solution(String A, String B) {
		int answer = 0;
		if (B.equals(A))
			return answer;
		for (int i = A.length()-1; i>=0; i--) {
			answer++;	
			if (B.equals(A.substring(i)+A.substring(0,i))) 
				return answer;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution0926_1 soul = new Solution0926_1();
		System.out.println(soul.solution("hello", "hello"));
		
		
//		String A = "hello";
//		String B = "ohell";
//		int answer = 1;
//		
//		if (B.equals(A)) {
//			answer = 0;
//			System.out.println(answer);
//		}
//		
//		else {
//			for (int i = A.length()-1; i>=0; i--) {
//				if (B.equals(A.substring(i)+A.substring(0,i))) {
//					System.out.println(answer);
//				}
//				else {
//					answer++;
//					
//					if (answer >= A.length())
//						System.out.println("-1");
			
	}
}
