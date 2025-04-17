package com.FalconTalk.Basic;

import com.FalconTalk.Config.Activity;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.AboutPage;
import com.FalconTalk.PageObject.Common.Common;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class About{
	public static final String APP_NAME= "FalconTalk";
	public static final String EULA_HEADER = "License Agreement";
	public static final String PRIVACY_HAEDR = "Privacy Statement";
	public static final String ABOUT_FOOTER= "© Dassault Aviation SA.";
	
	@BeforeTest()
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		Activity.AndroidLaunchApp();
		Common common = new Common();
		common.AgreeAndContinue();
		Thread.sleep(2000);
		common.UserTypeAndExtension();
		Thread.sleep(2000);
	}
	@AfterTest
	public void tearDown() {
		Activity.CloseApp();
		AppiumServer.Stop();
	}
	
	@Test(priority = 1,description = "Press on About from Navigation drawer and verify if About page appears or not")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Open the app go and go to About Page and verify About page appears or not")
	public void AboutPageTest() throws MalformedURLException, InterruptedException, IOException {
		AboutPage aboutpages = new AboutPage();
		boolean actualresult = aboutpages.AboutPages();
		Assert.assertEquals(true, actualresult);
	}
	
	@Test(priority = 2,description = "Verify app name showing properly or not")
	@Severity(SeverityLevel.BLOCKER)
	public void AppNameTest() {
		AboutPage aboutpages = new AboutPage();
		String appname = aboutpages.AppName();
		Assert.assertEquals(appname, APP_NAME, "App name is not match");
	}
	
	@Test(priority = 3,description = "Verify End User License Agreement page appears or not")
	@Severity(SeverityLevel.BLOCKER)
	public void EULATest() {
		AboutPage aboutpages = new AboutPage();
		String eulaHeader = aboutpages.EULA();
		Assert.assertEquals(eulaHeader, EULA_HEADER, "End User License Agreement Page Test Failed");

	}
	
	@Test(priority = 4,description = "Verify Privacy Statement Page Page appears or not")
	@Severity(SeverityLevel.BLOCKER)
	public void PrivacyStatementTest() {
		AboutPage aboutpages = new AboutPage();
		String privacyPage = aboutpages.PrivacyStatement();
		Assert.assertEquals(privacyPage, PRIVACY_HAEDR, "Privacy Statement Page Test Failed");

	}
	

}
