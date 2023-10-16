<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	// 한글 인코딩
	request.setCharacterEncoding("UTF-8");
	
	// dao, dto 선언
	MyShopDao dao = new MyShopDao();
	MyShopDto dto = new MyShopDto();
	
	// num 포함 모든 데이터 읽기
	String sangpum = request.getParameter("sangpum");
	String color = request.getParameter("color");
	int price = Integer.parseInt(request.getParameter("price"));
	String photo = request.getParameter("photo");
	int num = Integer.parseInt(request.getParameter("num"));
	
	// dto 에 담기
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setPrice(price);
	dto.setNum(num);
	
	// updateShop 메소드 호출
	dao.updateShop(dto);
	
	// myshopdetail.jsp 로 이동하기 (? 로 num 넘겨야함)
	response.sendRedirect("myshopdetail.jsp?num=" + num);
%>