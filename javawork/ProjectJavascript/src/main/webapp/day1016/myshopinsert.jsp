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
   
   // 입력값을 읽어서 dto에 담기
   String sangpum = request.getParameter("sangpum");
   String color = request.getParameter("color");
   String photo = request.getParameter("photo");
   int price = Integer.parseInt(request.getParameter("price"));
   
   dto.setSangpum(sangpum);
   dto.setColor(color);
   dto.setPhoto(photo);
   dto.setPrice(price);
   
   // insert 메서드 호출
   dao.insertShop(dto);
   
   // 목록 페이지로 이동 (redirect)
   response.sendRedirect("myshop.jsp");
   
%>