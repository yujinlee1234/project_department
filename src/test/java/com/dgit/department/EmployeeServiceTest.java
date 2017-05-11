package com.dgit.department;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Employee;
import com.dgit.department.service.DepartmentService;
import com.dgit.department.service.EmployeeService;
import com.dgit.department.service.TitleService;

import junit.framework.Assert;

public class EmployeeServiceTest {
	private static EmployeeService eService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		eService = EmployeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		eService = null;
	}
	
	@Test
	public void insertTest(){
		
		TitleService tService = TitleService.getInstance();
		DepartmentService dService = DepartmentService.getInstance();
		
		int eno = eService.getMaxNo()+1;
		Employee employee = new Employee();
		employee.setEno(eno);
		employee.setEname("이유진");
		employee.setGender(false);
		employee.setSalary(3500000);
		employee.setJoindate(new Date(2017, 4, 11));
		employee.setTitle(tService.getTitle(2));
		employee.setDno(dService.getDepartment(2));
		
		
	
		int result = eService.insertEmployee(employee);
		Assert.assertEquals(1, result);		
		System.out.println(eService.getEmployee(employee.getEno()));
		
	}
	
	@Test
	public void updateTest(){
		Employee item = eService.getEmployee(eService.getMaxNo());
		item.setEname("삼유진");
		item.setGender(true);
		item.setSalary(5000000);
		int result = eService.updateEmployee(item);
		Assert.assertEquals(1, result);		
		System.out.println(eService.getEmployee(item.getEno()));
		
	}
	@Test
	public void deleteTest(){
		int eno = eService.getMaxNo();		
		int result = eService.deleteEmployee(eno);
		Assert.assertEquals(1, result);
		System.out.println(eService.getEmployee(eno));
		
	}
	
	@Test
	public void selectListTest(){
		List<Employee> eList = eService.getAllEmployees();
		Assert.assertNotNull(eList);		
		for(Employee e : eList){
			System.out.println(e);
		}
	}
	
	@Test
	public void selectTest(){
		Employee eList = eService.getEmployee(17005);
		Assert.assertNotNull(eList);		
		System.out.println(eList);
	}
	
	@Test
	public void selectNoTest(){
		int result = eService.getMaxNo();
		System.out.println(result);
	}

}
