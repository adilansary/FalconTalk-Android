package com.FalconTalk.PageActions;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.AutoDiscoverObj;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class AutoDiscoveryPage {
	AutoDiscoverObj autodiscover = new AutoDiscoverObj();
	public AutoDiscoveryPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	By bySkip = By.id("com.dassault.HONfalcontalk:id/skip");
	By byVVIP = By.id("com.dassault.HONfalcontalk:id/vvip_extension");
	By byVIP = By.id("com.dassault.HONfalcontalk:id/vip_extension");
	By Guest = By.id("com.dassault.HONfalcontalk:id/guest_extension");
	
	public ArrayList<String> RouterList() {
		System.out.println("Auto Discovery Page Start");
		ArrayList<String> routerlist = new ArrayList<String>();
		routerlist.add(autodiscover.Axxess.getText());
		routerlist.add(autodiscover.CgLegacy.getText());
		routerlist.add(autodiscover.CgFC.getText());
		routerlist.add(autodiscover.Cnx.getText());
		routerlist.add(autodiscover.Gdr.getText());
		routerlist.add(autodiscover.Sdr.getText());
		
		return routerlist;
	}


	public String SkipButton() {
		new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(bySkip));
		autodiscover.Skip.click();
		String ConfigPageText = autodiscover.AutoDiscoveryFailedNotice.getText();
		autodiscover.RetryAutoCOnfig.click();
		return ConfigPageText;
	}
	
	public void ClickSkipButton() {
		autodiscover.Skip.click();
	}
	
	
}
