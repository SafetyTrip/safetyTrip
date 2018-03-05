package com.service;

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
}
