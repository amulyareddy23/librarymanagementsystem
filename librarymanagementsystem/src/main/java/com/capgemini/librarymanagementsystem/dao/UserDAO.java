package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface UserDAO {
	boolean registerUser(User user);
	User loginUser(String email,String password);
	public RequestBean bookRequest(User user, Book book);
	public RequestBean bookReturn(User user, Book book);
	ArrayList<Book> searchBookByTitle(String bookName);
	ArrayList<Book> searchBookByAuthor(String author);
	ArrayList<Book> searchBookByCategory(String category);
	ArrayList<Book> getBooksInfo();
	
}
