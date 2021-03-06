package com.capgemini.librarymanagementsystemhibernate.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;

public class AdminDAOImplement implements AdminDAO{

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	@Override
	public boolean addBook(BookBean book) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean removeBook(int bId) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class,bId);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean updateBook(BookBean book) {
		boolean isUpdated = false;
		manager = factory.createEntityManager();
		BookBean existing = manager.find(BookBean.class, book.getBId());
		if(existing != null) {
			try{
				transaction = manager.getTransaction();
				transaction.begin();

				String bookNewName = book.getBookName();
				if(bookNewName != null) {
					bookNewName = bookNewName.trim();
				}

				String bookNewAuthor = book.getAuthor();
				if(bookNewAuthor != null) {
					bookNewAuthor = bookNewAuthor.trim();
				}

				String bookNewCategory = book.getCategory();
				if(bookNewCategory != null) {
					bookNewCategory = bookNewCategory.trim();
				}

				String bookNewPublisher = book.getPublisher();
				if(bookNewPublisher != null) {
					bookNewPublisher = bookNewPublisher.trim();
				}

				if(bookNewName != null && !bookNewName.isEmpty() && bookNewName.length()>1) {
					existing.setBookName(bookNewName);
				}

				if(bookNewAuthor != null && !bookNewAuthor.isEmpty() && bookNewAuthor.length()>1) {
					existing.setAuthor(bookNewAuthor);
				}

				if(bookNewCategory != null && !bookNewCategory.isEmpty() && bookNewCategory.length()>1) {
					existing.setCategory(bookNewCategory);
				}

				if(bookNewPublisher != null && !bookNewPublisher.isEmpty() && bookNewPublisher.length()>1) {
					existing.setPublisher(bookNewPublisher);
				}
				transaction.commit();
				isUpdated = true;
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}
		return isUpdated;
	}


	@Override 
	public boolean issueBook(int bId, int uId) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = QueryMapper.issueBookQuery1;
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if(rs != null) {
				String jpql1 = QueryMapper.issueBookQuery2;
				TypedQuery<RequestDetailsBean> query1 = manager.createQuery(jpql1,RequestDetailsBean.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				List<RequestDetailsBean> rs1 = query1.getResultList();
				if(!rs1.isEmpty() && rs1 != null) {
					transaction.begin();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					BookIssueBean issueBook = new BookIssueBean();
					issueBook.setUId(uId);
					issueBook.setBId(bId);
					issueBook.setIssueDate(java.sql.Date.valueOf(issueDate));
					issueBook.setReturnDate(java.sql.Date.valueOf(returnDate));
					manager.persist(issueBook);
					transaction.commit();
					if(!rs1.isEmpty() && rs1 != null) {
						transaction.begin();
						Query bookName = manager.createQuery(QueryMapper.issueBookQuery3);
						bookName.setParameter("bId", bId);
						List book = bookName.getResultList();
						BorrowedBooksBean borrowedBooks = new BorrowedBooksBean();
						borrowedBooks.setUId(uId);
						borrowedBooks.setBId(bId);
						borrowedBooks.setBookName(book.get(0).toString());
						manager.persist(borrowedBooks);
						transaction.commit();
						
						transaction.begin();
						String jpql4 = QueryMapper.issueBookQuery4;
						Query query4 = manager.createQuery(jpql4);
						query4.setParameter("bId", bId);
						query4.setParameter("uId", uId);
						RequestDetailsBean rdb = (RequestDetailsBean) query4.getSingleResult();
						manager.remove(rdb);
						transaction.commit();
						return true;
					}else {
						throw new LMSException("Book Not issued");
					}
				}else {
					throw new LMSException("The respective user have not placed any request");
				}
			}else {
				throw new LMSException("There is no book exist with bookId"+bId);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}



	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		int count=0;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = QueryMapper.bookHistoryDetails;
		TypedQuery<BookIssueBean> query = manager.createQuery(jpql,BookIssueBean.class);
		List<BookIssueBean> recordList = query.getResultList();
		for(BookIssueBean p : recordList) {
			noOfBooks = count++;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(noOfBooks);
		manager.close();
		factory.close();
		return list;
	}


	@Override
	public List<RequestDetailsBean> showRequests() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = QueryMapper.showRequestsQuery;
		TypedQuery<RequestDetailsBean> query = manager.createQuery(jpql,RequestDetailsBean.class);
		List<RequestDetailsBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	@Override
	public List<BookIssueBean> showIssuedBooks() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = QueryMapper.showIssuedBooksQuery;
		TypedQuery<BookIssueBean> query = manager.createQuery(jpql,BookIssueBean.class);
		List<BookIssueBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

	@Override
	public List<UsersBean> showUsers() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = QueryMapper.showUsersQuery;
		TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
		List<UsersBean> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}

}
