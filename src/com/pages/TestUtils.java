package com.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testPkg.SuperTestNG;

public class TestUtils extends SuperTestNG{

	public static void takeScreenshot(String methodName) throws IOException{
		System.out.println(methodName);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./ScreenShots/"+methodName+".png"));
		System.out.println("Screenshot taken");
	}
	
}
