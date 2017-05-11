package com.dgit.department;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dgit.department.dto.Department;
import com.dgit.department.service.DepartmentService;
import com.dgit.department.service.EmployeeService;

import junit.framework.Assert;

public class DepartmentServiceTest {
	private static DepartmentService dService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dService = DepartmentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dService = null;
	}
	
/*	@Test
	public void insertTest(){
		Department item = new Department();
		item.setDcode(0);
		item.setDname("총무");
		item.setFloor(10);
	
		int result = dService.insertDepartment(item);
		Assert.assertEquals(1, result);
		
		System.out.println(dService.getDepartment(item.getDcode()));
		
	}*/
	
/*	@Test
	public void updateTest(){
		Department item = dService.getDepartment(0);
		item.setDname("인사");
		item.setFloor(5);
		int result = dService.updateDepartment(item);
		Assert.assertEquals(1, result);
		
		System.out.println(dService.getDepartment(item.getDcode()));
		
	}*/
/*	@Test
	public void deleteTest(){
		Department item = dService.getDepartment(0);
		
		int result = dService.deleteDepartment(item.getDcode());
		Assert.assertEquals(1, result);
		
		System.out.println(dService.getDepartment(item.getDcode()));
		
	}*/
/*	
	@Test
	public void selectListTest(){
		List<Department> dList = dService.getAllDepartments();
		Assert.assertNotNull(dList);
	}*/
	
	@Test
	public void selectNoTest(){
		int result = dService.getMaxNo();
		System.out.println(result);
	}

}
