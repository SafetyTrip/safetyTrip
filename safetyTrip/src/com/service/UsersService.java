package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.UsersDTO;
import com.exception.MyException;

public class UsersService {
	public UsersDTO login(HashMap<String, String> map) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		UsersDTO dto = null;
		try {
			dto = session.selectOne("UsersMapper.login",map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("로그인 에러");
		} finally {
			session.close();
		}
		return dto;
	}// end login
	
	
	public void usersAdd(UsersDTO dto) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			int n = session.insert("UsersMapper.usersAdd", dto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("회원 등록 에러");
		} finally {
			session.close();
		}
	}// end usersAdd

	public int usersIdCheck(String userid) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			count = session.selectOne("UsersMapper.usersIdCheck", userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("멤버 아이디 체크 에러");
		} finally {
			session.close();
		}
		return count;
	}

	public int userEmailCheck(String email) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			count = session.selectOne("UsersMapper.usersEmailCheck", email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("이메일 아이디 체크 에러");
		} finally {
			session.close();
		}
		return count;
	}

	public int usersUnameCheck(String uname) throws MyException {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			count = session.selectOne("UsersMapper.usersUname", uname);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("닉네임 아이디 체크 에러");
		} finally {
			session.close();
		}
		return count;
	}// usersIdCheck
}
