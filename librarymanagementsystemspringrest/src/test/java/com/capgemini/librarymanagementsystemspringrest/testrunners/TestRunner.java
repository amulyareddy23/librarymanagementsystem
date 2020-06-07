package com.capgemini.librarymanagementsystemspringrest.testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\parallel_project_workspace\\librarymanagementsystemspringrest\\src\\test\\java\\com\\capgemini\\librarymanagementsystemspringrest\\features", 
					glue = {"com\\capgemini\\librarymanagementsystemspringrest\\stepdefinitions" }, 
					dryRun = false,  
					plugin = { "pretty", "html:target/cucumber" }, 
					monochrome = true)
public class TestRunner {

}
