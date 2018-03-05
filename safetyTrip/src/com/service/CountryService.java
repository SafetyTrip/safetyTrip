package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.CountryDTO;
import com.exception.MyException;

public class CountryService {

		public void countryInsert(CountryDTO dto) throws MyException {
			SqlSession session = MySqlSessionFactory.getSession();
			
			try {
				int n = session.insert("CountryMapper.countryInsert", dto);
				
				if(n != 1) {
					session.rollback();
					throw new MyException("국가 추가 에러");
				} else {
					session.commit();
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw new MyException("국가 추가 에러");
			} finally {
				session.close();
			}
		}
		
		public CountryDTO countrySelectByCname(String cname) throws MyException {
			SqlSession session = MySqlSessionFactory.getSession();
			CountryDTO dto = null;
			
			try {
				dto = session.selectOne("CountryMapper.countrySelectByCname", cname);
			} catch(Exception e) {
				e.printStackTrace();
				throw new MyException("국가 검색 에러");
			} finally {
				session.close();
			}
			
			return dto;
		}
}
