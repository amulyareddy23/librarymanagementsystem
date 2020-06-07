package com.capgemini.librarymanagementsystemspringrest.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAO;
import com.capgemini.librarymanagementsystemspringrest.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystemspringrest.dto.UsersBean;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	private UsersDAO dao = new UsersDAOImplement() ;
	boolean check;
	UsersBean bean;
	
	@Given("^User is on registration page$")
	public void user_is_on_registration_page() throws Throwable {
		bean = new UsersBean();
	}

	@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+), \"([^\"]*)\"$")
	public void user_enters(String arg1, String arg2, String arg3, String arg4, int arg5, String arg6) throws Throwable {
		bean.setFirstName(arg1);
		bean.setLastName(arg2);
		bean.setEmail(arg3);
		bean.setPassword(arg4);
		bean.setMobile(arg5);
		bean.setRole(arg6);
		check = dao.register(bean);
	}

	@Then("^User should be registered$")
	public void user_should_be_registered() throws Throwable {
		Assertions.assertTrue(check);	
	}

}
