package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.RoomDTO;
import com.exception.MyException;

public class RoomService {

	public void roomInsert(RoomDTO dto) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			int n = session.insert("RoomMapper.roomInsert", dto);
			
			if(n != 1) {
				session.rollback();
				throw new MyException("룸 추가 에러");
			} else {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("룸 추가 에러");
		} finally {
			session.close();
		}
	}
}
