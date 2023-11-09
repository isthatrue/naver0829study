package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
// @RequestMapping("/shop")
public class ShopController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/shop/{path}")
	// public String list(@PathVariable("path") String path) {
	public String list (@PathVariable String path, Model model) {
		System.out.println(path);
		String shopinfo = "";
		List<ShopDto> list = new ArrayList<ShopDto>();
		if(path.equals("list1")) {
			shopinfo = "원피스 상품 목록";
			list.add(new ShopDto("섹시한원피스", "2.jpg", 99000));
			list.add(new ShopDto("시스루원피스", "25.jpg", 45000));
			list.add(new ShopDto("레이스원피스", "28.jpg", 68000));
			list.add(new ShopDto("청원피스", "33.jpg", 23000));
			} else if(path.equals("list2")) {
			shopinfo = "슈즈 상품 목록";
			list.add(new ShopDto("샤넬슈즈", "12.jpg", 150000));
			list.add(new ShopDto("구찌슈즈", "14.jpg", 980000));
			list.add(new ShopDto("샤넬슈즈", "15.jpg", 33000));
			}	else {
			shopinfo = "악세서리 상품 목록";
			list.add(new ShopDto("리본핀", "19.jpg", 11000));
			list.add(new ShopDto("머리띠", "30.jpg", 230000));
			list.add(new ShopDto("진주반지", "21.jpg", 55000));
			list.add(new ShopDto("머리끈", "26.jpg", 9000));
			}
		// 상품 목록 담기
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
	
	@GetMapping("/food/morning/brunch")
	public String brunchlist(Model model) {
		
		List<ShopDto> list = new ArrayList<ShopDto>();
		
		list.add(new ShopDto("이철수", "K-039.png", 11000));
		list.add(new ShopDto("아무개", "K-041.png", 11000));
		list.add(new ShopDto("김민수", "K-042.png", 11000));
		
		model.addAttribute("list", list);
		model.addAttribute("message", "오늘의 브런치 메뉴들");
		model.addAttribute("today", new Date());
		
		return "list2";
	}
	
	@GetMapping("/food/photo/detail")
	public String foodlist(Model model) {
		return "list3";
	}
}
