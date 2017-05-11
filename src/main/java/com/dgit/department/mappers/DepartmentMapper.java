package com.dgit.department.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Title;

public interface DepartmentMapper {
	@Select("select * from department")
	public List<Department> selectAllItem();
	
	@Select("select * from department where dcode=#{dcode}")
	public Department selectItem(int dcode);
	
	@Insert("insert into department values(#{dcode},#{dname},#{floor})")
	public int insertItem(Department item);
	
	@Update("update department set dname=#{dname}, floor=#{floor} where dcode=#{dcode}")
	public int updateItem(Department item);
	
	@Delete("delete from department where dcode=#{dcode}")
	public int deleteItem(int dcode);
	
	@Select("select max(dcode) from department")
	public int getMaxNum();
}
