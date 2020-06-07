package com.capgemini.lmscucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.capgemini.lmscucumber.testrunner.RegistrationTestRunner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps extends RegistrationTestRunner {

	@Before
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

	@Given("^User is on registration page$")
	public void user_is_on_registration_page() throws Throwable {
		driver.get("http://localhost:4200/home");
		Thread.sleep(3000);
	}

	@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+), \"([^\"]*)\"$")
	public void user_enters(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)
			throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		driver.findElement(By.id("firstName")).sendKeys(arg1);
		driver.findElement(By.id("lastName")).sendKeys(arg2);
		driver.findElement(By.id("email")).sendKeys(arg3);
		driver.findElement(By.id("password")).sendKeys(arg4);
		driver.findElement(By.id("mobile")).sendKeys(String.valueOf(arg5));
		WebElement element = driver.findElement(By.id("role"));
		Select s = new Select(element);
		s.selectByVisibleText(arg6);
	}

	@Then("^User should be registered$")
	public void user_should_be_registered() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-dark btn-block']")).click();
		String actual = driver.getCurrentUrl();
		String excepted = "http://localhost:4200/login";
		System.out.println(actual);
		if (actual.equals(excepted)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
	}
}
