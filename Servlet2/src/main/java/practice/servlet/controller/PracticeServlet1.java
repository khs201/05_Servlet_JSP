package practice.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pr")
public class PracticeServlet1 extends HttpServlet {

	// GET 방식 요청(method = "get"인 form 태그 제출)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String yourName = req.getParameter("yourName"); // 이름 얻어오기
		String yourAddress = req.getParameter("yourAddress"); // 나이 얻어오기
		String pizza = req.getParameter("pizza"); // 피자
		String type = req.getParameter("type"); // 도우 두께
		String[] options = req.getParameterValues("opt");

		int price = 0;

		switch (pizza) {
		case "페퍼로니":
			price += 5000;
			break;
		case "고구마":
			price += 6000;
			break;
		case "치킨":
		case "불고기":
			price += 7000;
			break;
		}

		if (type.equals("thick")) { // 두꺼운 도우일 경우
			price += 1000;
		}

		// 선택된 옵션이 있을 경우
		if (options != null) { // 아무것도 선택하지 않는다면 null, 이 경우는 선택한 경우
			for (String opt : options) { // 순차 접근

				switch (opt) {
				case "피클":
					price += 100;
					break;
				case "콜라":
					price += 200;
					break;
				case "제로 콜라":
					price += 300;
					break;
				}

			}

		} // if
		// 계산 끝!

		// 응답 형태 지정
		resp.setContentType("text/html; charset=utf-8");

		// 응답 스트림 얻어오기
		PrintWriter out = resp.getWriter();

		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");

		sb.append("<head>");
		sb.append("<title>");

		sb.append(String.format("%s님 영수증", yourName));

		sb.append("</title>");
		sb.append("</head>");

		sb.append("<body>");

		sb.append("<h3>");
		sb.append("받을 사람 : ");
		sb.append(yourName);
		sb.append("</h3>");

		sb.append(String.format("<h3>피자 받을 주소 : %s</h3>", yourAddress));

		sb.append("<ul>");

		sb.append(String.format("<li>피자 : %s</li>", pizza));
		String temp = type.equals("thick") ? "두꺼운 도우" : "얇은 도우";
		sb.append(String.format("<li>도우 두께 : %s</li>", temp));

		if (options != null) { // 선택한 옵션이 있을 경우
			sb.append("<li>");
			sb.append("사이드 추가 : ");
			for (String opt : options) {
				sb.append(opt + " ");
			}
			sb.append("</li>");

		}

		sb.append("</ul>");

		sb.append(String.format("<h3>금액 : %d원</h3>", price));

		sb.append("</body>");
		sb.append("</html>");

		out.print(sb.toString());
		out.print("<h1 style=\"color: aqua;\">HELLO, WORLD!</h1>");

		/*		System.out.println("[서버] 요청 들어옴");
				
				System.out.println("신청자명 : " + yourName);
				System.out.println("신청자 주소 : " + yourAddress);
				
				resp.setContentType("text/html; charset=utf-8"); // 응답하는 문서(데이터)의 형식과 문자 인코딩 지정
				PrintWriter out = resp.getWriter();*/
	}

}
