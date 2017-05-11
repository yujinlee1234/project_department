package com.dgit.department.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Employee;
import com.dgit.department.dto.Title;
import com.dgit.department.mappers.DepartmentMapper;
import com.dgit.department.mappers.EmployeeMapper;
import com.dgit.department.mappers.TitleMapper;
import com.dgit.department.util.MyBatisSqlSessionFactory;

public class EmployeeService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	private static final EmployeeService instance = new EmployeeService();

	private EmployeeService() {}
	public static EmployeeService getInstance() {
		return instance;
	}
	
	public List<Employee> getAllEmployees(){
		if (logger.isDebugEnabled()) {
			logger.debug(" getAllEmployees() - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper eMapper = sqlSession.getMapper(EmployeeMapper.class);
		try{
			List<Employee> returnList = eMapper.selectAllItem();
			return returnList;
			
		}finally{
			sqlSession.close();
		}	
	}
	
	public Employee getEmployee(int eno){
		if (logger.isDebugEnabled()) {
			logger.debug("getDepartment(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper eMapper = sqlSession.getMapper(EmployeeMapper.class);
		try{
			return eMapper.selectItem(eno);
		}finally{
			sqlSession.close();
		}	
	}
	
	public int insertEmployee(Employee employee){
		if (logger.isDebugEnabled()) {
			logger.debug("insertEmployee(Employee) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper eMapper = sqlSession.getMapper(EmployeeMapper.class);
		try{
			int result = eMapper.insertItem(employee);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int updateEmployee(Employee employee){
		if (logger.isDebugEnabled()) {
			logger.debug("updateEmployee(Employee) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper eMapper = sqlSession.getMapper(EmployeeMapper.class);
		try{
			int result = eMapper.updateItem(employee);
			sqlSession.commit();
			
			return result;
		}finally{
			sqlSession.close();
		}	
	}
	
	public int deleteEmployee(int eno){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteEmployee(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper eMapper = sqlSession.getMapper(EmployeeMapper.class);
		try{
			int result = eMapper.deleteItem(eno);
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
		EmployeeMapper eMapper = sqlSession.getMapper(EmployeeMapper.class);
		try{
			int result = 0;
			if(eMapper.getMaxNum()!= null){
				result = (int)eMapper.getMaxNum();
			}		
			return result;
		}finally{
			sqlSession.close();
		}	
	}
}
