package com.dgit.department.mappers;

import java.util.List;

import com.dgit.department.dto.Title;

public interface TitleMapper {
	public List<Title> selectAllTitle();
	public void insertTitle(Title title);
	public void updateTitle(Title title);
	public void deleteTitle(int tcode);
	public Title selectTitleWithTCode(int tcode);
}
