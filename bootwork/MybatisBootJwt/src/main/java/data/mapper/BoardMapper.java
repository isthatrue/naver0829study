package data.mapper;


import data.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

    public int getTotalCount(String search);
    
    public List<BoardDto> getAllDatas(HashMap<String, Object> map);
    
    public void insertBoard(BoardDto dto);
    
    @Select("SELECT * FROM simpleboard WHERE num = #{num}")
  	public BoardDto getSelectPage(int num);
  	
  	@Update("UPDATE simpleboard SET readcount = readcount + 1 WHERE num = #{num}")
  	public void updateReadcount(int num);

}