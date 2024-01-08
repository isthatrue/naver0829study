package myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import myshop.service.MyShopService;

@Controller
@RequiredArgsConstructor	// final이나 @NotNull 가 붙은 것만 생성자 주입이 됨
public class MyShopController {
	private final MyShopService shopService;
	
	@GetMapping("/")
	public String list(Model model) {
		
		// 총 개수를 얻어온다.
		int totalCount = shopService.getTotalCount();
		
		// model에 저장한다.
		model.addAttribute("totalCount", totalCount);
		
		return "myshop/shoplist";
	}
}
