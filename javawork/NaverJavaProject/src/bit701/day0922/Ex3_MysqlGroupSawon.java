package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

public class Ex3_MysqlGroupSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	Ex3_MysqlGroupSawon() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패 : " + e.getMessage());
		}
	}	

	
	public void sawonBunseok() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select buseo, count(*) count, max(score) maxscore, "
				+ "min(score) minscore, avg(score) avgscore from sawon group by buseo";
		NumberFormat numformat1 = NumberFormat.getInstance();
		numformat1.setMaximumFractionDigits(1);
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("부서\t인원수\t최고점\t최저점\t평균");
			System.out.println("=".repeat(50));
			
			
			while(rs.next()) {
				String buseo = rs.getString("buseo");
				int count = rs.getInt("count");
				int max = rs.getInt("maxscore");
				int min = rs.getInt("minscore");
				double avg = rs.getDouble("avgscore");
				
				System.out.println(buseo + "\t" + count + "\t" + max + "\t" + min + "\t" + numformat1.format(avg));
				
			}
			
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패 : " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_MysqlGroupSawon ex = new Ex3_MysqlGroupSawon();
		ex.sawonBunseok();
	}

}
