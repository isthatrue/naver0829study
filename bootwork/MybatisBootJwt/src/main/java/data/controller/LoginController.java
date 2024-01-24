package data.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import security.setting.JwtTokenProvider;
import security.setting.UserAuthentication;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	
	@PostMapping("/login/auth")
	public Map<String, Object> login(@RequestBody MemberDto dto) {
		
		System.out.println("myid = " + dto.getMyid() + ", pass = " + dto.getPass());
		
		Map<String, Object> map = new HashMap<>();
		
		// 해당 아이디에 대한 멤버가 있는 지 가져오기
		MemberDto dto2 = memberService.getLogin(dto.getMyid());
		System.out.println(dto2);
		
		if(dto2 == null) {
			// 해당 아이디가 없는 경우
			map.put("result", "noid");
		} else {
			// 해당 아이디가 있는 경우
			// 비번을 얻어서 비교
			String dbPass = dto2.getPass();
			
			// 입력한 비번과 db의 암호화된 비번이 맞을 경우 토큰을 얻어서 보낸다.
			// result 에는 success 로 보낸다.
			// 비번이 틀린 경우는 result 에 "nopass"라고 보낸다.
			
			String pass = dto.getPass();		// 로그인 시 입력한 비번
			String myid = dto.getMyid();		// 로그인 시 입력한 아이디
			
			
			boolean b = passwordEncoder.matches(pass, dbPass);
			if(b) {
				// 비번이 맞는 경우
				map.put("result", "success");
				
				// 토큰을 얻어보자
				Authentication auth = new UserAuthentication(myid, null, null);
				String token = JwtTokenProvider.generateToken(auth, myid);
				System.out.println("token = " + token);
				
				map.put("token", token);
				
			} else {
				// 비번이 틀린 경우
				map.put("result", "nopass");
			}
		}
				
		return map;
	}
}
