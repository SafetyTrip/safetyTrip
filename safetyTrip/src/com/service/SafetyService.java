package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.SafetyDTO;
import com.exception.MyException;

public class SafetyService {
	
	public void safetyInsert(SafetyDTO dto) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			int n = session.insert("SafetyMapper.safetyInsert", dto);
			
			if(n != 1) {
				session.rollback();
				throw new MyException("안전정보 추가 에러");
			} else {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("안전정보 추가 에러");
		} finally {
			session.close();
		}
	}
	
	public List<SafetyDTO> safetySelectListByCouno(String couno) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<SafetyDTO> list = null;
		
		try {
			list = session.selectList("SafetyMapper.safetySelectListByCouno", couno);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("안전정보 리스트 검색 에러");
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public SafetyDTO safetySelectOneBySno(String sno) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		SafetyDTO dto = null;
		
		try {
			dto = session.selectOne("SafetyMapper.safetySelectOneBySno", sno);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("안전정보 검색 에러");
		} finally {
			session.close();
		}
		
		return dto;
	}
}
