package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.trianing.waits.WaitTypes;

public class RetailRegisterPOM {
	
	private WebDriver driver; 
	private WaitTypes types;

	public RetailRegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[@class='fa fa-user-o']")// need to modify
	public WebElement accountIcon; 
	
	@FindBy(xpath="//span[text()='LOGIN / REGISTER']")
	private WebElement loginRegisterBtn;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement registerBtn;

	@FindBy(id="input-firstname")
	private WebElement firstName ;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;

	@FindBy(id="input-email")
	private WebElement email;

	@FindBy(id="input-telephone")
	private WebElement telphoneNo;

	@FindBy(id="input-address-1")
	private WebElement ad1;

	@FindBy(id="input-address-2")
	private WebElement ad2;

	@FindBy(id="input-city")
	private WebElement city;

	@FindBy(id="input-postcode")
	private WebElement postCode;

	@FindBy(id="input-country")
	private WebElement countyDrop;

	@FindBy(id="input-zone")
	private WebElement region;

	@FindBy(id="input-password")
	private WebElement pwd;

	@FindBy(id="input-confirm")
	private WebElement confirmPwd;

	@FindBy(xpath="//input[@value=0]")
	private WebElement radioBtn;

	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privChechBtn;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueBtn;

	@FindBy(xpath="//p[contains(text(),'Congratulations')]")
	private WebElement success;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement Continue2Btn;
	
	public void mouseHoverAccountIcon() throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(accountIcon).build().perform();
		types = new WaitTypes(driver);
		types.waitForElement(this.loginRegisterBtn, 60).click();
	}
	
	public void register() {
		try {
			this.mouseHoverAccountIcon();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.registerBtn.click();
		
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	public void sendEmail(String userName) {
		this.email.clear();
		this.email.sendKeys(userName);
	}

	public void enterTelpnNo(String TelpnNo) {
		this.telphoneNo.clear();
		this.telphoneNo.click();
		this.telphoneNo.sendKeys(TelpnNo);
	}

	public void sendAdd1(String ad1) {
		this.ad1.clear();
		this.ad1.sendKeys(ad1);
	}

	public void sendAdd2(String ad2) {
		this.ad2.clear();
		this.ad2.sendKeys(ad2);
	}

	public void enterCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}

	public void enterPostCode(String postCode) {
		this.postCode.clear();
		this.postCode.sendKeys("postCode");
	}

	public void selectCountry() {
		Select country=new Select(countyDrop);
		country.selectByVisibleText("India");
	}

	public void selectRegion() {
		Select state=new Select(region);
		state.selectByVisibleText("Karnataka");
	}

	public void enterPwd(String passWord) {
		this.pwd.clear();
		this.pwd.sendKeys(passWord);	
	}
	public void inValidPwd() {
		this.pwd.sendKeys("manzoor");
	}

	public void confirmPwd(String confirmPwd) {
		this.confirmPwd.clear();
		this.confirmPwd.sendKeys(confirmPwd);
	}

	public void subscribeRadioBtn() {
		if(this.radioBtn.isSelected()){
			System.out.println("for subscribe 'No' Radio Btn is selected");
		}
		else
			this.radioBtn.click();
	}
	public void privacyCheckBx() {
		this.privChechBtn.click();
	}

	public void continueBtn() {
		this.continueBtn.click();	
	}
	public void checkSuccessMsg() {
		Assert.assertEquals(success, success);
		System.out.println("Congratulations! Your new account has been successfully created!");
	}


}
