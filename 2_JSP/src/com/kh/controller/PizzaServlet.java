package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		GET 방식으로 요청했었음 -> 인코딩 설정 필요x
//		POST 방식일 경우 request.setCharacterEncoding("UTF-8"); 구문으로 인코딩 해줘야 함

//		요청 시 전달값 뽑기 (request의 parameter 영역으로부터)
//		request.getParameter("키값") : String 타입의 value return
//		request.getparameterValues("키값") : String[] 타입의 values return
//		-> 만약 키값이 존재하지 않는다면
//		(== radio나 checkbox같은 경우 체크가 안되면 키 값이 애초에 안 넘어감)
//		없는 키값을 제시할 경우 null이 반환됨

		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");

//		VO 객체로 가공

//		VO 객체로 가공한 전달 값을 Service로 넘기기 -> DAO -> DB
//		SQL 실행 결과를 리턴받기

//		-- DB까지 요청이 들어갔다는 전제하에 자바 로직으로 간단하게 처리해보기 --
		int price = 0;

		switch (pizza) {
		case "콤비네이션피자":
			price += 10000;
			break;
		case "불고기피자":
			price += 11000;
			break;
		case "치즈피자":
			price += 12000;
			break;
		case "포테이토피자":
			price += 13000;
			break;
		case "고구마피자":
			price += 14000;
			break;
		}

		if (topping != null) {
			for (int i = 0; i < topping.length; i++) {

				switch (topping[i]) {

				case "고구마무스":
				case "콘크림무스":
					price += 1500;
					break;
				case "파인애플추가":
				case "치즈추가":
					price += 2000;
					break;
				case "치즈크러스트":
				case "치즈바이트":
					price += 3000;
					break;
				}
			}
		}

		if (side != null) {
			for (int i = 0; i < side.length; i++) {
				switch (side[i]) {
				case "콜라":
				case "사이다":
					price += 2000;
					break;
				case "갈릭소스":
				case "핫소스":
					price += 300;
					break;
				case "피클":
				case "파마산치즈가루":
					price += 1000;
					break;
				}
			}
		}
		
		/*
		 * System.out.println("userName : " + userName); System.out.println("phone : " +
		 * phone); System.out.println("address ; " + address);
		 * System.out.println("message : " + message); System.out.println("pizza : " +
		 * pizza); System.out.println("topping : " + String.join(",",topping));
		 * System.out.println("side : " + String.join(",",side));
		 * System.out.println("payment : " + payment); System.out.println("price : " +
		 * price);
		 */
		
//		실행 결과에 따른 응답 화면 지정 (jsp)
		
//		응답 페이지에서 필요로 하는 데이터가 있을 경우
//		request의 attribute 영역에 키-밸류 세트로 데이터를 미리 담아두기 (수하물 붙이기)
//		-> request.setAttribute("key",'value");
		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address",address );
		request.setAttribute("message",message );
		request.setAttribute("pizza",pizza );
		request.setAttribute("topping",topping );
		request.setAttribute("side",side );
		request.setAttribute("payment",payment );
		request.setAttribute("price", price);
//		1) RequestDispatcher 객체 생성 (jsp 파일의 경로 제시)
		RequestDispatcher view = request.getRequestDispatcher("views/05_PizzaPayment.jsp");
//		2) 포워딩
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
