package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.database.LibraryDB;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.exception.LMSException;

public class AdminDAOImplement implements AdminDAO{

	@Override
	public boolean registerAdmin(Admin admin) {
		boolean isRegistered = true;
		for(Admin registeredEmail : LibraryDB.ADMIN) {
			if(registeredEmail.getEmail().equalsIgnoreCase(admin.getEmail())) {
				isRegistered = false;
			}
		}
		LibraryDB.ADMIN.add(admin);
		return isRegistered;
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		for(Admin admin : LibraryDB.ADMIN) {
			if(admin.getEmail().equalsIgnoreCase(email) ) {
				if(admin.getPassword().equals(password)) {
					return admin;
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
	public boolean addBook(Book book) {
		boolean isAdded = true;
		for(Book addBook : LibraryDB.BOOKS) {
			if(addBook.getId()==book.getId()) {
				isAdded = false;
			}
		}
		LibraryDB.BOOKS.add(book);
		return isAdded;
	}

	@Override
	public boolean removeBook(int id) {
		boolean removeStatus=false;
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			Book retrievedBook=LibraryDB.BOOKS.get(i);
			int retrievedId=retrievedBook.getId();
			if(id==retrievedId)
			{
				removeStatus=true;
				LibraryDB.BOOKS.remove(i);
				break;
			}
		}
		return removeStatus;
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
				//return searchList;
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
	public ArrayList<User> showUsers() {
		ArrayList<User> usersList = new ArrayList<User>();
		for (User userBean : LibraryDB.USER) {

			userBean.getId();
			userBean.getName();
			userBean.getEmail();
			userBean.getBooksBorrowed();
			usersList.add(userBean);

		}
		return usersList;
	}

	@Override
	public ArrayList<RequestBean> showRequests() {
		ArrayList<RequestBean> info = new ArrayList<RequestBean>();
		for (RequestBean requestInfo : LibraryDB.REQUEST) {
			requestInfo.getBookInfo();
			requestInfo.getUserInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			info.add(requestInfo);
		}
		return info;
	}

	@Override
	public boolean bookIssue(User user, Book book) {
		boolean isValid = false;

		RequestBean requestInfo = new RequestBean();

		int noOfBooksBorrowed = user.getBooksBorrowed();
		for (RequestBean info : LibraryDB.REQUEST) {
			if (info.getUserInfo().getId() == user.getId()) {
				if (info.getBookInfo().getId() == book.getId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)
		{
			for (Book info2 : LibraryDB.BOOKS) {
				if (info2.getId() == book.getId()) {
					book = info2;
				}
			}

			for (User userInfo : LibraryDB.USER) {
				if (userInfo.getId() == user.getId()) {
					user = userInfo;
					noOfBooksBorrowed = user.getBooksBorrowed();

				}
			}

			if (noOfBooksBorrowed < 3) {

				boolean isRemoved = LibraryDB.BOOKS.remove(book);
				if (isRemoved) {

					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					user.setBooksBorrowed(noOfBooksBorrowed);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new LMSException("Book can't be borrowed");
				}

			} else {
				throw new LMSException("Student Exceeds maximum limit");
			}

		} else {
			throw new LMSException("Book data or Student data is incorrect");
		}
	}

	@Override
	public boolean isBookReceived(User user, Book book) {
		boolean isValid = false;
		RequestBean requestInfo1 = new RequestBean();
		for (RequestBean requestInfo : LibraryDB.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId()
					&& requestInfo.getUserInfo().getId() == user.getId() 
					&& requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {

			book.setAuthor(requestInfo1.getBookInfo().getAuthor());
			book.setBookName(requestInfo1.getBookInfo().getBookName());
			LibraryDB.BOOKS.add(book);
			LibraryDB.REQUEST.remove(requestInfo1);


			for (User userInfo2 : LibraryDB.USER) {
				if (userInfo2.getId() == user.getId()) {
					user = userInfo2;
				}
			}
			int noOfBooksBorrowed = user.getBooksBorrowed();
			noOfBooksBorrowed--;
			user.setBooksBorrowed(noOfBooksBorrowed);
			return true;
		}
		return false;
	}
}


