package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.CityDTO;
import com.exception.MyException;

public class CityService {

	public List<CityDTO> citySelectListByCouno(String couno) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<CityDTO> list = null;
		
		try {
			list = session.selectList("CityMapper.citySelectListByCouno", couno);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("도시 리스트 검색 에러");
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public List<Integer> getCitynoListByCouno(String couno) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<Integer> list = null;
		
		try {
			list = session.selectList("CityMapper.getCitynoListByCouno", couno);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("도시 no 리스트 검색 에러");
		} finally {
			session.close();
		}
		
		return list;
	}
}
