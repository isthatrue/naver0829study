<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
</style>
</head>
<%
	Cookie[] cookies = request.getCookies();
	boolean find = false;
	if (cookies != null) {
		for (Cookie ck : cookies) {
			// 저장된 쿠키 이름 얻기
			String name = ck.getName();
			if (name.equals("loginok")) {
				find = true;	// 해당 쿠키가 존재하면 true
			}
		}
	}
%>
<body>
<%
	if (!find) { %>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요.");
			history.back();
		</script>
	<% } else { %>
		<pre style="width: 500px;">
		[스포츠서울 | 박효실기자] 아이브 안유진이 빛이 나는 화보컷으로 팬들을 홀렸다.
		안유진은 30일 자신의 채널에 명품 브랜드 펜디 화보를 올려 눈길을 끌었다.
		펜디 로고가 촘촘히 박힌 니트 카디건에 니트 치마를 입은 안유진은 왼쪽 어깨를 살짝 드러내는 스타일링으로 요염한 분위기를 발산한다.
		신규 앨범 ‘아이 해브 마인’(I‘VE MINE)을 발표하면서 긴머리를 자르고 단발 레이어드컷으로 변신한 안유진은 훨씬 발랄하고 생기 넘치는 모습이다.
		한편 아이브는 지난 13일 첫번째 EP앨범 ‘아이 해브 마인’을 공개했다. ’오프 더 레코드‘, ’배디‘, ’이더 웨이‘ 등 트리플 타이틀곡이 수록된 앨범이다.
		지난 앨범에서 건강 문제로 함께 하지 못했던 레이가 합류해 다시 완전체 활동을 펼쳤다.
		본업은 물론 예능 루키로도 왕성한 활동 중인 안유진은 tvN ’뿅뿅 지구오락실‘ 시즌1에 이어 시즌2에서도 퀴즈면 퀴즈, 추격이면 추격, 만점 활약하며 인기를 끌었다.
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인 페이지로 이동</a>
	<% }
	
%>
</body>
</html>