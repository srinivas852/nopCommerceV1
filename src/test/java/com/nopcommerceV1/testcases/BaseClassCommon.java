package com.nopcommerceV1.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerceV1.utilities.ReadConfig;

public class BaseClassCommon {
	
	
	
	
	
	
	ReadConfig redconfig = new ReadConfig();
	
	public String basURL=redconfig.getApplicationUrl();
	public String Email=redconfig.getEmail();
	public String password=redconfig.getPassWord();
	public static WebDriver driver;
	
	public static Logger logger = LogManager.getLogger(BaseClassCommon.class);
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) 
	{
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", redconfig.getChromPath());
	    driver = new ChromeDriver();
	
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.ie.driver", redconfig.getedgePath());
		    driver = new ChromeDriver();
		   
		}
		//Global implicite wait 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

//	public void captureScreen(String driver, String tname) throws IOException
//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target = new File(System.getProperty("user.dir") + "/ScreenShort/" + tname + ".png");
//		FileUtils.copyFile(source, target);
//		System.out.println("Screenshot taken");
//	}
	
}
