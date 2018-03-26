package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UsersDTO;
import com.exception.MyException;
import com.service.UsersService;

import oracle.sql.DATE;

@WebServlet("/UsersAddServlet")
public class UsersAddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String name = request.getParameter("name");
		String passport = request.getParameter("passport");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String post = request.getParameter("post");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		System.out.println(userid);
		System.out.println(passwd);
		System.out.println(email);
		System.out.println(uname);
		System.out.println(name);
		System.out.println(passport);
		System.out.println(sex);
		System.out.println(birth);
		System.out.println(post);
		System.out.println(address1);
		System.out.println(address2);
		
		request.setCharacterEncoding("UTF-8");
		UsersDTO dto = new UsersDTO();
		
		dto.setUserid(userid);
		dto.setPasswd(passwd);
		dto.setEmail(email);
		dto.setUname(uname);
		dto.setName(name);
		dto.setPassport(passport);
		dto.setSex(sex);
		dto.setBirth(birth);
		dto.setPost(Integer.parseInt(post));
		dto.setAddress1(address1);
		dto.setAddress2(address2);		
		
		UsersService service= new UsersService();
		String mesg ="회원가입 성공";
		
		try {
			service.usersAdd(dto);
			System.out.println("회원가입 성공");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(mesg);
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
