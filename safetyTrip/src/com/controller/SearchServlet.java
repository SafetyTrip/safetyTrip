package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CountryDTO;
import com.exception.MyException;
import com.service.CountryService;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String continent = (String) request.getParameter("continent");
    	String word = (String) request.getParameter("word");
    	CountryService cService = new CountryService();
    	List<CountryDTO> cList = null;
    	
    	try {
    		if(continent == null) {
    			cList = cService.countrySelectList(word);
    		} else {
    			cList = cService.countrySelectListByContinent(continent);
    		}
		} catch (MyException e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("cList", cList);
    	RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
		dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
