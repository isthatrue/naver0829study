package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db = new DbConnect();
	
	public void sawonDelete() {
		// 사원명 입력 후 해당 사원 삭제
		// 결과값이 0이면 XXX 사원은 없습니다.
		// 			n이면 총 n명의 XXX 사원 정보를 삭제했습니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사원 이름 입력");
		String name = sc.nextLine();
		String sql = "delete from sawon where name='" + name + "'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			
			if (n == 0)
				System.out.println(name + " 사원은 없습니다!");
			else
				System.out.println("총 " + n + "명의 사원이 삭제되었습니다!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex = new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}

}
