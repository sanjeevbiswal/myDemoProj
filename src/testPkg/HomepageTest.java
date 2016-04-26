package testPkg;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.pages.Homepage;
import com.pages.LiveScorespage;
import com.relevantcodes.extentreports.LogStatus;

public class HomepageTest extends SuperTestNG {

	public HomepageTest(){
		Homepage homepage=PageFactory.initElements(driver, Homepage.class);
		
	}
	
	@Test
	public void verifyTitle(){
		driver.get("http://www.cricbuzz.com");
	test=report.startTest("verifyTitle");
	logger.info(driver.getTitle());
	Assert.assertTrue(driver.getTitle().contains("IPL 2016"));
	test.log(LogStatus.PASS, "Title is as expected");
	}
	
	@Test
	public void clickLiveScoreLink(){
		test=report.startTest("clickLiveScoreLink");
		driver.get("http://www.cricbuzz.com/");
		logger.info("Homepage loaded");
		Homepage homepage=new Homepage(driver);
		homepage.mainNav_LiveScoreLink.click();
		logger.info("Clicked LiveScore link in the main nav");
		LiveScorespage liveScorespage=new LiveScorespage(driver);
		Assert.assertTrue(liveScorespage.liveCricketScoreInfo.isDisplayed());
		logger.info("clickLiveScoreLink testcase passed");
	}
}
