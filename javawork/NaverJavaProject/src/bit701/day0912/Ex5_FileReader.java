package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5_FileReader {
	static final String SUNGJUK = "D:/naver0829/sungjuk.txt";	
	Sungjuk[] sung = new Sungjuk[20];
	int count;
	
	public Ex5_FileReader() throws IOException {
		// TODO Auto-generated method stub
		// 파일 읽어서 sung 배열에 담기 (줄단위로 읽은 후 ',' 로 분리해서 넣기}
		FileReader fr = null;
		BufferedReader br = null;
		
		
		try {
			fr = new FileReader(SUNGJUK);	// 줄 단위로 읽는 멤버 메소드가 없다. 그래서 2차 생성
			br = new BufferedReader(fr);
			
			// br.readLine() 이 한 줄씩 읽는다. 그런데 더 이상 읽을 내용이 없을 경우 null 값을 반환
			// 대부분 두 줄 이상이고 몇 줄이 저장되어 있는지 모르므로 while문으로 처리한다.
			count=0;
			while(true) {
				// 파일의 내용을 한 줄씩 읽는다.
				String line = br.readLine();
				// 더 이상 읽을 내용이 없을 경우 while문을 종료한다.
				if (line == null)
					break;
				String[] data = line.split(",");
				String name = data[0];
				int kor = Integer.parseInt(data[1]);
				int eng = Integer.parseInt(data[2]);
				
				// Sungjuk 클래스 생성 - count 번지
				sung[count] = new Sungjuk(name, kor, eng);
				count++;
			}
			// 열려있는 자원들을 닫는다.(열려진 역순으로 닫는다.)
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을 경우 예외가 발생하며 catch 영역이 실행된다.
			System.out.println("해당 파일을 찾을 수 없어요 : " + e.getMessage());
		}	
	}
	
	public void dataList() {
		// 출력
		// 이름 국어 영어 총점 평균
		System.out.println("총 " + count + "명");
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(40));
		for (int i=0; i<count; i++) {
			Sungjuk s = sung[i];
			int tot = s.getKor() + s.getEng();
			double avg = tot/2.0; 
			System.out.println(s.getName() + "\t" + s.getKor() + "\t" + s.getEng() + "\t" + tot + "\t" + avg);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex5_FileReader ex = new Ex5_FileReader();
		ex.dataList();
	}
}
