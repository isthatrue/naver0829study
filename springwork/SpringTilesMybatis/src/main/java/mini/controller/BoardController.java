package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
import mini.service.BoardFileService;
import mini.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardFileService boardFileService;
	
	@GetMapping("board/list")
	public String list(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		
		// ����¡ó��
		// ����¡�� ó���� �ʿ��� ������
		int perPage = 3;		// �� �������� �������� �Խñ��� ����
		int totalCount = 0;	// �� �Խñ��� ����
		int totalPage;			// �� ��������
		int startNum;				// �� �������� �������� ���� ���۹�ȣ
		// int endNum;
		int perBlock = 3; 	// �� ������ �������� �������� ����
		int startPage;			// �� ������ �������� �������� ���۹�ȣ
		int endPage;
	
		// �� �� ����
		totalCount = boardService.getTotalCount();
		
		// �ѰԽñ��� 37-�������� 3-12.3333....13������
		totalPage = totalCount / perPage + (totalCount % perPage > 0?1:0);
		
		// �� ������ ������������ �� ������
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		
		// endPage�� totalPage�� �����ʵ��� �Ѵ�
		if(endPage > totalPage)
		 endPage = totalPage;
		
		// �� �������� �ҷ��� ���� ��ȣ
		// 1������:1~10 2������:11~20 3������:31-40
		startNum = (currentPage-1) * perPage;
		
		// �� �������� ���� ��ȣ
		int no = totalCount - (currentPage-1) * perPage;
		
		//�ش��������� ������ �Խ��� ���
	  List<BoardDto> list = boardService.getList(startNum, perPage);
	  
	  // request �� ���� ����
	  model.addAttribute("list", list);
	  model.addAttribute("totalCount", totalCount);
	  model.addAttribute("totalPage", totalPage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  model.addAttribute("currentPage", currentPage);  
	  model.addAttribute("no", no);  
		
		return "board/boardlist";
	}
	
	// ���ο� �� or ��� �� �� ��� ȣ��
	@GetMapping("/board/form")
	public String form(
				Model model,
				/* ���ο� ���� ��� ���� �� �Ѿ���Ƿ� defaultValue ���� ����ȴ�. */
				@RequestParam(defaultValue = "1") int currentPage,
				@RequestParam(defaultValue = "0") int num,
				@RequestParam(defaultValue = "0") int regroup,
				@RequestParam(defaultValue = "0") int restep,
				@RequestParam(defaultValue = "0") int relevel
				) {
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("num", num);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		
		// ����� ��� ���� ��������
		String subject = "";
		if (num > 0)
			subject = boardService.getData(num).getSubject();
		
		model.addAttribute("subject", subject);
		
		return "board/boardform";
	}
	
	// ����/��� ����
	@PostMapping("/board/addboard")
	public String addBoard(
				@ModelAttribute BoardDto dto,
				@RequestParam int currentPage,
				@RequestParam List<MultipartFile> upload,
				HttpServletRequest request,
				HttpSession session) {
		
		// ���� ���ε��� ���
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// db �� ������ �α��� ����
		String myid = (String)session.getAttribute("myid");
		String writer = (String)session.getAttribute("myname");
		
		// dto �� �ֱ�
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		// �ϴ� BoardDto ���� ����
		boardService.insertBoard(dto);
		
		// selectKey : num �� �Ѿ�Դ� �� Ȯ��
		System.out.println("num=" + dto.getNum());
		
		// ������ ���ε�
		// ���� ���ε带 �� ���� ��� ����Ʈ�� ù �������� ���ϸ��� �� ���ڿ��� �ȴ�.
		// �� ���ε� ���� ��쿡�� db �� ������ �Ѵ�.
		if (!upload.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile multi:upload) {
				// ���� ���ϸ� ����
				String fileName=UUID.randomUUID().toString();
				
				// ���ε�
				try {
					multi.transferTo(new File(path + "/" + fileName));
					// ������ ���� db �� insert �Ѵ�.
					BoardFileDto fdto = new BoardFileDto();
					fdto.setNum(dto.getNum());		// boarddb �� ��� insert �� num ��
					fdto.setPhotoname(fileName);
					
					boardFileService.insertPhoto(fdto);
					
;				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// �� ���� ���� 1��������, ����� ���� ���� �������� �̵��Ѵ�.
		return "redirect:list?currentPage=" + currentPage;
	}
	
	
}