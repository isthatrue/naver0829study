package day1109.test6.anno;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component("mycar")	// id : annoCar
public class AnnoCar {

	// @Autowired	// �ڵ� ���� - ���� �߻� : ��Ī ������ Ŭ������ 2���̹Ƿ� ������ �߻�
	// AnnoTire annoTire;
	
	// �������̽��� ������ Ŭ������ ���� ���� ��� ��Ȯ�ϰ� Ŭ���������� �����ϸ� �ȴ�.
	@Autowired
	// AnnoCanadaTire annoTire;
	// AnnoKoreaTire annoTire;
	
	// @Resource �� �������̽��� ������ Ŭ������ ���� ���� ��� �� ��� �����ش� (������ ��������)
	@Resource(name = "annoCanadaTire")
	AnnoTire annoTire;
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + annoTire.getTireName() + " �Դϴ�.");
	}
}
