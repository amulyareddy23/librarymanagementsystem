package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.database.LibraryDB;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class UserDAOImplement implements UserDAO{

	@Override
	public boolean registerUser(User user) {
		for(User u : LibraryDB.USER) {
			if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
				return false;
			}
		}
		LibraryDB.USER.add(user);
		return true;
	}

	@Override
	public User loginUser(String email, String password){
		for(User user : LibraryDB.USER) {
			if(user.getEmail().equalsIgnoreCase(email) ) {
				if(user.getPassword().equals(password)) {
					return user;
				}else {
					throw new LMSException("Password is invalid");
				}

			}else {
				throw new LMSException("Email doesn't Exist");
			}
		}
		throw new LMSException("Invalid credentials");
	}


	@Override
	public ArrayList<Book> searchBookByTitle(String bookName) {
		ArrayList<Book> searchList=new ArrayList<Book>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			Book retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookName=retrievedBook.getBookName();
			if(bookName.equalsIgnoreCase(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}

	}

	@Override
	public ArrayList<Book> searchBookByAuthor(String author) {
		ArrayList<Book> searchList=new ArrayList<Book>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			Book retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookAuthor=retrievedBook.getAuthor();
			if(author.equalsIgnoreCase(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}	
	}

	@Override
	public ArrayList<Book> searchBookByCategory(String category) {
		ArrayList<Book> searchList=new ArrayList<Book>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			Book retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedCategory=retrievedBook.getCategory();
			if(category.equalsIgnoreCase(retrievedCategory))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}	

	}

	@Override
	public ArrayList<Book> getBooksInfo() {
		return LibraryDB.BOOKS;
	}

	@Override
	public RequestBean bookRequest(User user, Book book) {
		boolean flag = false; 
		boolean	isRequestExists = false;
		RequestBean requestInfo = new RequestBean();
		User userInfo2 = new User();
		Book bookInfo2 = new Book();

		for (RequestBean requestInfo2 : LibraryDB.REQUEST) {
			if (book.getId() == requestInfo2.getBookInfo().getId()) {
				isRequestExists = true;

			}
		}

		if (!isRequestExists) {
			for (User userBean : LibraryDB.USER) {
				if (user.getId() == userBean.getId()) {
					for (Book book1 : LibraryDB.BOOKS) {
						if (book1.getId() == book1.getId()) {
							userInfo2 = userBean;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setUserInfo(userInfo2);;
				LibraryDB.REQUEST.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");

	}

	@Override
	public RequestBean bookReturn(User user, Book book) {
		for (RequestBean requestInfo : LibraryDB.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId() &&
					requestInfo.getUserInfo().getId() == user.getId() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  LMSException("Invalid return ");
	}

}

