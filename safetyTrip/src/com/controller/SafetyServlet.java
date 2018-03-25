package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.SafetyDTO;
import com.exception.MyException;
import com.service.SafetyService;

@WebServlet("/safety")
public class SafetyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sno = request.getParameter("sno");
    	SafetyService service = new SafetyService();
    	SafetyDTO sDTO = null;
    	
    	try {
    		sDTO = service.safetySelectOneBySno(sno);
		} catch (MyException e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("sDTO", sDTO);
    	RequestDispatcher dis = request.getRequestDispatcher("safety.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
