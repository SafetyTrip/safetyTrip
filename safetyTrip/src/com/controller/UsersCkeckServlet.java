package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.UsersService;

@WebServlet("/UsersCkeckServlet")
public class UsersCkeckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String sendType = request.getParameter("sendType");
		String sendData = request.getParameter("sendData");
		String mesg ="";
		System.out.println(sendType);
		System.out.println(sendData);
		
		if(sendType.equals("userid")) {
		System.out.println(sendData);		
		
		UsersService service = new UsersService();
		mesg = "아이디 사용 가능";
		try {
			int count = service.usersIdCheck(sendData);
			if (count == 1) {
				mesg = "아이디 중복";
			}
		} catch (MyException e) {
			mesg = e.getMessage();
			
			}
		}
		else if(sendType.equals("email")) {
			System.out.println(sendData);
			
			UsersService service = new UsersService();
			mesg = "이메일 사용 가능";
			try {
				int count = service.userEmailCheck(sendData);
				if (count == 1) {
					mesg = "이메일 중복";
				}
			} catch (MyException e) {
				mesg = e.getMessage();

			}
		}		
		else if(sendType.equals("uname")) {
			System.out.println(sendData);
			
			UsersService service = new UsersService();
			mesg = "닉네임 사용 가능";
			try {
				int count = service.usersUnameCheck(sendData);
				if (count == 1) {
					mesg = "닉네임 중복";
				}
			} catch (MyException e) {
				mesg = e.getMessage();
			}
		}
		response.setContentType("text/html;charset =UTF-8");
		PrintWriter out = response.getWriter();
		out.print(mesg);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
