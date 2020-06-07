package com.capgemini.librarymanagementsystemspringrest.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.capgemini.librarymanagementsystemspringrest.dao.AdminDAO;
import com.capgemini.librarymanagementsystemspringrest.dao.AdminDAOImplement;
import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAO;
import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystemspringrest.dto.BookBean;
import com.capgemini.librarymanagementsystemspringrest.dto.BookIssueBean;
import com.capgemini.librarymanagementsystemspringrest.dto.RequestDetailsBean;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminSteps {

	private UsersDAO dao = new UsersDAOImplement() ;
	private AdminDAO admin = new AdminDAOImplement();
	BookBean bookBean;
	private RequestDetailsBean requestBean;	
	private BookIssueBean issueBean;
	boolean check;
	UsersBean info;

	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {
		info = new UsersBean();
	}

	@When("^Admin gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_gives(String arg1, String arg2) throws Throwable {
		info = dao.login(arg1,arg2);
	}

	@Then("^Admin is logged in$")
	public void admin_is_logged_in() throws Throwable {
		Assertions.assertNotNull(info);
	}

	@Given("^Admin is adding book$")
	public void admin_is_adding_book() throws Throwable {
		bookBean = new BookBean();
	}

	@When("^Admin enters  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		bookBean.setBookName(arg1);
		bookBean.setAuthor(arg2);
		bookBean.setCategory(arg3);
		bookBean.setPublisher(arg4);
		check = admin.addBook(bookBean);
	}

	@Then("^Book should be added$")
	public void book_should_be_added() throws Throwable {
		Assertions.assertTrue(check);
	}

	@Given("^Admin is updating book$")
	public void admin_is_updating_book() throws Throwable {
		bookBean = new BookBean();
	}

	@When("^Admin enters updated values (\\d+), \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters_updated_values(int arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		bookBean.setBId(arg1);
		bookBean.setBookName(arg2);
		bookBean.setAuthor(arg3);
		bookBean.setCategory(arg4);
		bookBean.setPublisher(arg5);
		check = admin.updateBook(bookBean);
	}

	@Then("^Book will be updated$")
	public void book_will_be_updated() throws Throwable {
		Assertions.assertTrue(check);
	}

	@Given("^Admin is deleting book$")
	public void admin_is_deleting_book() throws Throwable {

	}

	@When("^BookId is given (\\d+)$")
	public void bookid_is_given(int arg1) throws Throwable {
		check = admin.removeBook(arg1);
	}

	@Then("^Book is deleted$")
	public void book_is_deleted() throws Throwable {
		Assertions.assertTrue(check);
	}

	@Given("^Admin is in issue page$")
	public void admin_is_in_issue_page() throws Throwable {
		requestBean = new RequestDetailsBean();
	}

	@When("^Bid and Uid are given (\\d+), (\\d+)$")
	public void bid_and_Uid_are_given(int arg1, int arg2) throws Throwable {
		check = admin.issueBook(arg1,arg2);
	}

	@Then("^Book is issued successfully$")
	public void book_is_issued_successfully() throws Throwable {
		Assertions.assertTrue(check);
	}

}
