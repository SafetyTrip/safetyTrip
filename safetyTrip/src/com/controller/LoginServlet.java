package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UsersDTO;
import com.exception.MyException;
import com.service.UsersService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);

		System.out.println(userid);
		System.out.println(passwd);

		UsersService service = new UsersService();
		String nextPage = null;
		try {
			System.out.println(map);
			UsersDTO dto = service.login(map);
			if (dto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login",dto);
				System.out.println("성공1111");
				nextPage = "Main.jsp";
			} else {
				System.out.println("에러222");
				nextPage = "LoginUIServlet";
			}

		} catch (MyException e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
