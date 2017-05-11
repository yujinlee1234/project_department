package com.dgit.department.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Employee;
import com.dgit.department.dto.Title;

public interface EmployeeMapper {
	
	public List<Employee> selectAllItem();
	
	public Employee selectItem(int eno);
	
	public int insertItem(Employee item);
	
	public int updateItem(Employee item);
	
	public int deleteItem(int eno);
	
	@Select("select max(eno) from employee")
	public int getMaxNum();
}
