package com.FalconTalk.PageActions;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.ProfileObj;
import com.FalconTalk.PageObject.RingGroupExtensionObj;
import com.FalconTalk.Utils.Utils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {
	ProfileObj addprofileobj = new ProfileObj();
	RingGroupExtensionObj ringGroupobj = new RingGroupExtensionObj();
	Utils utils = new Utils();
	
	By byNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='The navigation drawer is opened']");
	By byAccountSetting = By.id("com.dassault.HONfalcontalk:id/nav_drawer_account_settings");
	By byAddProfilebutton = By.id("com.dassault.HONfalcontalk:id/menu_add_profile");
	By bydropdownbox = By.id("com.dassault.HONfalcontalk:id/spinner_drop_down_box");
	By bygogo = By.xpath("//android.widget.TextView[@text='Gogo']");
	By byhoneywell = By.xpath("//android.widget.TextView[@text='Honeywell");
	By bysatacom = By.xpath("//android.widget.TextView[@text='Satcom Direct']");
	By bycustom = By.xpath("//android.widget.TextView[@text='Custom']");
	By byapplybutton = By.id("com.dassault.HONfalcontalk:id/button_profile_done");
	By bycabinselectionpage = By.id("com.dassault.HONfalcontalk:id/label_cabin_selection");
	By byaccountstatusdata = By.id("com.dassault.HONfalcontalk:id/status_data");
	
	public ProfilePage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	public void NavigationdDrawerOpen() {
		try {
			addprofileobj.NavigationDrawer.click();
		}catch(Exception e) {
			addprofileobj.UserProfile.click();
			addprofileobj.NavigationDrawer.click();
		}
		
	}
	//Setup for start test
	public void setup() {
		System.out.println("Profile Module Test Start");
		//new WebDriverWait(AppDriver.getDriver(),20).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		//NavigationdDrawerOpen();
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(byAccountSetting));
		addprofileobj.accountsettings.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byAddProfilebutton));
		addprofileobj.addprofilebutton.click();
	}
	
	//Select manufacturer 
	public void manufacturerselections(String manufacturername) {
		//System.out.println("Profile Page");
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bydropdownbox));
		addprofileobj.dropdownbox.click();
		if(manufacturername == "Gogo") {
			addprofileobj.gogo.click();
		}
		else if(manufacturername == "Honeywell") {
			addprofileobj.honeywell.click();
		}
		else if(manufacturername == "Satcom Direct") {
			addprofileobj.satcomDirect.click();
		}
		else if(manufacturername == "Custom") {
			addprofileobj.custom.click();
		}
		addprofileobj.applybuttonprofile.click();
	}
	
	//Select cabin router
	public void cabinrouterselections(String manufacturername,String routerName) {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bydropdownbox));
		addprofileobj.dropdownbox.click();
		if(manufacturername == "Gogo" && routerName=="Axxess") {
			addprofileobj.axxess.click();
		}
		else if(manufacturername == "Honeywell" && routerName=="CG-710 (Legacy)") {
			System.out.println("Legacy");
			addprofileobj.legacy.click();
		}
		else if(manufacturername == "Honeywell" && routerName=="CG-710 (FC)") {
			addprofileobj.fc.click();
		}
		else if(manufacturername == "Honeywell" && routerName=="CNX-900") {
			addprofileobj.cnx900.click();
		}
		else if(manufacturername == "Honeywell" && routerName=="GDR") {
			addprofileobj.gdr.click();
		}
		else if(manufacturername == "Satcom Direct" && routerName=="SDR") {
			addprofileobj.sdr.click();
		}
		addprofileobj.applybuttonprofile.click();
	}
	
	//TC#61
	public ArrayList<String> manufacturerselection() {
		ArrayList<String> manufacturersName = new ArrayList<String>();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bydropdownbox));
		addprofileobj.dropdownbox.click();
		for(int i =0;i<3;i++) {
			String manufactureName = addprofileobj.manufacturersName.get(i).getText();
			manufacturersName.add(manufactureName);
		}
		return manufacturersName;
		
	}
	
	//TC#62-------for gogo
	public String manufacturerSelectionandgogoApplyButton() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bygogo));
		addprofileobj.gogo.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byapplybutton));
		addprofileobj.applybuttonprofile.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bycabinselectionpage));
		String pagetext = addprofileobj.cabinselectionpage.getText();
		addprofileobj.Back.click();
		return pagetext;
	}
	
	//TC#62------for honeywell
	public String manufacturerSelectionandhoneywellApplyButton() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bydropdownbox));
		addprofileobj.dropdownbox.click();
		//new WebDriverWait(AppDriver.getDriver(),20).until(ExpectedConditions.presenceOfElementLocated(byhoneywell));
		addprofileobj.manufacturersName.get(1).click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byapplybutton));
		addprofileobj.applybuttonprofile.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bycabinselectionpage));
		String pagetext = addprofileobj.cabinselectionpage.getText();
		addprofileobj.Back.click();
		return pagetext;
	}
	
	//TC#62--------for satcom direct
	public String manufacturerSelectionsatcomDirectApplyButton() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bydropdownbox));
		addprofileobj.dropdownbox.click();
		addprofileobj.satcomDirect.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byapplybutton));
		addprofileobj.applybuttonprofile.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bycabinselectionpage));
		String pagetext = addprofileobj.cabinselectionpage.getText();
		addprofileobj.Back.click();
		return pagetext;
	}
	
	//TC#62-------for Custom
	public String manufacturerSelectioncustomApplyButton() {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bydropdownbox));
		addprofileobj.dropdownbox.click();
		addprofileobj.custom.click();
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byapplybutton));
		addprofileobj.applybuttonprofile.click();
		String pagetext = addprofileobj.customroutername.getText();
		return pagetext;
	}
	
	//Get Profile Name from profile page
	public String getProfileName() {
		return addprofileobj.profileName.getText();
	}
	//Get Manufacturer Logo
	public boolean getManufacturerLogo() {
		System.out.println(addprofileobj.manufacturerLogo);
		return addprofileobj.manufacturerLogo.isDisplayed();
	}
	//Get Cabin Router Name
	public String getCabinRouterName() {
		System.out.println(addprofileobj.customroutername.getText());
		return addprofileobj.customroutername.getText();
	}
	//Get Domain Name
	public String getDomainName() {
		System.out.println(addprofileobj.profileDomain.getText());
		return addprofileobj.profileDomain.getText();
	}
	//go back from any page
	public void getBack() {
		addprofileobj.Back.click();
	}
	//Cancel Button Ring Group Page
	public void getCancel() {
		ringGroupobj.CancelButton.click();
	}
	//Apply Button RingGroup Page
	public void getApply() {
		ringGroupobj.ApplyButton.click();
	}
	//go to extension selection page
	public void getExtensionPage() {
		addprofileobj.extensionSelect.click();
	}
	//Return Display name from Ring group page
	public String getDisplayName() {
		return addprofileobj.displayName.getText();
	}
	//Return ring group page text
	public String getRingGroupPage() {
		return addprofileobj.RingGroupPage.getText();
	}
	
	public String getAccountStatus(int accountIndex) {
		new WebDriverWait(AppDriver.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byaccountstatusdata));
		return addprofileobj.accountStatusData.get(accountIndex).getText();
	}
	
	public void getAccountClick(int accountIndex) { //Edit Aaccount
		addprofileobj.accountStatusData.get(accountIndex).click();
	}
	
	public void getAccountToggleSwitch(int AccountIndex) {
		addprofileobj.accountEnableSwitch.get(AccountIndex).click();
	}
	
	public String getAccountExtension(int accountIndex) {
		return addprofileobj.accountExtensionData.get(accountIndex).getText();
	}
	
	public boolean getPasswordField() {
		return addprofileobj.ringgrouppasswordfield.isEnabled();
	}
	
	//For Custom page verification
	public String getDisplayNameCustom() {
		return addprofileobj.displayNameonCustom.getText();
	}
	public void CustomProfileInput(String domain,String extension,String password) {
		addprofileobj.domainNameonCustom.sendKeys(domain);
		addprofileobj.extensiononCustom.sendKeys(extension);
		addprofileobj.passwordonCustom.sendKeys(password);
	}
	public void CustomProfileInputFieldClear() {
		addprofileobj.domainNameonCustom.clear();
		addprofileobj.extensiononCustom.clear();
		addprofileobj.passwordonCustom.clear();
	}
	
	public void applyonCustomProfile() {
		addprofileobj.applyonCustom.click();
	}
	
	public boolean RingGroupName(String ringGroupName) {
		if(ringGroupName == "VVIP") {
			System.out.println(ringGroupobj.VVIPExtension.getText());
			return ringGroupobj.VVIPExtension.isDisplayed();
		}
		else if(ringGroupName == "VIP") {
			return ringGroupobj.VIPExtension.isDisplayed();
		}else if(ringGroupName == "Guest") {
			System.out.println(ringGroupobj.GuestExtension.getText());
			return ringGroupobj.GuestExtension.isDisplayed();
		}else if(ringGroupName == "Pilot") {
			return ringGroupobj.PilotExtension.isDisplayed();
		}else if(ringGroupName == "Secretary") {
			return ringGroupobj.SecretaryExtension.isDisplayed();
		}else if(ringGroupName == "Cockpit") {
			return ringGroupobj.CockpitExtension.isDisplayed();
		}else if(ringGroupName == "Cabin") {
			return ringGroupobj.CabinExtension.isDisplayed();
		}else {
			return false;
		}
	}
	
	public void getSelectedRingGroup(String RingGroupName) {
		if(RingGroupName == "Pilot") {
			ringGroupobj.PilotExtension.click();
		}
		else if(RingGroupName == "Cockpit") {
			ringGroupobj.CockpitExtension.click();
		}
		else {
			System.out.println("Wrong Parameters");
		}
	}
	
	public void getRetryAutoConfig() {
		addprofileobj.retryAutoConfig.click();
	}
	public String getRouterNameFromAutoDiscoverPage(int accountIndex) {
		return addprofileobj.routerList.get(accountIndex).getText();
	}

}
