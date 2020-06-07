package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;
import com.mysql.jdbc.Statement;

public class AdminDAOImplement implements AdminDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;


	@Override
	public boolean addBook(BookBean book) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.addBookQuery) ){
			pstmt.setInt(1, book.getBId());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getCategory());
			pstmt.setString(5, book.getPublisher());
			int count = pstmt.executeUpdate();
			if(count!=0) {
				return true;
			} else {
				return false;
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean removeBook(int bId) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.removeBookQuery);) {
			pstmt.setInt(1,bId);
			int count=pstmt.executeUpdate();
			if(count!=0) {
				return true;
			} else {
				return false;
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateBook(BookBean book) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.updateBookQuery);) {
			pstmt.setString(1,book.getBookName());
			pstmt.setInt(2,book.getBId());
			int count=pstmt.executeUpdate();
			if(count!=0) {
				return true;
			} else {
				return false;
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean issueBook(int bId,int uId) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pst = conn.prepareStatement(QueryMapper.issueBookQuery1);){
			pst.setInt(1, bId);
			rs = pst.executeQuery();
			if(rs.next()) {
				try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.issueBookQuery2)) {
					pstmt.setInt(1, uId);
					pstmt.setInt(2, bId);
					pstmt.setInt(3, uId);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						try(PreparedStatement pstmt1 = conn.prepareStatement(QueryMapper.issueBookQuery3);){
							pstmt1.setInt(1, bId);
							pstmt1.setInt(2, uId);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
							Calendar cal = Calendar.getInstance();
							String issueDate = sdf.format(cal.getTime());
							pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
							cal.add(Calendar.DAY_OF_MONTH, 7);
							String returnDate = sdf.format(cal.getTime());
							pstmt1.setDate(4, java.sql.Date.valueOf(returnDate));
							int count=pstmt1.executeUpdate();
							if(count != 0) {	
								try(PreparedStatement pstmt2 = conn.prepareStatement(QueryMapper.issueBookQuery4)){
									pstmt2.setInt(1, uId);
									pstmt2.setInt(2, bId);
									pstmt2.setInt(3, uId);
									int isBorrowed = pstmt2.executeUpdate();
									if(isBorrowed != 0) {
										try(PreparedStatement pstmt3 = conn.prepareStatement(QueryMapper.returnBookQuery5);){
											pstmt3.setInt(1, bId);
											pstmt3.setInt(2, uId);
											int isRequestDeleted = pstmt3.executeUpdate();
											if(isRequestDeleted != 0) {
												return true;
											}else {
												return false;
											}
										}
									}else {
										return false;
									}
								}
							} else {
								throw new LMSException("Book Not issued");
							}					
						}
					} else {
						throw new LMSException("The respective user have not placed any request");
					}			
				}
			}else{
				throw new LMSException("There is no book exist with bookId"+bId);
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public List<BookIssueDetails> bookHistoryDetails(int uId) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.bookHistoryDetailsQuery);) {
			pstmt.setInt(1, uId);
			rs=pstmt.executeQuery();
			LinkedList<BookIssueDetails> beans = new LinkedList<BookIssueDetails>();
			while(rs.next()) {
				BookIssueDetails issueDetails = new BookIssueDetails();
				issueDetails.setuId(rs.getInt("uId"));
				beans.add(issueDetails);
			} 
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<RequestDetails> showRequests() {
		conn = JdbcUtility.getConnection();
		try(Statement stmt = (Statement)conn.createStatement();
				ResultSet rs = stmt.executeQuery(QueryMapper.showRequestsQuery);) {
			LinkedList<RequestDetails> beans = new LinkedList<RequestDetails>();
			while(rs.next()) {
				RequestDetails bean = new RequestDetails();
				bean.setuId(rs.getInt("uId"));
				bean.setFullName(rs.getString("fullName"));
				bean.setbId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				beans.add(bean);
			}
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		conn = JdbcUtility.getConnection();
		try(Statement stmt = (Statement)conn.createStatement();
				ResultSet rs = stmt.executeQuery(QueryMapper.showIssuedBooksQuery);) {
			LinkedList<BookIssueDetails> beans = new LinkedList<BookIssueDetails>();
			while(rs.next()) {
				BookIssueDetails bean = new BookIssueDetails();
				bean.setbId(rs.getInt("bId"));
				bean.setuId(rs.getInt("uId"));
				bean.setIssueDate(rs.getDate("issueDate"));
				bean.setReturnDate(rs.getDate("returnDate"));
				beans.add(bean);
			}
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<UsersBean> showUsers() {
		conn = JdbcUtility.getConnection();
		try(Statement stmt = (Statement)conn.createStatement();
				ResultSet rs = stmt.executeQuery(QueryMapper.showUsersQuery);) {
			LinkedList<UsersBean> beans = new LinkedList<UsersBean>();
			while(rs.next()) {
				UsersBean bean = new UsersBean();
				bean.setuId(rs.getInt("uId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setRole(rs.getString("role"));
				beans.add(bean);
			}
			return beans;
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
