package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex7_Canvas extends JFrame{
	MyCanvas myCanvas = new MyCanvas();
	
	public Ex7_Canvas(String title) {
		// TODO Auto-generated constructor stub
		super(title); 		//JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100);		// 프레임의 시작 위치
		this.setSize(500, 500);			// 프레임의 너비, 높이		
		// this.getContentPane().setBackground(Color.green);	// Color 상수를 이용해 변경
		// this.getContentPane().setBackground(new Color(200, 255, 180));
		
		// 디자인이나 이벤트를 구현할 메소드 호출
		this.setDesign();
		
		this.setVisible(true);		// true : 프레임을 보이게 하기, false : 프레임 숨기기
		
		// 윈도우 이벤트 발생- 익명 내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {	// 익명 내부 클래스
			@Override
			public void windowClosing(WindowEvent e) {	// X 버튼 클리시 호출되는 메소드
				// TODO Auto-generated method stub
			// JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다.");	// 실제 종료
				System.exit(0);			// 정상 종료
				super.windowClosing(e); 
			}
		}); 	
	}
	// 캔바스 내부 클래스
	
	class MyCanvas extends Canvas {
		
		String imageIcon = "D:\\naver0829\\workstudy\\webwork\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			// 원그리기
			g.setColor(new Color(255, 100, 255)); 	// 선택
			g.drawOval(50, 50, 100, 100);			// 테두리선만 있는 원
			
			// 채워진 원
			g.setColor(Color.orange);
			g.fillOval(200, 50, 100, 100);
		
			// 테두리만 있는 사각형
			g.setColor(Color.green);
			g.fillOval(50, 200, 100, 100);
			
			// 채워진 사각형
			g.setColor(Color.pink);
			g.fillOval(200, 200, 100, 100);
			

			Image image1 = new ImageIcon(imageIcon).getImage();
			// 이미지 그리기;
			g.drawImage (image1, 100, 220, this);
			
			// 크기변경해서 출력
			g.drawImage(image1, 300, 30, 100, 1000, this);
		}		
		
	}
	private void setDesign() {
		this.add(myCanvas, "Center");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_Canvas s = new Ex7_Canvas("캔바스");
	}

}
