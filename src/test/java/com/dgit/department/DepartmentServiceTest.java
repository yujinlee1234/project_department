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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
/*	@Test
	public void insertTest(){
		Department item = new Department();
		item.setDcode(0);
		item.setDname("총무");
		item.setFloor(10);
		DepartmentService dService = DepartmentService.getInstance();
	
		int result = dService.insertDepartment(item);
		Assert.assertEquals(1, result);
		
		System.out.println(dService.getDepartment(item.getDcode()));
		
	}*/
	
/*	@Test
	public void updateTest(){
		DepartmentService dService = DepartmentService.getInstance();
		Department item = dService.getDepartment(0);
		item.setDname("인사");
		item.setFloor(5);
		int result = dService.updateDepartment(item);
		Assert.assertEquals(1, result);
		
		System.out.println(dService.getDepartment(item.getDcode()));
		
	}*/
/*	@Test
	public void deleteTest(){
		DepartmentService dService = DepartmentService.getInstance();
		Department item = dService.getDepartment(0);
		
		int result = dService.deleteDepartment(item.getDcode());
		Assert.assertEquals(1, result);
		
		System.out.println(dService.getDepartment(item.getDcode()));
		
	}*/
/*	
	@Test
	public void selectTest(){
		DepartmentService dService = DepartmentService.getInstance();
		List<Department> dList = dService.getAllDepartments();
		Assert.assertNotNull(dList);
	}*/
	
	@Test
	public void selectTest(){
		EmployeeService dService = EmployeeService.getInstance();
		int result = dService.getMaxNo();
		System.out.println(result);
	}

}
