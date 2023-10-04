package bit701_Study;

import java.util.Scanner;

public class Solution1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    String answer = "";
		String a = sc.next();
		
		for (char words : a.toCharArray()) {
			if (Character.isLowerCase(words))
				answer += Character.toUpperCase(words);
			else
				answer += Character.toLowerCase(words);
			}
		System.out.println(answer);
	}

}
