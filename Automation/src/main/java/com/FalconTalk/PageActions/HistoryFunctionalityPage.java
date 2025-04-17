package com.FalconTalk.PageActions;
import com.FalconTalk.Utils.*;
import com.FalconTalk.PageObject.HistoryFunctionalityObj;

public class HistoryFunctionalityPage {
	ProfilePage AddAccount = new ProfilePage();
	KeypadPage Keypad = new KeypadPage();
	Utils util = new Utils();
	HistoryFunctionalityObj HistoryObj = new HistoryFunctionalityObj();
	public void HistoryFunction() {
		
		String AccountStatus = Keypad.AccountStatus();
		
		try {
			Thread.sleep(4000);
			System.out.println(AccountStatus);
			if(AccountStatus.equals("ONLINE")) {
				
			}else {
				AddAccount.NavigationdDrawerOpen();
				AddAccount.setup();
				AddAccount.manufacturerselections("Custom");
				AddAccount.CustomProfileInput("202.191.126.148", "219", "1234");
			}
		}catch(Exception e) {
		
		}
	}
	
	public void CallFromKeypad(String number) throws InterruptedException {
		Keypad.typeNumberOnKeypad(number);
		HistoryObj.CallBtn.click();
		Thread.sleep(10000);
		
	}
	public void EndCall() {
		try {
			HistoryObj.CallEndBtn.click();
		}catch(Exception e) {
			
		}
		
	}
	public void getHistoryTab() {
		HistoryObj.History.click();
	}
	public void getHistoryDetailsPage() {
		HistoryObj.ContactName.get(0).click();
	}
	public String getCallStatus() {
		return HistoryObj.CallStatus.get(0).getText();
	}
	public String getCallDates() {
		return HistoryObj.CallDate.get(0).getText();
	}
	public void DateConvert() {
		String Month;
		String day;
		String year;
		String oldDateformate = getCallDates();
		if(oldDateformate.contains(" ")){
			oldDateformate= oldDateformate.substring(0, oldDateformate.indexOf(" ")); 
	        System.out.println(oldDateformate);
		}
	}
	public String getCallerName() {
		return HistoryObj.ContactName.get(0).getText();
	}
	public void DeleteHistory() {
		util.longPress(HistoryObj.ContactName.get(0));
		HistoryObj.HistoryDeleteBtn.click();
		HistoryObj.dilogYesBtn.click();
	}
	public void getBack() {
		HistoryObj.PageBack.click();
	}
	public String getCallDate() {
		return HistoryObj.CallTime.get(0).getText();
	}
}
