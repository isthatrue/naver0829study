public class DataTypeEx1{
   public static void main(String[] args){
	//이 라인은 비실행문입니다.
	/*
		2023.08.30
		데이타 타입 예제
	*/
	//byte는 1byte 크기의 정수형 타입입니다.
	//크기는 -128~127의 숫자만 저장이 가능합니다.
	byte a = 127;
	System.out.println("a = " + a);

	byte b = (byte)200; //오류 발생, 강제 형변환
	System.out.println("b = " + b); //강제 형변환 했을 경우 값손실 발생
	// 값 : -56 나오는 이유 8bit(2진수)의 2의 보수 (1의 보수에서 1을 더함, 1의 보수는 200 값을 8bit(2진수)로 확인 후 0과 1을 서로 바꿈)
	
	//실행 시 인자로 넘어오는 문자열을 확인해보자 [ex : java DataTypeEx1 apple]
	System.out.println(args[0]); //배열의 첫 문자열 출력 [값 : apple]
	System.out.println(args[0].getClass());
   }
}