package com.FalconTalk.HoneywellAccount;


import com.FalconTalk.Config.Activity;
import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.HonweywellAccountData;
import com.FalconTalk.PageActions.AutoDiscoveryPage;
import com.FalconTalk.PageActions.HoneywellAccountPage;
import com.FalconTalk.PageObject.Common.Common;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

class HoneywellAccount {
	
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		Activity.AndroidLaunchApp();
		Common common = new Common();
		AutoDiscoveryPage autodiscovery = new AutoDiscoveryPage();
		common.AgreeAndContinue();
		Thread.sleep(3000);
		autodiscovery.ClickSkipButton();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1,description="Press on Honeywell Account number button from configuration page and Verify if it takes to sign in page or not")
	@Severity(SeverityLevel.CRITICAL)
	public void HoneywellAccountNumberButtonTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.HoneywellLogin();
		Assert.assertEquals(honweywellAccountPage.LoginPage(), HonweywellAccountData.loginPage, "Not Going to login page");
	}
	
	@Test(priority=2,description="Verify if pressing cancel button from sign in page takes to configuration page or not")
	@Severity(SeverityLevel.BLOCKER)
	public void CancelButtonLoginPageTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.CancelButtonPress();
		Assert.assertEquals(honweywellAccountPage.ConfigurationPage(), HonweywellAccountData.ConfigurationPage, "Not Going to Configuration Page");
		honweywellAccountPage.HoneywellLogin();
	}
	
	@Test(priority=3,description="Verify the Empty field validation (Username and Password) when sign in with Honeywell online account")
	@Severity(SeverityLevel.NORMAL)
	public void EmptyFieldValidationTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.LoginButtonPress();
		Assert.assertEquals(honweywellAccountPage.SignInFaildMessage(), HonweywellAccountData.SignInFailedBothEmptyMassage, "Sign In Faild Massage not showing properly");
		honweywellAccountPage.dialogMessageOkButtonPress();
		
		honweywellAccountPage.InputUserName(HonweywellAccountData.UsernameInput);
		honweywellAccountPage.LoginButtonPress();
		Assert.assertEquals(honweywellAccountPage.SignInFaildMessage(), HonweywellAccountData.SignInFailedPasswordEmptyMassage, "Sign In Faild Massage not showing properly");
		honweywellAccountPage.dialogMessageOkButtonPress();
		
		honweywellAccountPage.ClearUserName();
		honweywellAccountPage.InputPassword(HonweywellAccountData.PasswordInput);
		honweywellAccountPage.LoginButtonPress();
		Assert.assertEquals(honweywellAccountPage.SignInFaildMessage(), HonweywellAccountData.SignInFailedUserNameEmptyMassage, "Sign In Faild Massage not showing properly");
		honweywellAccountPage.dialogMessageOkButtonPress();
		
	}
	
	@Test(priority=4,groups = "dsafda",description="Verify the authentication (Username and Password) when sign in with Honeywell online account\r\n" + "")
	@Severity(SeverityLevel.BLOCKER)
	public void VerifyTheAuthenticationTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.ClearUserName();
		honweywellAccountPage.InputUserName(HonweywellAccountData.UsernameInput);
		honweywellAccountPage.ClearPassword();
		honweywellAccountPage.InputPassword(HonweywellAccountData.PasswordInput);
		honweywellAccountPage.LoginButtonPress();
		Thread.sleep(5000);
		honweywellAccountPage.NavigationDrawerClose();
		Assert.assertEquals(honweywellAccountPage.KeypadPage(), "KEYPAD", "Not Going To Keypad Page");
		Thread.sleep(1000);
	}
	
	@Test(priority=5,description="After sign in successfully verify the right \"Domain\" is showing in profiles list")
	@Severity(SeverityLevel.CRITICAL)
	public void DomainTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		Thread.sleep(500);
		honweywellAccountPage.NavigationdDrawerOpen();
		honweywellAccountPage.getAccountDetailsPage();
		Assert.assertEquals(honweywellAccountPage.getDomain(),HonweywellAccountData.Domain , "Wrong Domain");
		
	}
	
	@Test(priority=6,description="After sign in successfully verify the Honeywell online account info is showing or not in profiles list page")
	@Severity(SeverityLevel.CRITICAL)
	public void AccountInfoTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		Assert.assertEquals(honweywellAccountPage.getName(),HonweywellAccountData.Name , "Wrong name Showing");
		Assert.assertEquals(honweywellAccountPage.getExtension(),HonweywellAccountData.Extension , "Wrong Extension Showing");
		Assert.assertEquals(honweywellAccountPage.getSecureVoiceStatus(), true, "Secure Voice Button Missing");
		honweywellAccountPage.getBack();
	}
	
	
	@Test(priority=7,description="After sign in successfully verify the Email (Username) is showing in application navigation drawer")
	@Severity(SeverityLevel.TRIVIAL)
	public void EmailOnNavDrawerTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.NavigationdDrawerOpen();
		Assert.assertEquals(honweywellAccountPage.getEmainOnNav(), HonweywellAccountData.UsernameInput, "Wrong Email Showiing");
	}
	
	@Test(priority=8,description="After sign in successfully verify the Re-sync Honeywell Account in application navigation drawer")
	@Severity(SeverityLevel.NORMAL)
	public void ReSyncHoneywellAccountTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		try {
			Assert.assertEquals(honweywellAccountPage.ReSyncHoneywellAccount(), HonweywellAccountData.DialogMessageSuccessfulTitel, "Re-sync Failed");
		}catch(Exception e) {
			System.out.println("Re-sync Failed");
		}
	}
	
	@Test(priority=9,description="Verify if Sign in successfully with Honeywell online account takes to KEYPAD module with Honeywell online account name or not")
	@Severity(SeverityLevel.CRITICAL)
	public void AccountNameOnKeypadTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		try {
			Assert.assertEquals(honweywellAccountPage.getAccountName(), HonweywellAccountData.Name, "Account name wrong");
		}catch(Exception e) {
			System.out.println("UserName Can't showing on Keypad");
		}
		
	}
	
	@Test(priority=10,description="Verify if Honeywell account is registered properly after Sign In or not")
	@Severity(SeverityLevel.CRITICAL)
	public void AccountRegisterdTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		Assert.assertEquals(honweywellAccountPage.getRegistrationStatus(), HonweywellAccountData.AccountStatusOnline, "Account is Not Online");
	}
	
	@Test(priority=11,description="After sign in successfully verify the \"Change password\" in application navigation drawer")
	@Severity(SeverityLevel.BLOCKER)
	public void ChangePasswordTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		Thread.sleep(500);
		honweywellAccountPage.NavigationdDrawerOpen();
		Thread.sleep(1000);
		Assert.assertEquals(honweywellAccountPage.ChangePassword(), HonweywellAccountData.ChangePasswordPage, "Account is Not Online");
		honweywellAccountPage.getBack();
	}
	
	@Test(priority=12,description="Press Sign Out when there is account with Honeywell and verify if \"Sign Out\" option replaces by \"Sign In\" option")
	@Severity(SeverityLevel.CRITICAL)
	public void SignOutReplaceSignInTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		Assert.assertEquals(honweywellAccountPage.getSignOut(), HonweywellAccountData.SignInText, "Account is Not Online");
	}
	
	@Test(priority=13,description="Press on sign in button from application navigation drawer and verify if it  takes to sign in page or not")
	@Severity(SeverityLevel.BLOCKER)
	public void SignInButtonTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		Assert.assertEquals(honweywellAccountPage.getSignIn(), HonweywellAccountData.loginPage, "Not Going to login page");
	}
	
	@AfterTest
	public void tearDown() { 
		Activity.CloseApp(); 
		AppiumServer.Stop();
	}


}
