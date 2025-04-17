package com.FalconTalk.PageActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.AboutObj;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AboutPage {
	AboutObj about = new AboutObj();
	public AboutPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	By byNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='The navigation drawer is opened']");
	By byNavAbout = By.id("com.dassault.HONfalcontalk:id/nav_drawer_about");
	By byEULA = By.xpath("//android.widget.TextView[@text='End User License Agreement']");
	By byPrivacyStatement = By.xpath("//android.widget.TextView[@text='Privacy Statement']");
	
	
	public boolean AboutPages() {
		System.out.println("About Page Start");
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		about.NavigationDrawer.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byNavAbout));
		about.NavAbout.click();
		boolean bol = about.About.isDisplayed();
		return bol;
	}
	
	public String AppName() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ApplicationName = about.AppName.getText();
		System.out.println(ApplicationName);
		//Assert.assertEquals(ApplicationName, APP_NAME);
		return ApplicationName;
	}
	
	public String EULA() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byEULA));
		about.EULA.click();
		String EULAHeader = about.LAPage.getText();
		System.out.println(EULAHeader);
		about.LAPageBack.click();
		return EULAHeader;
	}
	
	public String PrivacyStatement() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byPrivacyStatement));
		about.PrivacyStatement.click();
		String PSHeader = about.PSPage.getText();
		System.out.println(PSHeader);
		about.PSPageBack.click();
		return PSHeader;
	}
	
	public String Footer() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String FooterName = about.AboutFooter.getText();
		about.AboutBackButton.click();
		return FooterName;
	}
	public void Back() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		about.AboutBackButton.click();
	}

}
