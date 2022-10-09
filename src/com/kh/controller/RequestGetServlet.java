package com.kh.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {

	// 상수 필드
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// 생성자
	public RequestGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) // doGet()
			throws ServletException, IOException {
		/*
		 * form 태그에서 GET 방식으로 요청했다면 이 doGet() 메소드가 호출된다
		 * 
		 * 첫번째 매개변수인 HttpServletRequest request 매개변수에는 요청시 전달된 내용물들이 들어감. (사용자가 입력한 값,
		 * 요청 전송 방식, 요청한 사용자의 IP 주소 등등 ...)
		 * 
		 * 두번째 매개변수인 HttpServletResponse response 매개변수에는 요청을 처리한 후 응답할 때 사용하는 객체 (응답 시
		 * 필요한 메소드들을 호출)
		 * 
		 * -> request 객체로부터 요청 시 전달 값들을 뽑아 처리 후에 response 객체로 응답
		 * 
		 * 우선, 요청을 처리하기 위해 요청 시 전달된 값(사용자가 입력한 값)들을 뽑는다. request 객체의 parameter라는 영역 안에
		 * 사용자가 입력한 값들이 key-value 세트로 담겨있음 (name-value)
		 * 
		 * 따라서 request의 parameter 영역으로부터 전달된 데이터를 뽑는 메소드를 이용한다. -
		 * request.getParameter("키값") : String 타입의 value를 리턴 -> 무조건 문자열 형으로 반환되기 때문에 다른
		 * 자료형으로 변경하려면 파싱해야함
		 * 
		 * -request.getParameterValues("키값") : String[] 형태의 밸류 값들을 리턴 -> 하나의 key 값으로 여러
		 * 개의 value를 받는 경우 사용한다(체크박스, etc...)
		 */

		String name = request.getParameter("name"); // test1.do 페이지의 name 속성에 담겨있는 value 담음
//		텍스트 상자가 비어있을 경우에 null이 아닌 "" 빈 문자열이 넘어간다
		System.out.println("name : " + name);

		String gender = request.getParameter("gender");
//		radiobutton 같은 경우엔 아무것도 체크하지 않았을 경우에 null 값이 넘어간다.
//		view에서 제출할 때 name(text)은 아무것도 입력하지 않아도 key가 넘어가지만
//							gender(radiobutton)는 key 자체가 넘어가지 않음
		System.out.println("gender : " + gender);

		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("age : " + age);

		String city = request.getParameter("city");
		System.out.println("city : " + city);

		double height = Double.parseDouble(request.getParameter("height"));
		System.out.println("height : " + height);

		String[] foods = request.getParameterValues("food");
		if (foods != null) {
//			for (String index : foods) {
//				System.out.println(index);
//			}
			System.out.println("food : " + String.join(",", foods));
//			String.join("구분자", 배열명)
//			배열에 있는 모든 값들을 구분자를 통해서 하나의 문자열로 연이어 리턴해주는 메소드
		} else {
			System.out.println("좋아하는 음식 : 없음");
		}

//		이 뽑아낸 값들을 가지고 VO 객체로 가공 후 Service 페이지로 요청 처리해야함 (Controller의 역할)
//		보통의 흐름 : Service의 메소드 호출 시 뽑은 값들을 VO로 가공하여 전달 -> DAO 호출 -> DB SQL문 실행 -> 결과 리턴

//		DB가 있다는 가정하에 아래의 구문이 실행됐을 것
//		int result = new MemberService().insertMember(m);

//		if(result > 0) : 성공 시에는 성공 화면, 실패 시에는 실패 화면 호출
//		Service와 DAO 페이지는 앞으로도 거의 변동이 없음 -> View와 Controller 단의 소스 코드만 변경

//		위와 같은 요청 처리를 다 했다는 가정하에 사용자가 보게 될 응답 페이지를 만들어 리턴

//		 요청에 대한 응답 페이지 반환하기
//		 1. 자바를 이용하는 방법 : JAVA 코드 내에 HTML 코드를 기술
//		 2. JSP를 이용하는 방법 : HTML 코드 내에 JAVA 코드를 기술

//		* 자바를 이용하는 방법
//		장점 : JAVA 코드 내에 작성하기 때문에 반복문이나 조건문, 메소드를 활용 가능
//		단점 : 복잡, 혹시라도 후에 HTML 코드를 수정하게 될 경우 JAVA 코드를 건드려야 함
//		수정된 내용을 재반영하려면 서버를 재시작 해야함

//		-> response 객체를 통해 사용자에게 html(응답화면) 전달
//		1) 이제부터 내가 출력할 내용은 문서 형태의 html이고 인코딩 방식은 utf-8임을 명시

		response.setContentType("text/html; charset=utf-8");

//		2) 응답하고자 하는 사용자 (요쳥했던 사용자)와의 스트림(클라이언트와의 통로) 생성

		PrintWriter out = response.getWriter();

//		3) 생성된 스트림을 통해 응답 html 구문을 한 줄씩 출력
//		print, println, printf
		out.println("<html>");

		out.println("<head>");
		out.println("<style>");
		out.println("h2 {color : red;}");
		out.println("#name {color:orange;}");
		out.println("#age {color:yellow;}");
		out.println("#city {color:green;}");
		out.println("#height {color:blue;}");
		out.println("#gender {color:navy;}");
		out.println("li {color:purple;}");
		out.println("</style>");
		out.println("</head>");

		out.println("<body>");

		out.println("<h2>개인정보 응답화면</h2>");

		out.printf("<span id='name'>%s님은 </span>", name);
		out.printf("<span id='age'>%d살이며 </span>", age);
		out.printf("<span id='city'>%s에 살며 </span>", city);
		out.printf("<span id='height'>키는 %.1fcm이고, </span>", height);
		
		out.print("성별은 ");
		if(gender == null) {
			out.print("선택을 안헀습니다. <br>");
		}else {
			if(gender.equals("M")) {
				out.print("<span id='gender'>남자 입니다.</span>");
			}
			if(gender.equals("F")){
				out.print("<span id='gender'>여자 입니다.</span>");
			}
		}
		
		out.print("좋아하는 음식은");
		
		if(foods == null) {
			out.print("없습니다.");
		}else {
			out.print("<ul>");
			for (String food : foods) {
				out.printf("<li>%s</li>",food);
			}
			out.print("</ul>");
		}
		out.println("</body>");

		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) // doPost()
			throws ServletException, IOException {
		doGet(request, response);
	}

}
