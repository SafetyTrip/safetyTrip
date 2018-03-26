package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.QnADTO;
import com.dto.QnAImgDTO;
import com.service.QnAService;

@WebServlet("/qnaUI")
public class QnAUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	QnAService service = new QnAService();
		
		List<QnAImgDTO> imglist = service.imglist();
		List<QnADTO> list = service.list();
		
		request.setAttribute("imglist", imglist);
		request.setAttribute("list", list);
	
		RequestDispatcher dis = request.getRequestDispatcher("qna.jsp");
		dis.forward(request, response);
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
