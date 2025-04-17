package com.FalconTalk.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.ProfileDetailsObj;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

public class ProfileDetailsPage {
	ProfileDetailsObj profileDetailsObj = new ProfileDetailsObj();
	public ProfileDetailsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	By bymanufacturerLogo = By.id("com.dassault.HONfalcontalk:id/manufacturer_logo");
	By byprofileStatusData = By.id("com.dassault.HONfalcontalk:id/status_data");
	By byringGroupApplyButton = By.id("com.dassault.HONfalcontalk:id/apply_button");
	By byprofileExtension = By.id("com.dassault.HONfalcontalk:id/text_profile_extension");
	By byNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='The navigation drawer is opened']");
	
	public void setup() {
		System.out.println("Profile Details Module Test Start");
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		profileDetailsObj.NavigationDrawer.click();
		profileDetailsObj.accountsettings.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bymanufacturerLogo));
		profileDetailsObj.manufacturerLogo.click();
		
	}
	//Profile Name field
	public boolean ProfileNamefield() {
		System.out.println("Profile Details Page Start");
		return profileDetailsObj.profileName.isEnabled();
	}
	// Domain field test
	public boolean Domainfield() {
		return profileDetailsObj.profileDomain.isEnabled();
	}
	//Extension field test
	public boolean Extensionfield() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byprofileExtension));
		profileDetailsObj.profileExtension.click();
		return profileDetailsObj.ringgrouppage.isDisplayed();
	}
	//Apply button on profile details page
	public String ApplyButton() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byringGroupApplyButton));
		profileDetailsObj.ringGroupApplyButton.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bymanufacturerLogo));
		profileDetailsObj.manufacturerLogo.click();
		profileDetailsObj.profileApplyButton.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byprofileStatusData));
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Profile Details Module Test End");
		return profileDetailsObj.profileStatusData.getText();
	}

}
