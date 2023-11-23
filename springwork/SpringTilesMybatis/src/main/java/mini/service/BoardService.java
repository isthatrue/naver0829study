package mini.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardDao;
import mini.dto.BoardDto;

@Service
@AllArgsConstructor
public class BoardService {
	
	private BoardDao boardDao;
	
	public int getTotalCount() {
		return boardDao.getTotalCount();
	}
	
  public List<BoardDto> getList(int start, int perpage) {
  	Map<String, Integer> map = new HashMap<String, Integer>();
  	map.put("start", start);
  	map.put("perpage", perpage);
  	
  	return boardDao.getList(map);
  }
  
  public int getMaxNum() {
  	return boardDao.getMaxNum();
  }
  
  public void updateRestep(int regroup, int restep) {
  	Map<String, Integer> map = new HashMap<String, Integer>();
  	map.put("regroup", regroup);
  	map.put("restep", restep);
  	
  	boardDao.updateRestep(map);
  }
  
  public void insertBoard(BoardDto dto) {
  	int num = dto.getNum();						// 새 글일 경우 0, 답글일 경우 0보다 큰 값이 들어있다.
  	int regroup = dto.getRegroup();		// 답글을 단 글의 regroup
  	int restep = dto.getRestep();			// 답글을 단 글의 restep
  	int relevel = dto.getRelevel();		// 답글을 단 글의 relevel
  	
  	if(num == 0) {
  		// 새 글인 경우
  		regroup = boardDao.getMaxNum() + 1;
  		restep = 0;
  		relevel = 0;
  	} else {
  		// 답글인 경우 그룹은 그대로 사용하므로 regroup 은 따로 안 구한다.
  		// 답글인 경우
  		this.updateRestep(regroup, restep);		// 같은 그룹 중 전달받은 restep 보다 큰 값이 있는 글들을 모두 +1을 해준다.
  		
  		// 그리고 나서 각각의 값에 1을 더한다.
  		restep = restep + 1;
  		relevel = relevel + 1;
  	}
  	
  	// 각각 새로 구한 값을 다시 dto 에 담는다.
  	dto.setRegroup(regroup);
  	dto.setRestep(restep);
  	dto.setRelevel(relevel);
  	
  	// db insert
  	boardDao.insertBoard(dto);
  }
  
  public void updateReadCount(int num) {
  	boardDao.updateReadCount(num);
  }
  
  public BoardDto getData(int num) {
  	return boardDao.getData(num);
  }
}
