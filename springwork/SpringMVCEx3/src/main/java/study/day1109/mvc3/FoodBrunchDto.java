package study.day1109.mvc3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class FoodBrunchDto {
	private String name;
	private String food;
	private String addr;
}
