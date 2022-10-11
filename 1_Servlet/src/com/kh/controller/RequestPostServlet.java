package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		System.out.println("잘 실행 되나 ? ? ?");

//		POST 방식으로 요청할 경우 값을 뽑기 전에 우선 UTF-8 방식으로 인코딩 설정을 해야한다
//		POST 방식의 기본 인코딩 설정이 ISO-8859-1 이기 때문
//		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8"); // 값을 뽑기 전에 무조건 실행해야함

//		요청 시 전달된 값들은 request의 parameter 영역에 key-value 세트로 담겨있음 (마치 Map처럼)

//		request.getParameter("키값") : String 타입의 value return
//		request.getParameterValues("키값") : Stirng[] 타입의 values return

		String name = request.getParameter("name"); // "홍길동" / ""
		String gender = request.getParameter("gender"); // "M" / "F" / null
		int age = Integer.parseInt(request.getParameter("age"));
//		주의할 점 "20a" 또는 "" > NumberFormatException 발생
		String city = request.getParameter("city"); // "서울시"
		double height = Double.parseDouble(request.getParameter("height"));
		String[] foods = request.getParameterValues("food"); // ["한식","중식","일식"] / null

		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		if (foods != null) {
			System.out.println("foods : " + String.join(",", foods));
		} else {
			System.out.println("좋아하는 음식 : 없음");
		}
		
//		원래의 흐름
//		Controller -> Service -> DAO -> DB
//					<-		<-		<-
//		if(result>0) : 성공
//		else : 실패
		
//		위의 요청 처리를 다 했다는 가정하에 사용자가 보게 될 응답 페이지 출력
		
//		단, 그 응답화면(JSP)에서 필요로 하는 데이터들을 request 객체에 담아서 보내줘야 함
//		-> request의 attribute 영역 (key-value 세트로)
//		request.setAttribute("key","value");
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
//		응답 페이지 출력하는 방법
//		1. 자바를 이용하는 방법 : JAVA 코드 내에 HTML 코드를 기술
//		2. JSP를 이용하는 방법 : HTML 내에 JAVA 코드를 기술
//		Java Server PAge : HTML 내에 JAVA 코드를 기술하여 동적인 페이지 구현 가능
		
//		응답 페이지를 만드는 과정을 Java 코드로 직접 하는 것이 아니라
//		JSP에게 '위임'할 것(대신 응답 페이지 만들어달라고 떠넘기기)
		
//		응답 페이지 위임을 위해 필요한 객체 : RequestDispatcher
		
//		1. 위임하고자 하는 JSP 뷰 파일을 선택하면서 객체 생성
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		
//		2. 포워딩 작업
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
