public class DataTypeEx1{
   public static void main(String[] args){
	//�� ������ ����๮�Դϴ�.
	/*
		2023.08.30
		����Ÿ Ÿ�� ����
	*/
	//byte�� 1byte ũ���� ������ Ÿ���Դϴ�.
	//ũ��� -128~127�� ���ڸ� ������ �����մϴ�.
	byte a = 127;
	System.out.println("a = " + a);

	byte b = (byte)200; //���� �߻�, ���� ����ȯ
	System.out.println("b = " + b); //���� ����ȯ ���� ��� ���ս� �߻�
	// �� : -56 ������ ���� 8bit(2����)�� 2�� ���� (1�� �������� 1�� ����, 1�� ������ 200 ���� 8bit(2����)�� Ȯ�� �� 0�� 1�� ���� �ٲ�)
	
	//���� �� ���ڷ� �Ѿ���� ���ڿ��� Ȯ���غ��� [ex : java DataTypeEx1 apple]
	System.out.println(args[0]); //�迭�� ù ���ڿ� ��� [�� : apple]
	System.out.println(args[0].getClass());
   }
}