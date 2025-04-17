package com.FalconTalk.PageActions;

import org.openqa.selenium.By;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.HoneywellAccountObj;


public class HoneywellAccountPage {
	
	HoneywellAccountObj honeywellaccountobj = new HoneywellAccountObj();
	
	public void NavigationdDrawerOpen() {
		try {
			honeywellaccountobj.NavigationDrawer.click();
		}catch(Exception e) {
			honeywellaccountobj.UserProfile.click();
			honeywellaccountobj.NavigationDrawer.click();
		}
		
	}
	
	public void NavigationDrawerClose() {
		try {
			honeywellaccountobj.NavigationDrawer.isEnabled();
		}catch(Exception e) {
			honeywellaccountobj.UserProfile.click();
		}
	}
	
	public void HoneywellLogin() {
		honeywellaccountobj.honeywellLoginButton.click();
	}
	public void CancelButtonPress() {
		honeywellaccountobj.cancelButton.click();
	}
	
	public void ClearUserName() {
		honeywellaccountobj.usernameInput.clear();
	}
	
	public void InputUserName(String username) {
		honeywellaccountobj.usernameInput.sendKeys(username);
	}
	
	public void ClearPassword() {
		honeywellaccountobj.passwordInput.clear();
	}
	
	public void InputPassword(String password) {
		honeywellaccountobj.passwordInput.sendKeys(password);
	}
	
	public void LoginButtonPress() {
		honeywellaccountobj.loginButton.click();
	}
	
	public String LoginPage() {
		return honeywellaccountobj.labelUserName.getText();
	}
	
	public String ConfigurationPage() {
		return honeywellaccountobj.ConfigurationPage.getText();
	}
	
	public String SignInFaildMessage() {
		return honeywellaccountobj.dialogMessage.getText();
	}
	
	public void dialogMessageOkButtonPress() {
		honeywellaccountobj.dialogMessageOkButton.click();
	}
	
	public boolean UserNameIsEmptyOrNot() {
		String str= "com.dassault.HONfalcontalk:id/input_username";
		AppDriver.getDriver().findElement(By.id(str));
		String text = honeywellaccountobj.usernameInput.getAttribute("contentSize");
		System.out.println(text);
		return text.isEmpty();
	}
	
	public String KeypadPage() {
		return honeywellaccountobj.Keypad.getText();
	}
	
	public void getAccountDetailsPage() {
		honeywellaccountobj.AccountSetting.click();
	}
	
	public String getDomain() {
		return honeywellaccountobj.Domain.getText();
	}
	public String getName() {
		return honeywellaccountobj.Name.getText();
	}
	public String getExtension() {
		return honeywellaccountobj.Extension.getText();
	}
	public boolean getSecureVoiceStatus() {
		return honeywellaccountobj.SecureButton.isEnabled();
	}
	public String getStatus() {
		return honeywellaccountobj.Status.getText();
	}
	public void getBack() {
		 honeywellaccountobj.Back.click();
	}
	
	public String getAccountName() {
		return honeywellaccountobj.SelectAccountName.getText();
	}
	
	public String getEmainOnNav() {
		return honeywellaccountobj.EmainNav.getText();
	}
	
	public String ReSyncHoneywellAccount() throws InterruptedException {
		honeywellaccountobj.ResyncHoneyWellAccount.click();
		Thread.sleep(5000);
		String titel = honeywellaccountobj.dialogTitel.getText();
		Thread.sleep(1000);
		honeywellaccountobj.dialogMessageOkButton.click();
		System.out.println(titel);
		return titel;
	}
	
	public String getRegistrationStatus() {
		return honeywellaccountobj.SelectAccountStatusOnline.getText();
	}
	
	public String ChangePassword() throws InterruptedException {
		Thread.sleep(1000);
		NavigationdDrawerOpen();
		honeywellaccountobj.ChangePassNav.click();
		return honeywellaccountobj.ChangePasswordPage.getText();
	}
	
	public String getSignOut() throws InterruptedException {
		NavigationdDrawerOpen();
		honeywellaccountobj.SignOut.click();
		Thread.sleep(100);
		honeywellaccountobj.dialogMessageOkButton.click();
		CancelButtonPress();
		NavigationdDrawerOpen();
		Thread.sleep(100);
		return honeywellaccountobj.signinText.getText();
	}
	
	public String getSignIn() throws InterruptedException {
		honeywellaccountobj.signin.click();
		Thread.sleep(100);
		return LoginPage();
	}

	public boolean AccountOnlineOrNot(){
		return honeywellaccountobj.SelectAccountStatusOnline.isDisplayed();
	}
	
}
