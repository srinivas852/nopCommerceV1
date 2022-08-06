package com.nopcommerceV1.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerceV1.pageObject.LoginPage;
import com.nopcommerceV1.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClassCommon {

	@Test(dataProvider = "LoginData")
	public void loginTest(String Email, String password) throws InterruptedException {

		driver.get(basURL);
		driver.manage().window().maximize();
		logger.info("URL is opned");

		LoginPage lp = new LoginPage(driver);

		lp.setEmail(Email);
		logger.info("User is provided");
		Thread.sleep(2000);

		lp.setPassword(password);
		logger.info("Password is provided");

		lp.clickLogin();
		logger.info("Login in Clicked");

		if (driver.getTitle().equals("Your store. Login")) {
			Assert.assertTrue(true);

			lp.clickLogOut();
			logger.info("Loggin passed");
		} else {
			// captureScreen("driver","LoginTest");
			Assert.assertTrue(false);

			logger.error("Loggin Failed");
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		//String path = System.getProperty("user.dir") + "/src/test/java/com/nopcommerceV1/testData/LoginData.xlsx";
		
		String path = "C:\\Users\\user\\eclipse-workspace\\nopcommerceV1\\src\\test\\java\\com\\nopcommerceV1\\testData\\LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");

		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rownum][colnum];

		for (int i = 1; i < rownum; i++) {

			for (int j = 0; j < colnum; j++) {

				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
