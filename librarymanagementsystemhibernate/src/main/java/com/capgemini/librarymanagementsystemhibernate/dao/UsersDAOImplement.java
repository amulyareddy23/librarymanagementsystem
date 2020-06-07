package com.capgemini.librarymanagementsystemhibernate.dao;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;

public class UsersDAOImplement implements UsersDAO{
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean register(UsersBean user) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "select u from UsersBean u";
			TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
			List<UsersBean> list = query.getResultList();
			for(UsersBean isExists : list) {
				if(isExists.getEmail().equalsIgnoreCase(user.getEmail())) {
					throw new LMSException("User already Exists");
				}
			}
			manager.persist(user);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public UsersBean login(String email, String password) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql=QueryMapper.loginQuery;
			TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UsersBean bean = query.getSingleResult();
			return bean;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookBean> searchBookById(int bId) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = QueryMapper.searchBookById;
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = QueryMapper.searchBookByTitle;
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookName", bookName);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = QueryMapper.searchBookByAuthor;
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("author", author);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookBean> getBooksInfo() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = QueryMapper.getBooksInfo;
		TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
		List<BookBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	@Override
	public boolean updatePassword(int id, String password, String newPassword, String role) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = QueryMapper.updatePasswordQuery;
			TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
			query.setParameter("uId", id);
			query.setParameter("role", role);
			query.setParameter("password", password);
			UsersBean rs = query.getSingleResult();
			if(rs != null) {
				UsersBean record = manager.find(UsersBean.class,id);
				record.setPassword(newPassword);
				transaction.commit();
				return true;			
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

}
