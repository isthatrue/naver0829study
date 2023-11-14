package board.data;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository		// bean 을 자동 등록해주는 어노테이션 :dao 에 붙인다.
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	private String nameSpace = "board.data.BoardDao.";
	
	// 전체 개수 반환하는 메소드
	public int getTotalCount() {
		return session.selectOne(nameSpace + "totalCountOfBoard");
	}
}
