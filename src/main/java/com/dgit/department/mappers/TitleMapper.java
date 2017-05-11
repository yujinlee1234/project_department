package com.dgit.department.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dgit.department.dto.Title;

public interface TitleMapper {
	@Select("select * from title order by tcode")
	public List<Title> selectAllTitle();
	
	@Select("select * from title where tcode=#{tcode}")
	public Title selectTitle(int tcode);
	
	@Insert("insert into title values(#{tcode},#{tname})")
	public int insertTitle(Title title);
	
	@Update("update title set tname=#{tname} where tcode=#{tcode}")
	public int updateTitle(Title title);
	
	@Delete("delete from title where tcode=#{tcode}")
	public int deleteTitle(int tcode);
	
	@Select("select max(tcode) from title")
	public Object getMaxNum();
}
