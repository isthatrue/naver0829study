package simpleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class SimpleBoardDao {
	DbConnect db = new DbConnect();
	
	// 목록
	public List<SimpleBoardDto> getAllList() {
		List<SimpleBoardDto> list = new Vector<SimpleBoardDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from simpleboard order by num desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SimpleBoardDto dto = new SimpleBoardDto(); // 반드시 while 문 안에 선언
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPhoto(rs.getString("photo"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				// list 에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	
	// insert
	public void insertBoard(SimpleBoardDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = """
					insert into simpleboard (writer, subject, content, photo, writeday) 
					values (?, ?, ?, ?, now())
				""";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPhoto());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("INSERT SQL문 오류 : " + e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}

		
	}
	
	// 내용 보기
	public SimpleBoardDto getData(String num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleBoardDto dto = new SimpleBoardDto();
		String sql = "select * from simpleboard where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setPhoto(rs.getString("photo"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	// 조회수 증가
	public void updateReadcount(String num) {
		String sql = "update simpleboard set readcount=readcount+1 where num=?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, num);
			
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 삭제
	public void deleteBoard(String num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "delete from simpleboard where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("DELETE SQL문 오류 : " + e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 수정
		public void updateBoard(SimpleBoardDto dto) {
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;

			String sql = "";
			// 사진은 수정하지 않았을 경우 null 값을 가진다.
			// null 이 아닐 경우에만 photo 를 수정한다.
			if (dto.getPhoto()==null) {
				// 사진 수정 안함
				sql = "update simpleboard set writer=?, subject=?, content=? where num=?";
			} else {
				// 사진을 수정하는 경우
				sql = "update simpleboard set writer=?, subject=?, content=?, photo='"
						+ dto.getPhoto() +"' "
						+ "where num=?";
			}
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getNum());
				
				// 실행
				pstmt.execute();
				
			} catch (SQLException e) {
				System.out.println("UPDATE SQL문 오류 : " + e.getMessage());
			} finally {
				db.dbClose(pstmt, conn);
			}
		}
}
