package com.dgit.department.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Title;
import com.dgit.department.mappers.DepartmentMapper;
import com.dgit.department.mappers.EmployeeMapper;
import com.dgit.department.mappers.TitleMapper;
import com.dgit.department.util.MyBatisSqlSessionFactory;

public class DepartmentService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(DepartmentService.class);
	private static final DepartmentService instance = new DepartmentService();

	private DepartmentService() {}
	public static DepartmentService getInstance() {
		return instance;
	}
	
	public List<Department> getAllDepartments(){
		if (logger.isDebugEnabled()) {
			logger.debug(" getAllDepartments() - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
		try{
			List<Department> returnList = dMapper.selectAllItem();
			return returnList;
			
		}finally{
			sqlSession.close();
		}	
	}
	
	public Department getDepartment(int dcode){
		if (logger.isDebugEnabled()) {
			logger.debug("getDepartment(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
		try{
			return dMapper.selectItem(dcode);
		}finally{
			sqlSession.close();
		}	
	}
	
	public int insertDepartment(Department department){
		if (logger.isDebugEnabled()) {
			logger.debug("insertDepartment(Department) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
		try{
			int result = dMapper.insertItem(department);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int updateDepartment(Department department){
		if (logger.isDebugEnabled()) {
			logger.debug("updateDepartment(Department) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
		try{
			int result = dMapper.updateItem(department);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int deleteDepartment(int dcode){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteDepartment(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
		try{
			int result = dMapper.deleteItem(dcode);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int getMaxNo(){
		if (logger.isDebugEnabled()) {
			logger.debug("getMaxEno() - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
		try{
			int result = 0;
			if(dMapper.getMaxNum()!= null){
				result = (int)dMapper.getMaxNum();	
			}		
			return result;
		}finally{
			sqlSession.close();
		}	
	}
}
