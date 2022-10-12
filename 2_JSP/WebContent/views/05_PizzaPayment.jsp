<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	// 뽑아야 할 값들
// userName : 이름
String userName = (String) request.getAttribute("userName");
// phone : 전화번호
String phone = (String) request.getAttribute("phone");
// address : 주소
String address = (String) request.getAttribute("address");
// message : 요청사항
String message = (String) request.getAttribute("message");
// pizza : 피자 종류
String pizza = (String) request.getAttribute("pizza");
// topping : 토핑
String[] topping = (String[]) request.getAttribute("topping");
// side : 사이드
String[] side = (String[]) request.getAttribute("side");
// payment : 결제 방식
String payment = (String) request.getAttribute("payment");
// price : 결제 금액
int price = (int) request.getAttribute("price");
%>
<html>
<head>
<meta charset="UTF-8" />
<title>KH Pizza Academy</title>
</head>
<body>
	<h1>피자 결제 페이지</h1>

	<h2>주문 내역</h2>

	<h4>[ 주문자 정보 ]</h4>

	<ul>
		<li>성함 : <%=userName%></li>
		<li>전화번호 <%=phone%> :
		</li>
		<li>주소 : <%=address%></li>
		<%
			if (message == "") {
		%>
		<li>요청사항 : 작성안함</li>
		<!-- case 1-->
		<%
			} else {
		%>
		<li>요청사항 : <%=message%></li>
		<!-- case 2-->
		<%
			}
		%>
	</ul>

	<br />

	<h4>[ 주문 정보 ]</h4>

	<ul>
		<li>피자 : <%= pizza %></li>
		<% if(topping == null) %>
		<li>토핑 : 선택안함</li>
		<!-- case 1 -->
		<li>토핑 :</li>
		<!-- case 2 -->
		<li>사이드 : 선택안함</li>
		<!-- case 1-->
		<li>사이드 :</li>
		<!-- case 2-->
		<li>결제 방식 :</li>
	</ul>

	<br />

	<h3>위와 같이 주문하셨습니다.</h3>
	<h2>총 가격 :</h2>

	<br />
</body>
</html>
