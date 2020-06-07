package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface AdminDAO {
	boolean registerAdmin(Admin admin);
	Admin loginAdmin(String email,String password);
	boolean addBook(Book book);
	boolean removeBook(int id);
	ArrayList<Book> searchBookByTitle(String bookName);
	ArrayList<Book> searchBookByAuthor(String author);
	ArrayList<Book> searchBookByCategory(String category);
	ArrayList<Book> getBooksInfo();

	ArrayList<User> showUsers();
	ArrayList<RequestBean> showRequests();
	boolean bookIssue(User user,Book book);
	boolean isBookReceived(User user,Book book);
}
