<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
// 이 구문을 스크립틀릿이라고 해서 HTML 문서 내에 JAVA코드를 기술할 수 있는 영역 
// 현재 이 jsp에서 필요로 하는 데이터들 -> request객체의 attribute 영역에 (key-value 세트로) 담겨있음 
// Object 타입은 모든타입의 최상위 부모이기 때문에 "강제형변환"해서 변수에 담으면 됨 
// 주의)다형성에 의해 잘못 DownCasting 하면 ClassCastException 발생

String name =(String) request.getAttribute("name");

int age = (int)request.getAttribute("age");

String gender = (String)request.getAttribute("gender");

String city = (String)request.getAttribute("city");

double height = (double)request.getAttribute("height");

String[] foods = (String[])request.getAttribute("foods");

System.out.println(name + age + gender + city +height + String.join(",", foods)); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<style>
h2 {
	color: red;
}

span {
	font-weight: bold;
}

#name {
	color: orange;
}

#age {
	color: yellow;
}

#city {
	color: green;
}

#height {
	color: blue;
}

#gender {
	color: navy;
}

li {
	color: purple;
}
</style>
</head>
<body>
	<h2>개인정보 응답화면</h2>

	<span id="name"><%=name%></span>님은
	<span id="age"><%=age%></span>살이고,
	<span id="city"><%=city%></span>에 거주중이며,
	<span id="height"><%=height%></span>cm 이고,
	<br /> 성별은
	<br />
	<% 
	if (gender == null) {%>
	선택을 안했습니다.
	<!-- case 1. -->
	<%} else { 
	 if (gender.equals("M")) { %><span id="gender">남자</span> 입니다.

	<!-- case 2. -->
	<% } else {%>
	<span id="gender">여자</span> 입니다.<%}
	 }%>
	<!-- case 3. -->
	좋아하는 음식은

	<%if(foods == null) {%>
	없습니다.
	<%} else { %><ul>
		<%for(int i=0; i<foods.length; i++) {%>
		<li><%=foods[i]%></li><%} %>
	</ul><%} %>
</body>
</html>
