package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	
	public Homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Schedule'][@class='cb-hm-mnu-itm']")
	public WebElement scheduleLink;
	
	@FindBy(xpath="//nav[@class='cb-nav cb-col cb-col-100']/a[text()='Live Scores']")
	public WebElement mainNav_LiveScoreLink;
	
}
