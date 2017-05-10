package com.dgit.department.mappers;

import java.util.List;

import com.dgit.department.dto.Department;

public interface DepartmentMapper {
	public List<Department> selectAllDepartment();
	public void insertDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(int dcode);
	public Department selectDepartmentWithDCode(int dcode);
}
