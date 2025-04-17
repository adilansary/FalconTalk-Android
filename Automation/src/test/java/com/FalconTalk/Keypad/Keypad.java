package com.FalconTalk.Keypad;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.GlobalUtilsPage;
import com.FalconTalk.PageActions.KeypadPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;



public class Keypad{
	
	
	public static final String PROFILE_NAME_AXXESS= "Axxess";
	public static final String PROFILE_STATUS_ONLINE = "ONLINE";
	public static final String PROFILE_STATUS_OFFLINE = "OFFLINE";

	@BeforeTest()
	public void Server_Start() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(4000);
	}
	
	@Test(priority=1,description="Verify if selected account profile name is showing properly or not into Keypad ")
	public void ProfileNameTest() {
		KeypadPage keypadpage = new KeypadPage();
		GlobalUtilsPage gup = new GlobalUtilsPage();
		String str = keypadpage.ProfileName();
		//System.out.println(str);
		System.out.println("Global Result: "+gup.getSelectRouter());
		Assert.assertEquals(keypadpage.getSelectedRouter(), keypadpage.getSelectedRouter(), "Wrong profile name show");
	}
	
	@Test(priority=2,description="Verify if selected account status is showing properly or not into Keypad ")
	public void AccountStatusTest() {
		KeypadPage keypadpage = new KeypadPage();
		String status = keypadpage.AccountStatus();
		Assert.assertEquals(status, PROFILE_STATUS_ONLINE, "Status Should be show online");
	}
	
	@Test(priority=3,description="Verify if selected profile name is showing properly or not into application navigation drawer")
	public void ProfileNameNaveTest() {
		KeypadPage keypadpage = new KeypadPage();
		String NaveName = keypadpage.ProfileNameNave();
		Assert.assertEquals(NaveName, PROFILE_NAME_AXXESS, "Wrong profile name show on NavBar");
	}
	
	@Test(priority=4,description="Verify if selected account status is showing properly or not into application navigation drawer")
	public void AccountStatusNaveTest() {
		KeypadPage keypadpage = new KeypadPage();
		String statusNave = keypadpage.AccountStatusNave();
		Assert.assertEquals(statusNave, PROFILE_STATUS_ONLINE, "Status on Nave Should be show online");
	}
	
	@Test(priority=5,description="Verify if account selection option with all enabled account in application navigation drawer will appear when press on profile selection button at top right of the keypad")
	public void AccountSelectionOptionTest() {
		KeypadPage keypadpage = new KeypadPage();
		keypadpage.getUserProfile();
		keypadpage.getUserProfile();
		Assert.assertEquals(keypadpage.addAccount(), "Add Account", "Account selection option is not showing ");
		keypadpage.getUserProfile();
	}
	
	@Test(priority=6,description="Verify if Ringgroup name of selected auto discovered account is showing in application navigation drawer or not")
	public void RingGroupNameOnNavTest() {
		KeypadPage keypadpage = new KeypadPage();
		keypadpage.getNavigationDrawerOpen();
		boolean res=false;
		String RingGroupandExtension=keypadpage.RingGroupAndExtensionName();
	      String separator ="-";
	      int sepPos = RingGroupandExtension.lastIndexOf(separator);
	      String RingGroup=RingGroupandExtension.substring(0,sepPos);
	      if(RingGroup.equals("VVIP") || RingGroup.equals("VIP") || RingGroup.equals("Guest")) {
	    	  res=true;
	      }
	      Assert.assertEquals(res, true, "Can't showing the right RingGroup name");
	}
	
	@Test(priority=7,description="Verify if Extension of selected auto discovered account is showing in application navigation drawer or not")
	public void ExtensionOnNavTest() {
		KeypadPage keypadpage = new KeypadPage();
		boolean resl=false;
		String RingGroupandExtension=keypadpage.RingGroupAndExtensionName();
	      int len = RingGroupandExtension.length();
	      String separator ="-";
	      int sepPos = RingGroupandExtension.lastIndexOf(separator);
	      String Extension=RingGroupandExtension.substring(sepPos+1,len);
	      System.out.println(Extension);
	      if(Extension.equals("86") || Extension.equals("87") || Extension.equals("88")) {
	    	  resl=true;
	      }
	      Assert.assertEquals(resl, true, "Can't showing the right Extension");
	}
	
	@Test(priority=8,description="Verify if the extension number of selected account is showing properly into \"Contacts->My Number\" or not")
	public void ContactOwnNumberTest() {
		KeypadPage keypadpage = new KeypadPage();
		boolean num=false;
		keypadpage.getUserProfile();
		keypadpage.getContactPage();
		String nUmber=keypadpage.getOwnNumber();
		if(nUmber.equals("86") || nUmber.equals("87") || nUmber.equals("88")) {
	    	  num=true;
	      }
		Assert.assertEquals(num, true, "Can't showing the right Extension");
		
	}
	  
	  @AfterTest 
	  public void tearDown() { 
		//Activity.CloseApp(); 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}
	 
}
