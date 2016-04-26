package testPkg;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pages.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
public class SuperTestNG {

	public static WebDriver driver;
	Logger logger=Logger.getLogger(SuperTestNG.class);
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void openBrowser(){
		PropertyConfigurator.configure("log4j.properties");
		report=new ExtentReports("./Report/Report.html");
		System.setProperty("webdriver.chrome.driver", "./tools/chromedriver.exe");
		driver=new FirefoxDriver();
		logger.info("Firefox Browser opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.cricbuzz.com/");
		logger.info("Page loaded");
			
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		report.endTest(test);
		report.flush();
		if(result.getStatus()==ITestResult.FAILURE){
			TestUtils.takeScreenshot(result.getName().trim());
		}
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
