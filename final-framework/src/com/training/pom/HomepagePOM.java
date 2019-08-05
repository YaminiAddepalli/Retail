package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trianing.waits.WaitTypes;

public class HomepagePOM {
		
		private WebDriver driver; 
		private WaitTypes types;

		public HomepagePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);	
		}


		@FindBy(xpath="//i[@class='fa fa-user-o']")
		public WebElement accountIcon; 
		
		@FindBy(xpath="//span[text()='LOGIN / REGISTER']")
		private WebElement loginRegisterBtn;
		
		public void mouseHoverAccountIcon(){
			Actions action= new Actions(driver);
			action.moveToElement(accountIcon).build().perform();
			types = new WaitTypes(driver);
			types.waitForElement(this.loginRegisterBtn, 60).click();
		}


	}

	
	
