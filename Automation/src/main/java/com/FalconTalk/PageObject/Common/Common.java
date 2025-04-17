package com.FalconTalk.PageObject.Common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Common {
	public Common() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement NavigateBack;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement Allow;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	public WebElement Deny;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_message")
	public WebElement PermissionMessage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_agree_and_continue")
	public WebElement AgreeContinue;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/guest_extension")
	public WebElement UserType;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/extension")
	public WebElement Extension;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/display_name")
	public WebElement DisplayName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/apply_button")
	public WebElement ApplyButton;
	
	//Save Contant Samsung Galaxy S10+
	
	@AndroidFindBy(id = "com.samsung.android.app.contacts:id/nameEdit")
	public WebElement EnterContactName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone']")
	public WebElement PressPhone;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
	public WebElement EnterContactPhoneNumber;
	
	@AndroidFindBy(id = "com.samsung.android.app.contacts:id/smallLabel")
	public WebElement SaveContact;
	
	By byAgreeContinue = By.id("com.dassault.HONfalcontalk:id/button_agree_and_continue");
	By byUserType = By.id("com.dassault.HONfalcontalk:id/guest_extension");
	By byExtension = By.id("com.dassault.HONfalcontalk:id/extension");
	
	
	public void AgreeAndContinue() {
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byAgreeContinue));
		AgreeContinue.click();
	}
	
	public void UserTypeAndExtension() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(50)).until(ExpectedConditions.presenceOfElementLocated(byUserType));
		UserType.click();
		Extension.click();
		DisplayName.sendKeys("FalconTalkTest");
		ApplyButton.click();
	}
}
