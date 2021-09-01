package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;


//@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/Features",
 glue= {"stepdefinitions"},
 plugin = {"pretty",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		 },
		 //tags ="@Web and not @QA",
		 tags ="@AUTO_TC_003",
 publish = true
 )
public class TestRunner extends AbstractTestNGCucumberTests {
	
}