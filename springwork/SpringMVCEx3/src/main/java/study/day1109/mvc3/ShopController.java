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
			shopinfo = "���ǽ� ��ǰ ���";
			list.add(new ShopDto("�����ѿ��ǽ�", "2.jpg", 99000));
			list.add(new ShopDto("�ý�����ǽ�", "25.jpg", 45000));
			list.add(new ShopDto("���̽����ǽ�", "28.jpg", 68000));
			list.add(new ShopDto("û���ǽ�", "33.jpg", 23000));
			} else if(path.equals("list2")) {
			shopinfo = "���� ��ǰ ���";
			list.add(new ShopDto("���ڽ���", "12.jpg", 150000));
			list.add(new ShopDto("�����", "14.jpg", 980000));
			list.add(new ShopDto("���ڽ���", "15.jpg", 33000));
			}	else {
			shopinfo = "�Ǽ����� ��ǰ ���";
			list.add(new ShopDto("������", "19.jpg", 11000));
			list.add(new ShopDto("�Ӹ���", "30.jpg", 230000));
			list.add(new ShopDto("���ֹ���", "21.jpg", 55000));
			list.add(new ShopDto("�Ӹ���", "26.jpg", 9000));
			}
		// ��ǰ ��� ���
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
	
	@GetMapping("/food/morning/brunch")
	public String brunchlist(Model model) {
		
		List<ShopDto> list = new ArrayList<ShopDto>();
		
		list.add(new ShopDto("��ö��", "K-039.png", 11000));
		list.add(new ShopDto("�ƹ���", "K-041.png", 11000));
		list.add(new ShopDto("��μ�", "K-042.png", 11000));
		
		model.addAttribute("list", list);
		model.addAttribute("message", "������ �귱ġ �޴���");
		model.addAttribute("today", new Date());
		
		return "list2";
	}
	
	@GetMapping("/food/photo/detail")
	public String foodlist(Model model) {
		return "list3";
	}
}
