package com.capgemini.librarymanagementsystemspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;
import com.capgemini.librarymanagementsystemspringrest.exception.LMSException;

@Repository
public class UsersDAOImplement implements UsersDAO{

	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	@PersistenceUnit
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

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
			UsersBean bean = getUser(email);
			if(bean.getEmail()!= null && bean.getEmail().equals(email) && bean.getPassword().equals(password)) {
				return bean;
			}else {

				return null;
			}

		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	public UsersBean getUser(String email) {
		manager=factory.createEntityManager();
		String jpql="select u from UsersBean u where u.email=:email";
		TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
		query.setParameter("email", email);
		UsersBean bean = query.getSingleResult();
		return bean;
	}


	@Override
	public List<BookBean> searchBookById(int bId) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bookName", bookName);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		try{
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.author=:author";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("author", author);
			List<BookBean> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<BookBean> getBooksInfo() {
		manager = factory.createEntityManager();
		String jpql = "select b from BookBean b";
		TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
		List<BookBean> recordList = query.getResultList();
		return recordList;
	}


	@Override
	public boolean updatePassword(int id, String password) {
		try{
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UsersBean record = manager.find(UsersBean.class,id);
			if(record != null) {
				record.setPassword(password);
				transaction.commit();
				return true;			
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} 
	}
}
