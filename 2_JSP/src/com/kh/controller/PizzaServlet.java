package com.kh.controller;

import java.io.IOException;
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
		
//		System.out.println("잘 실행 되나요~~~");
		
//		GET 방식으로 요청할 경우 따로 인코딩 필요없음
//		POST 방식일 경우 request.setCharacterEncoding("UTF-8"); 구문을 먼저 실행해야 한다.
		
//		요청 시 전달 값 뽑기(request의 parameter 영역으로부터)
//		request.getParameter("키값") : String 타입의 value 하나 리턴
//		request.geTParameterValues("키값) : String[] 타입의 values 리턴
//		-> 만약 key가 존재하지 않는다면(radio나 checkbox의 경우 체크 안되면 키값이 x)
//		없는 key를 제시할 경우 null 리턴
		
//		뽑아야 할 값들
//		userName : 주문자명
//		phone : 휴대전화
//		address : 주소
//		message : 요청사항
//		pizza : 피자 종류
//		topping : 토핑 선택 (여러개)
//		side : 사이드 선택 (여러개)
//		payment : 결제방식
		
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
//		VO 객체로 가공
		
//		VO 객체로 가공한 전달 값을 Service단으로 넘기기 -> DAO -> DB
//		SQL문 실행 결과를 리턴받기
		
//		-- DB까지 요청이 들어갔다는 가정하에 자바 로직으로 간단하게 처리하기
		int price= 0;
		
		switch(pizza){
			case "콤비네이션피자" :
				
		}
		
		
//		실행 결과에 따른 응답화면 지정 (jsp한테 위임)
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
