package com.dgit.department.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.department.dto.Title;
import com.dgit.department.mappers.TitleMapper;
import com.dgit.department.util.MyBatisSqlSessionFactory;

public class TitleService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(TitleService.class);
	private static final TitleService instance = new TitleService();

	private TitleService() {}
	public static TitleService getInstance() {
		return instance;
	}
	
	public List<Title> getAllTitles(){
		if (logger.isDebugEnabled()) {
			logger.debug(" getTitle() - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TitleMapper tDao = sqlSession.getMapper(TitleMapper.class);
		try{
			List<Title> returnList = tDao.selectAllTitle();
			return returnList;
			
		}finally{
			sqlSession.close();
		}	
	}
	
	public Title getTitle(int tcode){
		if (logger.isDebugEnabled()) {
			logger.debug("getTitle(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TitleMapper tDao = sqlSession.getMapper(TitleMapper.class);
		try{
			return tDao.selectTitle(tcode);
		}finally{
			sqlSession.close();
		}	
	}
	
	public int insertTitle(Title title){
		if (logger.isDebugEnabled()) {
			logger.debug("addTitle(Title) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TitleMapper tDao = sqlSession.getMapper(TitleMapper.class);
		try{
			int result = tDao.insertTitle(title);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int updateTitle(Title title){
		if (logger.isDebugEnabled()) {
			logger.debug("updateTitle(Title) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TitleMapper tDao = sqlSession.getMapper(TitleMapper.class);
		try{
			int result = tDao.updateTitle(title);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int deleteTitle(int tcode){
		if (logger.isDebugEnabled()) {
			logger.debug("updateTitle(Title) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TitleMapper tDao = sqlSession.getMapper(TitleMapper.class);
		try{
			int result = tDao.deleteTitle(tcode);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int getMaxEno(){
		if (logger.isDebugEnabled()) {
			logger.debug("getMaxEno() - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TitleMapper tDao = sqlSession.getMapper(TitleMapper.class);
		try{
			int result = tDao.getMaxNum();			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
}
