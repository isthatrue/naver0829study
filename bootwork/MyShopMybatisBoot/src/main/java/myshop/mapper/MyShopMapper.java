package myshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import myshop.data.MyShopDto;

@Mapper
public interface MyShopMapper {
	
	// 방법 1
	// @Select("SELECT COUNT(*) FROM myshop")
	// public int getTotalCount();
	
	// 방법 2 : sql 을 xml 에서 정의
	public int getTotalCount();
	
	// 직접 insert 쿼리문 설정하기
	@Insert("""
					INSERT INTO myshop (sangpum, color, photo, price, writeday)
					VALUES (#{sangpum}, #{color}, #{photo}, #{price}, now())
					""")
	public void insertShop(MyShopDto dto);
	
	// 전체 목록 출력 (직접 sql문으로 설정하기)
	@Select("SELECT * FROM myshop ORDER BY num DESC")
	public List<MyShopDto> getSangpumList();
	
	public MyShopDto getData(int num);
	
	// delete 는 직접 sql 문으로 설정해서 삭제해보세요.
	@Delete("DELETE FROM myshop WHERE num = #{num}")
	public void deleteShop(int num);
}
