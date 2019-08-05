package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RetailLogin;
import com.training.pom.RetailRegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RetailRegisterTest {
	
	private WebDriver driver; 
	private String baseUrl; 
	private RetailRegisterPOM retailRegisterPOM; 
	private static Properties properties; 
	private ScreenShot screenShot; 


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailRegisterPOM = new RetailRegisterPOM(driver); 
		//retailLogin = new RetailLogin(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

	@Test()
	public void registerTest() throws InterruptedException {
		
		retailRegisterPOM.register();
		retailRegisterPOM.sendFirstName("manzoor");
		retailRegisterPOM.sendLastName("mehadi");
		retailRegisterPOM.sendEmail("manzoor@gmail.com");
		retailRegisterPOM.enterTelpnNo("9876543210");
		retailRegisterPOM.sendAdd1("yeshwanthapur");
		retailRegisterPOM.sendAdd2("bangalore");
		retailRegisterPOM.enterCity("bangalore");
		retailRegisterPOM.enterPostCode("560022");
		retailRegisterPOM.selectCountry();
		retailRegisterPOM.selectRegion();
		retailRegisterPOM.enterPwd("manzoor1");
		retailRegisterPOM.confirmPwd("manzoor1");
		retailRegisterPOM.subscribeRadioBtn();
		retailRegisterPOM.privacyCheckBx(); 
		retailRegisterPOM.continueBtn();
		retailRegisterPOM.checkSuccessMsg();
		screenShot.captureScreenShot("First");
	}


}
