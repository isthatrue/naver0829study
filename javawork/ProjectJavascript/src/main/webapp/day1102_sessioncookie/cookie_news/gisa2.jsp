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
		[스포츠서울 | 함상범 기자] 배우 남규리가 파리에서 포착된 명품 아우라로 시선을 집중시켰다.
		연예기획사 하이어랭크 엔터테인먼트는 31일 프랑스 파리 일정을 소화 중인 남규리의 드레스 사진을 공개했다.
		모델 못지않은 포즈와 함께 우아한 무드를 완성하며 ‘월드 클래스’의 명품 아우라를 입증하는 동시에 독보적인 존재감을 발산한 남규리를 향한 찬사가 이어진다.
		특히 청순하게 늘어뜨린 긴 생머리와 광채가 돋보이는 주얼리로 포인트를 준 룩은 남규리만의 청초하면서도 아름다운 비주얼이 눈에 띈다.
		할리우드 배우 레아 세이두와의 만남도 이목을 끌었다. 한 행사를 통해 만난 두 사람은 첫 대면에서도 남다른 분위기와 반가움이 넘치는 모습을 보여주며 완벽한 투 샷을 완성해 화제를 모았다. 쉽게 볼 수 없는 두 배우를 향해 카메라 플래시 세례가 끊이지 않았다는 후문이다.
		이에 더해 남규리는 자신의 인스타그램을 통해 파리에서의 일상 사진 또한 공유해 주목받고 있다. 고유의 무드와 디테일을 보여주는 룩으로 남다른 패션 감각을 뽐내기도 하고 고혹적인 드레스 자태를 선보여 팬들은 물론 대중들의 마음을 설레게 하기도 했다.
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인 페이지로 이동</a>
	<% }
	
%>
</body>
</html>