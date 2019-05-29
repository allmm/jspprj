package com.newlecture.web.admin.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet { //extends HttpServlet 서블릿으로 만들기

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Map<String,String>> members = new ArrayList<>();
		 Map<String,String> member;

			member = new HashMap<>();
			member.put("id","dragon");
			member.put("name","손오공");
			members.add(member);
			
			member = new HashMap<>();
			member.put("id","moon");
			member.put("name","문재인");
			members.add(member);
		// 공유 저장 공간 = 상태 저장 공간
		//application(모든 사용자에게 공유), session(한 사용자에게만 공유), request(forward에서만 씀)
		//EL은 공유 저장 공간에 있는 데이터만 꺼내고 출력한다.
			request.setAttribute("members", members); // request에 담는다 getAttribute로 꺼낸다.
			request.setAttribute("x", 30);
			request.setAttribute("y", new int[]{3,4,5});
			request.setAttribute("member", member);
			request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}
