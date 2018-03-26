package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.dto.QnADTO;
import com.dto.QnAImgDTO;

public class QnAService {

	
	//QnAImg List만들기
	public List<QnAImgDTO> imglist(){
		SqlSession session = MySqlSessionFactory.getSession();
		List<QnAImgDTO> list = null;
		try {
			list = session.selectList("qnaimgList");
		}finally {
			session.close();
		}
		return list;
	}
	//End imgList()
	
	
	//QnA List만들기
		public List<QnADTO> list(){
			SqlSession session = MySqlSessionFactory.getSession();
			List<QnADTO> list = null;
			try {
				list = session.selectList("qnaList");
			}finally {
				session.close();
			}
			return list;
		}
		//End List()
	
	
	
	
}
