package com.capgemini.librarymanagementsystemspringrest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;
import com.capgemini.librarymanagementsystemspringrest.service.UsersService;

public class UserServiceTest {
	@Autowired
private UsersService service ;
	
	@Test
	public void testRegisterValid() {
		UsersBean bean = new UsersBean();
		bean.setFirstName("Sridhar");
		bean.setLastName("Bendhi");
		bean.setEmail("sridhar@gmail.com");
		bean.setPassword("Sridhar@123");
		bean.setRole("student");
		boolean check = service.register(bean);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRegisterInvalid() {
		UsersBean bean = new UsersBean();
		bean.setFirstName("Sridhar");
		bean.setLastName("Bendhi");
		bean.setEmail("sridhar@gmail.com");
		bean.setPassword("Sridhar@123");
		bean.setRole("student");
		boolean check = service.register(bean);
		Assertions.assertFalse(check);
	}

	@Test
	public void testLoginValid() {
		UsersBean info = service.login("ammu@gmail.com", "ammU@123");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testLoginInvalid() {
		UsersBean info = service.login("ammu@gmail.com", "ammU123");
		Assertions.assertNull(info);
	}
	
	@Test
	public void testSearchBookByIdValid() {
		List<BookBean> info = service.searchBookById(101);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
		
	}
	
	@Test
	public void testSearchBookByIdInvalid() {
		List<BookBean> info = service.searchBookById(109);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleValid() {
		List<BookBean> info = service.searchBookByTitle("MM");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleInvalid() {
		List<BookBean> info = service.searchBookByTitle("Maths");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorValid() {
		List<BookBean> info = service.searchBookByAuthor("sharma");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorInvalid() {
		List<BookBean> info = service.searchBookByAuthor("Jain");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());	
	}
	
	@Test
	public void testBooksInfoValid() {
		List<BookBean> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(5, info.size());
	}
	
	@Test
	public void testBooksInfoInvalid() {
		List<BookBean> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testUpdatePasswordValid() {
		boolean check = service.updatePassword(100102,"Admin@123");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testUpdatePasswordInvalid() {
		boolean check = service.updatePassword(100102,"Admin@123");
		Assertions.assertFalse(check);
	}
	


}
