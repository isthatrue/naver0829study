package bit701.day0911;

class Car2 {
	String carName;
	String carColor;
	
	private Car2() {
		carName="아우디";
		carColor="검정색";
	}
	// 생성자가 private 이므로 생성해서 반환해줄 static 메소드가 반드시 필요하다.
	public static Car2 getInstance() {
		return new Car2();
	}
	
	
	@Override
	public String toString() {
		return "자동차명 : " + carName + ", 색상 : " + carColor; 
				
	}
	
}

public class Ex5_Construcor {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Car2 car1 = new Car2();	// 오류 발생, private이라 같은 멤버만 호출이 가능하다.
		
		Car2 car1 = Car2.getInstance();
//		System.out.println(car1.toString());
		System.out.println(car1);	// toString 메소드는 자동 호출
	}
}	
