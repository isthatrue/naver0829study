package bit701.day0912;

class SuperB {
	public void processA() {
		System.out.println("부모가 가진 메소드 A");
	}
}

class SubB extends SuperB {
	
	@Override // 어노테이션
	public void processA() {
		super.processA();	// 부모가 먼저 작업을 하고
		// 나머지는 자식 클래스에서 작업을 완성을 하겠다.
		System.out.println("자식이 가진 오버라이드 메소드 A");
	}
	
	public void processB() {
		System.out.println("자식만이 가지고 있는 메소드 B");
	}
}

public class Ex7_InheriOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubB sub1 = new SubB();
		sub1.processA();
		
		// 다형성의 기본 원리
		// 선언은 부모클래스로, 생성은 자식클래스로
		// processB는 호출할 수 없다.
		// 왜? 자식이 가진 것 중 오버라이드 된 거만 호출이 가능하다.
		SuperB sub2 = new SubB();
		sub2.processA();		// 오버라이드된 자식이 가진 메소드가 호출
		sub1.processB();
	}

}
