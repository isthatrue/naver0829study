package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import data.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	@Select("SELECT COUNT(*) FROM memberdb")
	public int getTotalCount();
	
	@Select("SELECT * FROM memberdb ORDER BY num DESC")
	public List<MemberDto> getAllMembers();
	
	// @Insert 로 쿼리문을 여기서 직접써도 되지만 xml에서 해보자.
	public void insertMember(MemberDto dto);
	
	// 해당 아이디가 있는지 확인,count 이용
	@Select("SELECT COUNT(*) FROM memberdb WHERE myid = #{myid}")
	public int getIdCheck(String myid);
	
	@Delete("DELETE FROM memberdb WHERE num = #{num}")
	public void deleteMember(int num);
	
	@Select("SELECT * FROM memberdb WHERE num = #{num}")
	public MemberDto getMember(int num);
	
	@Select("SELECT * FROM memberdb WHERE myid = #{myid}")
	public MemberDto getLogin(String myid);
}
