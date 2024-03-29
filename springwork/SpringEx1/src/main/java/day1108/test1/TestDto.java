package day1108.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Setter
// @Getter
// @ToString

// 위의 3개의 어노테이션을 하나의 어노테이션으로 표현 가능하다.
@Data

@NoArgsConstructor		// 디폴트 생성자
@AllArgsConstructor		// 모든 멤버를 파라미터로 받는 생성자
@RequiredArgsConstructor // 필요한 인자만 생성자로 주입(Injection)
public class TestDto {
	@NonNull
	private String name;
	private String addr;
	private int age;
	
}
