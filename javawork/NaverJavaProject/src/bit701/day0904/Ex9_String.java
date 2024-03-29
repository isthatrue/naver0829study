package bit701.day0904;

public class Ex9_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="apple";
		String str2="AppLe";
		String str3="Have a Good Day";
		String str4="   Happy   ";
		
		System.out.println(str3.length());					// str3의 총 길이 : 15
		System.out.println(str2.toLowerCase());				// str2를 모두 소문자로 변환
		System.out.println(str2.toUpperCase());				// str2를 모두 대문자로 변환
		System.out.println(str3.substring(5));				// substring([n]) [n]인덱스 값부터 끝까지 출력
		System.out.println(str3.substring(7, 11));			// 인덱스 7번 부터 10번까지 추출해서 출력
		System.out.println(str3.charAt(0));					// str3에서 0번 문자 출력
		System.out.println(str3.charAt(7));					// str3에서 7번 문자 출력
		System.out.println(str1.indexOf('a'));				// str1에서 첫 번째 'a'의 인덱스 값 
		System.out.println(str3.lastIndexOf('a'));			// str3에서 마지막 'a'의 인덱스 값
		System.out.println(str4.length());					// 앞 뒤 공백을 포함한 전체 길이
		System.out.println(str4.trim().length());			// 앞 뒤 공백 제거 후 길이 구하기
		System.out.println(str3.startsWith("Have"));		// str3가 "Have"로 시작하면 true
		System.out.println(str3.endsWith("day"));			// str3가 day로 끝나면 true, 대소문자 구분하지 않았으므로 false
		System.out.println(str1.equals(str2));				// str1이 str2와 완벽하게 대소문자까지 같을 경우 true
		System.out.println(str1.equalsIgnoreCase(str2));	// 대소문자 상관없이 철자만 같으면 true
		System.out.println(str2.compareTo(str1));			// str1과 str2의 차이(양수 값이 나오면 str1이 더 큰 값, 음수 값 : str2가 더 큰 값 
		System.out.println(str1.compareTo("apple"));		// 완전 같은 경우 0
		
		
	}

}
