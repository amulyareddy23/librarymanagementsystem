package com.capgemini.librarymanagementsystem.database;

import java.util.ArrayList;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class LibraryDB {
	public static final ArrayList<Book> BOOKS = new ArrayList<Book>(); 
	public static final ArrayList<Admin> ADMIN = new ArrayList<Admin>();
	public static final ArrayList<User> USER = new ArrayList<User>();
	public static final ArrayList<RequestBean> REQUEST = new ArrayList<RequestBean>();

	public static void addToDB() {

		ADMIN.add(new Admin(111111,"Amulya","Ammu@123","ammu@gmail.com",685963147));

		BOOKS.add(new Book(101010,"java","james","gosling","coding"));
		BOOKS.add(new Book(101011,"chemistry","tom","tom cruise","world"));
		BOOKS.add(new Book(101012,"jdbc","misko","adam","Goels"));
		BOOKS.add(new Book(101013,"Processors","Jain","babbage","programing"));

	}


}


