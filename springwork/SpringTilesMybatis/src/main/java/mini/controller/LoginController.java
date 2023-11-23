package mini.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.Session;

import mini.dao.MemberDao;

@Controller
public class LoginController {
	
	@Autowired
	private MemberDao memberDao;
	
	public static final int SESSION_DURATION = 60 * 60 * 6; // 6시간
	
	@GetMapping("login/main")
	public String login() {
		return "login/loginmain";
	}
	
	@GetMapping("/login/process")
	@ResponseStatus(code = HttpStatus.OK) // Static (정적이다.)
	@ResponseBody Map<String, Object> login(@RequestParam boolean saveid,
					@RequestParam String myid, @RequestParam String pass, HttpSession session) {
		System.out.println("saveid : " + saveid);
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 로그인 성공 여부
		boolean bLogin = memberDao.isLoginCheck(myid, pass);
		if (bLogin) {
			// 세션 유지 시간
			session.setMaxInactiveInterval(SESSION_DURATION); 
			
			// 로그인 성공 시
			session.setAttribute("loginok", "yes");
			session.setAttribute("saveid", saveid?"yes":"no");	// saveid 가 체크되어 있으면 yes 아니면 no
			session.setAttribute("myid", myid);
			
			// 아이디에 해당하는 이름 얻기
			String myname = memberDao.getData(myid).getName();
			session.setAttribute("myname", myname);
			
			// 아이디에 해당하는 사진 얻기
			String myphoto = memberDao.getData(myid).getPhoto();
			session.setAttribute("myphoto", myphoto);
			
			map.put("success", true);
		} else {
			map.put("success", false);		// 로그인 실패 시
		}
		
		return map;
	}
	
	@PostMapping("/api/v1/auth/sign-in")
	@ResponseStatus(code = HttpStatus.OK)
	
	
	
	@GetMapping("/login/logout")
	@ResponseBody public void logout(HttpSession session) {
		session.removeAttribute("loginok");
	}
	
	// 프로필 사진 변경
	@PostMapping("/login/photochange")
	@ResponseBody Map<String, String> photoChange(@RequestParam MultipartFile upload,
				HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		// 현재 로그인한 아이디 얻기
		String myid = (String)session.getAttribute("myid");
		
		// 사진을 업로드할 경로
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 랜덤 파일명 얻기
		String fileName = UUID.randomUUID().toString();
		
		// 사진 업로드
		try {
			upload.transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// db 수정
		memberDao.updatePhoto(fileName, myid);
		
		session.setAttribute("myphoto", fileName);
		Map<String, String> map = new HashMap<String, String>();
		map.put("fileName", fileName);
		
		return map;
	}
}
