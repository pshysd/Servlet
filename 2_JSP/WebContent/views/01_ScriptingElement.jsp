<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Insert title here</title>
    </head>

    <body>
        <!-- HTML 주석 : 개발자 도구에 노출됨 -->
        <%-- JSP 주석 : 개발자 도구에 노출되지 않음 --%>

        <h1>스크립팅 원소</h1>

        <%! // 선언문 : 이 안에 멤버 변수나 메소드를 선언할 수 있음 public
        String test() { return "메소드 호출됨" ; } %> <% // 스크립틀릿 : 이 안에
        일반적인 자바 코드를 작성할 수 있음 (변수 선언 및 초기화, 제어문, 메소드
        호출 등 가능) // -> 자바 코드 문법에 맞게 작성해야 함 // sample) 누적 합
        구하는 코드 int total = 0; for(int i = 0; i < 101; i++){ total +=i; }
        System.out.println("덧셈 끝 !! 결과는 " + total); %>

        <p>
            화면으로 출력하고자 한다면 <br />
            표현식(출력식)으로 출력 가능 : <%=total %> <br />
        </p>
    </body>
</html>
