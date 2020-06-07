package com.capgemini.lmscucumber.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.lmscucumber.testrunner.TestRunner;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminSteps extends TestRunner {


	@Before
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login");
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("^Admin is on Login page$")
	public void admin_is_on_Login_page() throws Throwable {

		Thread.sleep(5000);
		String actual = driver.getTitle();
		String excepted = "LmsAngular";
		System.out.println(actual);
		assertTrue("The webpage is not a login page", actual.equals(excepted));
	}

	@When("^Admin enters \"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters(String arg1, String arg2) throws Throwable {

		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.xpath("//fieldset[@class='clearfix']//div//span//input"));
		action.moveToElement(email).sendKeys(arg1).perform();

		email.sendKeys(arg1);
		password.sendKeys(arg2);
		login.click();

	}

	@Then("^Admin should be logged in$")
	public void admin_should_be_logged_in() throws Throwable {
		Thread.sleep(3000);
		String actual=driver.getTitle();
		String expected="LmsAngular";
		
		if(actual.equals(expected)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
	}

	@Given("^Admin is on updating book page$")
	public void admin_is_on_updating_book_page() throws Throwable {
		Thread.sleep(5000); 
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/home";
		System.out.println(actual);
		assertTrue("Admin is on home page", actual.equals(excepted));
	}

	@When("^Admin enters values \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters_values(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Books Info")).click();
		driver.findElement(By.xpath("//tr[8]//td[6]//button[1]")).click();

		driver.findElement(By.id("bookName")).clear();
		driver.findElement(By.id("bookName")).sendKeys(arg1);

		driver.findElement(By.id("author")).clear();
		driver.findElement(By.id("author")).sendKeys(arg2);

		driver.findElement(By.id("category")).clear();
		driver.findElement(By.id("category")).sendKeys(arg3);

		driver.findElement(By.id("publisher")).clear();
		driver.findElement(By.id("publisher")).sendKeys(arg4);
	}

	@Then("^Book updated successfully$")
	public void book_updated_successfully() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']")).click();
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/booksInfo";
		System.out.println(actual);
		if(actual.equals(excepted)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
	}

	
	@Given("^Admin is on adding book page$")
	public void admin_is_on_adding_book_page() throws Throwable {
		Thread.sleep(5000); 
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/home";
		System.out.println(actual);
		assertTrue("Admin is on home page", actual.equals(excepted)); 
	}

	@When("^Admin enters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Add Book")).click();
		driver.findElement(By.id("bookName")).sendKeys(arg1);
		driver.findElement(By.id("author")).sendKeys(arg2);
		driver.findElement(By.id("category")).sendKeys(arg3);
		driver.findElement(By.id("publisher")).sendKeys(arg4);
		driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']")).click();
	}

	@Then("^Book \"([^\"]*)\"$")
	public void book(String arg1) throws Throwable {
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/booksInfo";
		System.out.println(actual);
		if(actual.equals(excepted)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
	}

	@Given("^Admin is on removing book page$")
	public void admin_is_on_removing_book_page() throws Throwable {
		Thread.sleep(5000); 
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/home";
		System.out.println(actual);
		assertTrue("Admin is on home page", actual.equals(excepted)); 
	}

	@When("^Admin enters (\\d+)$")
	public void admin_enters(int arg1) throws Throwable {
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Books Info")).click();
		driver.findElement(By.xpath("//tr[12]//td[7]//button[1]")).click();
	}

	@Then("^Book  deleted successfully$")
	public void book_deleted_successfully() throws Throwable {
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/booksInfo";
		System.out.println(actual);
		if(actual.equals(excepted)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
	}

	@Given("^Admin is on issuing book page$")
	public void admin_is_on_issuing_book_page() throws Throwable {
		Thread.sleep(5000); 
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/home";
		System.out.println(actual);
		assertTrue("Admin is on home page", actual.equals(excepted)); 

	}

	@When("^Admin enters (\\d+),(\\d+)$")
	public void admin_enters(int arg1, int arg2) throws Throwable {
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Show Requests")).click();
		driver.findElement(By.xpath("//tr[2]//td[6]//button[1]")).click();
	}

	@Then("^Book issued successfully$")
	public void book_issued_successfully() throws Throwable {
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/showRequests";
		System.out.println(actual);
		if(actual.equals(excepted)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		driver.findElement(By.linkText("Logout")).click();
	}
}
