package bit701.day0912;

class SuperA {
	public void processA() {
		System.out.println("부모가 가진 메소드 A");
	}
	
	protected void processB() {
		System.out.println("부모가 가진 메소드 B");
	}
	
	private void processC() {	// 상속 안됨
		System.out.println("부모가 가진 메소드 C");
	}
}

class SubA extends SuperA {
	public void show() {
		// this는 자기 자신의 주소를 가진 인스턴스 변수이다.
		// this로 processA() 호출 시 현재 클래스에 없으면 부모로부터 찾아서 가져온다.
		this.processA();
		this.processB();
		// 부모의 주소값을 가진 인스턴스 변수 super
		// 반드시 super 로만 부모 메소드를 가져와야 하는 경우는
		// 부모의 메소드를 자식이 오버라이드 한 경우
		super.processA();	// 부모의 메소드이므로 super로도 가져올 수 있다.
		super.processB();
		
	}
}
public class Ex6_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubA sub1 = new SubA();
		sub1.processA();
		sub1.processB();
//		sub1.processC();	// 상속 안됨 (private은 패키지 상관없이 상속 안됨, 오류 발생
		System.out.println("-----");
		sub1.show();
	}

}
