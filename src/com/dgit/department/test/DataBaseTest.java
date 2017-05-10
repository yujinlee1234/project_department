package com.dgit.department.test;

import java.sql.Connection;

import org.junit.Test;

import com.dgit.department.jdbc.DBConn;
import com.dgit.department.setting.dao.DataBaseDao;

public class DataBaseTest {
	
	@Test
	public void testDBConnection(){
		Connection conn = DBConn.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void testDBExists(){
		DataBaseDao dbDao = DataBaseDao.getInstance();
		dbDao.createDatabase();
	}
	
/*	@Test
	public void testEmployeeTableExists(){
		Connection conn = DBConn.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void testDepartmentTableExists(){
		Connection conn = DBConn.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void testTitleTableExists(){
		Connection conn = DBConn.getConnection();
		System.out.println(conn);
	}*/
}
