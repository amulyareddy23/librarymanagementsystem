package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;
import com.mysql.jdbc.Statement;

public class UsersDAOImplement implements UsersDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	@Override
	public boolean register(UsersBean user) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.registerQuery)){
			pstmt.setInt(1,user.getuId());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());
			pstmt.setLong(6, user.getMobile());
			pstmt.setString(7, user.getRole());
			int count = pstmt.executeUpdate();
			if(user.getEmail().isEmpty() && count==0) {
				return false;
			} else {
				return true;
			}

		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public UsersBean login(String email, String password) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.loginQuery)) {
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				UsersBean bean = new UsersBean();
				bean.setuId(rs.getInt("uId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setRole(rs.getString("role"));
				return bean;
			} else {
				return null;
			}

		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.searchBookByTitle)) {
			pstmt.setString(1,bookName);
			rs=pstmt.executeQuery();
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		} 
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.searchBookByAuthor)) {
			pstmt.setString(1,author);
			rs=pstmt.executeQuery();
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				//bean.setCopies(rs.getInt("copies"));
				beans.add(bean);
			}
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> getBooksInfo() {
		conn = JdbcUtility.getConnection();
		try(Statement stmt = (Statement)conn.createStatement();) {
			rs = stmt.executeQuery(QueryMapper.getBooksInfoQuery);
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookById(int bId) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.searchBookByIdQuery);) {
			pstmt.setInt(1,bId);
			rs=pstmt.executeQuery();
			LinkedList<BookBean> beans = new LinkedList<BookBean>();
			while(rs.next()) {
				BookBean bean = new BookBean();
				bean.setBId(rs.getInt("bId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setAuthor(rs.getString("author"));
				bean.setCategory(rs.getString("category"));
				bean.setPublisher(rs.getString("publisher"));
				beans.add(bean);
			}
			return beans;

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}



	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		conn = JdbcUtility.getConnection();
		try(PreparedStatement pst = conn.prepareStatement(QueryMapper.updatePasswordQuery1)){
			pst.setString(1, email);
			pst.setString(2, role);
			rs=pst.executeQuery();
			if(rs.next()) {
				try(PreparedStatement pstmt = conn.prepareStatement(QueryMapper.updatePasswordQuery2);) {
					pstmt.setString(1, newPassword);
					pstmt.setString(2, email);
					pstmt.setString(3,password);
					int count=pstmt.executeUpdate();
					if(count!=0) {
						return true;
					} else {
						return false;
					}
				}
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
