package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.ReviewDTO;
import com.exception.MyException;

public class ReviewService {

	public void reviewInsert(ReviewDTO dto) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			int n = session.insert("ReviewMapper.reviewInsert", dto);
			
			if(n != 1) {
				session.rollback();
				throw new MyException("리뷰 추가 에러");
			} else {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("리뷰 추가 에러");
		} finally {
			session.close();
		}
	}
	
	public List<ReviewDTO> reivewSelectListBycityno(List<Integer> list) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		List<ReviewDTO> rList = null;
		
		try {
			list = session.selectList("ReviewMapper.reivewSelectListBycityno", list);
		} catch(Exception e) {
			e.printStackTrace();
			throw new MyException("리뷰 리스트 검색 에러");
		} finally {
			session.close();
		}
		
		return rList;
	}
}
