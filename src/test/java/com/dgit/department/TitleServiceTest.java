package com.dgit.department;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dgit.department.dto.Title;
import com.dgit.department.service.TitleService;

import junit.framework.Assert;

public class TitleServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
/*	@Test
	public void insertTitleTest(){
		Title title = new Title();
		title.setTcode(0);
		title.setTname("사장");
		TitleService tService = TitleService.getInstance();
	
		int result = tService.insertTitle(title);
		Assert.assertEquals(1, result);
		
		System.out.println(tService.getTitle(0));
		
	}*/
	
/*	@Test
	public void updateTitleTest(){
		TitleService tService = TitleService.getInstance();
		Title title = tService.getTitle(0);
		title.setTname("대리");
		int result = tService.updateTitle(title);
		Assert.assertEquals(1, result);
		
		System.out.println(tService.getTitle(0));
		
	}*/
	@Test
	public void deleteTitleTest(){
		TitleService tService = TitleService.getInstance();
		Title title = tService.getTitle(0);
		
		int result = tService.deleteTitle(title.getTcode());
		Assert.assertEquals(1, result);
		
		System.out.println(tService.getTitle(0));
		
	}
	
	@Test
	public void TitleTest(){
		TitleService tService = TitleService.getInstance();
		Title t = tService.getTitle(0);
		Assert.assertNotNull(t);
		
		System.out.println(t);		
	}

}
