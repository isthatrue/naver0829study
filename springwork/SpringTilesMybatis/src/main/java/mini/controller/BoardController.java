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
		
		// 페이징처리
		// 페이징에 처리에 필요한 변수들
		int perPage = 3;		// 한 페이지당 보여지는 게시글의 갯수
		int totalCount = 0;	// 총 게시글의 개수
		int totalPage;			// 총 페이지수
		int startNum;				// 각 페이지당 보여지는 글의 시작번호
		// int endNum;
		int perBlock = 3; 	// 한 블럭당 보여지는 페이지의 개수
		int startPage;			// 각 블럭당 보여지는 페이지의 시작번호
		int endPage;
	
		// 총 글 개수
		totalCount = boardService.getTotalCount();
		
		// 총게시글이 37-한페이지 3-12.3333....13페이지
		totalPage = totalCount / perPage + (totalCount % perPage > 0?1:0);
		
		// 각 블럭의 시작페이지와 끝 페이지
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		
		// endPage는 totalPage를 넘지않도록 한다
		if(endPage > totalPage)
		 endPage = totalPage;
		
		// 각 페이지당 불러올 글의 번호
		// 1페이지:1~10 2페이지:11~20 3페이지:31-40
		startNum = (currentPage-1) * perPage;
		
		// 각 페이지의 시작 번호
		int no = totalCount - (currentPage-1) * perPage;
		
		//해당페이지에 보여줄 게시판 목록
	  List<BoardDto> list = boardService.getList(startNum, perPage);
	  
	  // request 에 담을 값들
	  model.addAttribute("list", list);
	  model.addAttribute("totalCount", totalCount);
	  model.addAttribute("totalPage", totalPage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  model.addAttribute("currentPage", currentPage);  
	  model.addAttribute("no", no);  
		
		return "board/boardlist";
	}
	
	// 새로운 글 or 답글 일 때 모두 호출
	@GetMapping("/board/form")
	public String form(
				Model model,
				/* 새로운 글일 경우 값이 안 넘어오므로 defaultValue 값이 적용된다. */
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
		
		// 답글일 경우 제목 가져오기
		String subject = "";
		if (num > 0)
			subject = boardService.getData(num).getSubject();
		
		model.addAttribute("subject", subject);
		
		return "board/boardform";
	}
	
	// 새글/답글 저장
	@PostMapping("/board/addboard")
	public String addBoard(
				@ModelAttribute BoardDto dto,
				@RequestParam int currentPage,
				@RequestParam List<MultipartFile> upload,
				HttpServletRequest request,
				HttpSession session) {
		
		// 파일 업로드할 경로
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		
		// db 에 저장할 로그인 정보
		String myid = (String)session.getAttribute("myid");
		String writer = (String)session.getAttribute("myname");
		
		// dto 에 넣기
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		// 일단 BoardDto 먼저 저장
		boardService.insertBoard(dto);
		
		// selectKey : num 값 넘어왔는 지 확인
		System.out.println("num=" + dto.getNum());
		
		// 사진들 업로드
		// 사진 업로드를 안 했을 경우 리스트의 첫 데이터의 파일명이 빈 문자열이 된다.
		// 즉 업로드 했을 경우에만 db 에 저장을 한다.
		if (!upload.get(0).getOriginalFilename().equals("")) {
			for(MultipartFile multi:upload) {
				// 랜덤 파일명 생성
				String fileName=UUID.randomUUID().toString();
				
				// 업로드
				try {
					multi.transferTo(new File(path + "/" + fileName));
					// 파일은 따로 db 에 insert 한다.
					BoardFileDto fdto = new BoardFileDto();
					fdto.setNum(dto.getNum());		// boarddb 에 방금 insert 된 num 값
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
		
		// 새 글인 경우는 1페이지로, 답글인 경우는 보던 페이지로 이동한다.
		return "redirect:list?currentPage=" + currentPage;
	}
	
	
}
