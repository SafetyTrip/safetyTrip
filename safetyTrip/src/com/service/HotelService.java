package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.HotelDTO;
import com.exception.MyException;

public class HotelService {

	public void hotelInsert(HotelDTO dto) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			int n = session.insert("HotelMapper.hotelInsert", dto);
			
			if(n != 1) {
				session.rollback();
				throw new MyException("호텔 추가 에러");
			} else {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("호텔 추가 에러");
		} finally {
			session.close();
		}
	}
	
	public List<HotelDTO> hotelSelectListBycityno(List<Integer> list) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<HotelDTO> hList = null;
		
		try {
			hList = session.selectList("HotelMapper.hotelSelectListBycityno", list);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("호텔 리스트 검색 에러");
		} finally {
			session.close();
		}
		
		return hList;
	}
}
