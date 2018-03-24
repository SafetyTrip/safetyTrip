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
import com.dto.HotelDTO;
import com.dto.ReviewDTO;
import com.dto.SafetyDTO;
import com.exception.MyException;
import com.service.CityService;
import com.service.HotelService;
import com.service.ReviewService;
import com.service.SafetyService;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String couno = request.getParameter("no");
    	String cname = request.getParameter("name");
    	
    	CountryDTO cDTO = new CountryDTO();
    	cDTO.setCouno(Integer.parseInt(couno));
    	cDTO.setCname(cname);
    	
    	SafetyService sService = new SafetyService();
    	CityService cService = new CityService();
    	HotelService hService = new HotelService();
    	ReviewService rService = new ReviewService();
    	
    	List<SafetyDTO> sList = null;
    	List<Integer> citynoList = null;
    	List<HotelDTO> hList = null;
    	List<ReviewDTO> rList = null;
    	
    	try {
    		// safety 정보
    		sList = sService.safetySelectListByCouno(couno);
    		// 도시 no 정보
    		citynoList = cService.getCitynoListByCouno(couno);
    		
    		System.out.println(citynoList);
    		if(citynoList.size() > 0) {
	    		// 호텔 정보
	    		hList = hService.hotelSelectListBycityno(citynoList);
	    		
	    		// review 정보
//	    		rList = rService.reivewSelectListBycityno(citynoList);
    		}
		} catch (MyException e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("cDTO", cDTO);
    	request.setAttribute("sList", sList);
    	request.setAttribute("hList", hList);
    	request.setAttribute("rList", rList);
    	
    	RequestDispatcher dis = request.getRequestDispatcher("country.jsp");
		dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
