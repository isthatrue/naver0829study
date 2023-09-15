package bit701.day0915;

import java.awt.Canvas;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bit701.day0915.Ex8_FileImageLoad.MyCanvas;

public class Exam_FileImage extends JFrame{
	JButton carButton, animalsButton, personButton, shopButton;
	
	String carImage = "D:\\naver0829\\image\\mycar\\mycar3.png";
	String personImage = "D:\\naver0829\\image\\연예인사진\\jeonjeehyeon.jpg";
	String shopImage = "D:\\naver0829\\image\\shop\\";
	Image image;
	String shopURL;
	MyCanvas myCanvas = new MyCanvas();
	
	public Exam_FileImage(String title) {
		// TODO Auto-generated constructor stub
		super(title); 		//JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100);		// 프레임의 시작 위치
		this.setSize(500, 600);			// 프레의 너비, 높이		
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
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if(image.getWidth(this) >= 300)
				g.drawImage(image, 50, 10, 370, 450, this);
			else	// 300미만 너비를 가진 이미지는 원래 사이즈대로 출력
				g.drawImage(image, 50, 10, this);
		}
	}
	private void setDesign() {
		// 상단에는 패널안에 버튼 추가 후 프레임에 패널 추가
		JPanel p = new JPanel();
		carButton = new JButton("아우디");
		animalsButton = new JButton("동물");
		personButton = new JButton("전지현");
		shopButton = new JButton("쇼핑 사진(랜덤)");
		p.add(carButton);
		p.add(animalsButton);
		p.add(personButton);
		p.add(shopButton);
		this.add(p, "North");
		this.add("Center", myCanvas);
		image = new ImageIcon(personImage).getImage();
		
		carButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// image 생성
				image = new ImageIcon(carImage).getImage();
				myCanvas.repaint();
			}
		});
		
		shopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// image 생성
				int rnd=(int)(Math.random()*34)+1;
				shopURL = (rnd == 24)? rnd+".gif":rnd+".jpg";
				image = new ImageIcon(shopImage+shopURL).getImage();
				myCanvas.repaint();
			}
		});
		animalsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// image 생성
				int anirnd = (int)(Math.random()*8)+1;
				String animalsImage = "D:\\naver0829\\workstudy\\webwork\\이쁜동물이미지\\C" + anirnd + ".png";
				image = new ImageIcon(animalsImage).getImage();
				myCanvas.repaint();
			}
		});
		
		
	}
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam_FileImage s = new Exam_FileImage("카테고리 별 사진 버튼");
	}
}
