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
		[스포츠서울ㅣ성보람기자] 디즈니+ 드라마 ‘무빙’ 을 통해 연기력을 인정받은 고윤정이 겨울 요정으로 변신했다.
		패션 브랜드 마리떼 프랑소와 저버(MARITHÉ FRANÇOIS GIRBAUD)가 브랜드 모델 고윤정과 함께한 2023 겨울 캠페인 화보를 공개했다.
		이번 화보는 ‘COOL & COMFY’이 컨셉인 화보 속 고윤정은 차분하면서도 그윽한 눈빛과 여유롭고 우아한 분위기로 다채로운 스타일을 완벽하게 소화하며 독보적인 겨울 여신 비주얼을 선보였다.	
		특히 고윤정은 긴 생머리를 늘어트리고 카멜 컬러의 더플 코트에 롱부츠를 매치해 클래식한 룩을 선보이는가 하면 유니크한 블루 컬러의 윈터 액세서리를 셋업으로 착용하고 사랑스러운 매력까지 넘나들며 2023년 대세 배우임을 입증했다.
		고윤정이 착용한 마리떼 프랑소와 저버의 2023년 겨울 컬렉션은 공식 온라인 스토어 및 전국 오프라인 스토어를 통해 만나볼 수 있다.
		한편, 배우 고윤정은 최근 디즈니+ 오리지널 ‘무빙’으로 2023 아시아콘텐츠어워즈 & 글로벌 OTT 상에서 여자 신인상 수상의 영예를 안으며 20대 대표 여배우로 자리매김했다.
		이어 2024년 ‘슬기로운 의사 생활’의 스핀 오프 드라마 tvN ‘언젠가는 슬기로울 전공의생활’을 차기작으로 확정했다.
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인 페이지로 이동</a>
	<% }
	
%>
</body>
</html>