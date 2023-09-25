package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.text.SimpleAttributeSet;

import db.DbConnect;
public class Ex9_StudentCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		System.out.println("1.추가  2.삭제  3.수정  4.전체출력  5. 검색  6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	// insert
	public void insertStudent() {
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("혈액형");
		String blood = sc.nextLine();
		System.out.println("핸드폰");
		String phone = sc.nextLine();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into student values (null, ?, ?, ?, now())";
		// ? 에 값을 넣는 것 : 바인딩, ? 는 차례대로 1, 2, 3, 4...
		
		try {
			pstmt = conn.prepareStatement(sql);		// 이때 sql문을 검사
			// ? 개수만큼 값을 넣어준다.
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());	// 대문자로 변환해서 넣기
			pstmt.setString(3, phone);
			
			// 실행
			pstmt.execute();	// 주의 : 인자 값에 sql 문 없다
			System.out.println("추가되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// delete
	public void deleteStudent() {
		System.out.println("삭제할 학생의 이름은? ");
		String name = sc.nextLine();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from student where name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 개수만큼 바인딩
			pstmt.setNString(1, name);
			// 삭제된 인원을 알고 싶을 경우 executeUpate
			int n = pstmt.executeUpdate();
			if (n==0)
				System.out.println("해당 이름을 찾을 수 없습니다.");
			else
				System.out.println("삭제했습니다");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}	
	}
	
	// update
	public void updateStudent() {
		// num, name, score, buseo 를 입력받은 후 num에 해당하는 name, score, buseo 수정하기
		// num 이 없으면 해당 데이터가 없어요
		System.out.println("수정할 학생의 번호는? ");
		String no = sc.nextLine();
		System.out.println("수정할 사원 이름은? ");
		String name = sc.nextLine();
		System.out.println("수정할 혈액형은? ");
		String blood = sc.nextLine();
		System.out.println("수정할 핸드폰 번호는? ");
		String phone = sc.nextLine();

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update student set name=?, blood=?, phone=? where num=?";


		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩 4개
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			pstmt.setString(4, no);

			// 실행
			int n = pstmt.executeUpdate();
			if (n==0)
				System.out.println("해당 데이터가 없습니다.");
			else
				System.out.println("수정했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 전체 출력
	public void selectAllStudent() {
		String sql = "select * from student order by num";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(50));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
//				String writeday = rs.getString("writeday");		// 날짜 타입도 String 타입으로 가져와도된다.
				Timestamp ts = rs.getTimestamp("writeday");
				
//				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + ts.toLocaleString());
				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + sdf.format(ts));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	// 검색 - 번호 끝 4자리로 검색
	public void searchPhone() {
		System.out.println("전화번호 끝 4자리를 입력하세요.");
		String searchPhone = sc.nextLine();
		
		String sql = "select * from student where phone like ?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, "%"+searchPhone);
			// 실행
			rs = pstmt.executeQuery();
			
			
			System.out.println("전화번호 " + searchPhone + " 검색결과");
			System.out.println("번호\t이름\t혈액형\t전화\t날짜");
			System.out.println("=".repeat(50));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			while(rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				Timestamp ts = rs.getTimestamp("writeday");
				
				
				System.out.println("번호 : " + num);
				System.out.println("이름 : " + name);
				System.out.println("혈액형 : " + blood);
				System.out.println("핸드폰 : " + phone);
				System.out.println("날짜 : " + sdf.format(ts));
				System.out.println("-".repeat(50));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_StudentCrud ex = new Ex9_StudentCrud();
		
		while(true) {
			System.out.println("-".repeat(50));
			int menu = ex.getMenu();
			System.out.println("-".repeat(50));
			switch(menu) {
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;
			case 5:
				ex.searchPhone();
				break;
			default:
				System.out.println("** 프로그램을 종료합니다. **");
				System.exit(0);
			}
			
		}

	}

}
