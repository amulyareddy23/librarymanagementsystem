package com.capgemini.librarymanagementsystemhibernate.dao;

public interface QueryMapper {

	String loginQuery = "select u from UsersBean u where u.email=:email and u.password=:password";
	
	String searchBookById = "select b from BookBean b where b.bId=:bId";
	String searchBookByTitle = "select b from BookBean b where b.bookName=:bookName";
	String searchBookByAuthor = "select b from BookBean b where b.author=:author";
	
	String getBooksInfo =  "select b from BookBean b";
	
	String updatePasswordQuery = "select u from UsersBean u where u.uId=:uId and u.role=:role and u.password=:password";
	
	String issueBookQuery1 = "select b from BookBean b where b.bId=:bId";
	String issueBookQuery2 = "select r from RequestDetailsBean r where r.uId=:uId and r.bId=:bId";
	String issueBookQuery3 = "select b.bookName from BookBean b where b.bId=:bId";
	String issueBookQuery4 = "select r from RequestDetailsBean r where r.bId=:bId and r.uId=:uId";
	
	String bookHistoryDetails = "select b from BookIssueBean b";
	
	String showRequestsQuery = "select r from RequestDetailsBean r";
	
	String showIssuedBooksQuery = "select b from BookIssueBean b";
	
	String showUsersQuery = "select u from UsersBean u";
	
	String borrowedBooksQuery = "select b from BorrowedBooksBean b where b.uId=:uId";
	
	String requestBookQuery1 = "select b from BookBean b where b.bId=:bId";
	String requestBookQuery2 = "select b from BorrowedBooksBean b where b.uId=:uId and b.bId=:bId";
	String requestBookQuery3 = "select b from BookIssueBean b where b.uId=:uId";
	String requestBookQuery4 = "select b.bookName from BookBean b where b.bId=:bookId";
	String requestBookQuery5 = "select u.email from UsersBean u where u.uId=:user_Id";
	
	String returnBookQuery1 = "select b from BookBean b where b.bId=:bId";
	String returnBookQuery2 = "select b from BookIssueBean b where b.bId=:bId and b.uId=:uId ";
	String returnBookQuery3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
}
