package com.FalconTalk.CabinModeConfiguration;

import com.FalconTalk.Config.Activitybackground;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.KeypadPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

class VerifyCabinDevice {
	public static final String PROFILE_NAME_AXXESS= "Axxess";
	@BeforeTest
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		//ActiavityMain.AndroidLaunchApp();
		//Activity.AndroidLaunchApp();
		Activitybackground.AndroidLaunchApp();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1,description="Verify if successful Auto discovered cabin Account is showing in KEYPAD module header")
	@Severity(SeverityLevel.CRITICAL)
	public void CabinAccountNameInKeypadTest() {
		KeypadPage keypadpage = new KeypadPage();
		String str = keypadpage.ProfileName();
		System.out.println(str);
		Assert.assertEquals(str, PROFILE_NAME_AXXESS, "Wrong profile name show");
	}
	
	@Test(priority = 2)
	public void CabinAccountStatusShowingOnKeypadTest() {
		KeypadPage keypadpage = new KeypadPage();
		System.out.println(keypadpage.AccountStatus());
	}
	
	@AfterTest
	public void tearDown() { 
		//Actiavity.CloseApp();
		//Activity.CloseApp(); 
		Activitybackground.CloseApp();
		AppiumServer.Stop();
	}

}
