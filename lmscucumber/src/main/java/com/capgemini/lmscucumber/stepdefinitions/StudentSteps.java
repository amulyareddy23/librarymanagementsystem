package com.capgemini.lmscucumber.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.lmscucumber.testrunner.StudentTestRunner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StudentSteps extends StudentTestRunner{

	@Before
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/login");
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
	@Given("^Student is on login page$")
	public void student_is_on_login_page() throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getTitle();
		String excepted = "LmsAngular";
		System.out.println(actual);
		assertTrue("The webpage is not a login page", actual.equals(excepted));
	}

	@When("^Student gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void student_gives(String arg1, String arg2) throws Throwable {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.xpath("//fieldset[@class='clearfix']//div//span//input"));
		action.moveToElement(email).sendKeys(arg1).perform();
		email.sendKeys(arg1);
		password.sendKeys(arg2);
		login.click();
	}

	@Then("^Student is logged in$")
	public void student_is_logged_in() throws Throwable {
		String actual=driver.getTitle();
		String expected="LmsAngular";
		
		if(actual.equals(expected)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
	}

	@Given("^Student is on request page$")
	public void student_is_on_request_page() throws Throwable {
		Thread.sleep(5000); 
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/home";
		System.out.println(actual);
		assertTrue("Student is on home page", actual.equals(excepted)); 
	}

	@When("^BookId and UserId are given (\\d+), (\\d+)$")
	public void bookid_and_UserId_are_given(int arg1, int arg2) throws Throwable {
		driver.findElement(By.linkText("Request")).click();
		driver.findElement(By.xpath("//tr[8]//td[6]//button[1]")).click();
	}

	@Then("^Book is Requested successfully$")
	public void book_is_Requested_successfully() throws Throwable {
		boolean b = driver.getPageSource().contains("Request Placed");
		if (b) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
	}

	@Given("^Student is on return page$")
	public void student_is_on_return_page() throws Throwable {
		Thread.sleep(5000); 
		String actual = driver.getCurrentUrl(); 
		String excepted = "http://localhost:4200/home";
		System.out.println(actual);
		assertTrue("Student is on home page", actual.equals(excepted)); 
	}

	@When("^bookId and userId are given (\\d+), (\\d+)$")
	public void bookid_and_userId_are_given(int arg1, int arg2) throws Throwable {
		driver.findElement(By.linkText("Return")).click();
		driver.findElement(By.xpath("//tr[2]//td[5]//button[1]")).click();	
		}

	@Then("^Book is returned successfully$")
	public void book_is_returned_successfully() throws Throwable {
		boolean b = driver.getPageSource().contains("Book Returned");
		if (b) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
		driver.findElement(By.linkText("Logout")).click();
	}
}
