package testPkg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void openBrowser(){
		report=new ExtentReports("./Report/report.html");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.cricbuzz.com/");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			TestUtils.takeScreenshot(result.getName().trim());
		}
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
