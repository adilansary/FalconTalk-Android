package com.FalconTalk.PageActions;

import com.FalconTalk.PageObject.BuddiesFunctionalityObj;

public class BuddiesFunctionalityPage {
	BuddiesFunctionalityObj BuddiesObj=new BuddiesFunctionalityObj();
	
	public void getContactsPage() {
		BuddiesObj.Contacts.click();
	}
	public void getContactList() {
		BuddiesObj.ContactsBtn.click();
	}
	public void getBuddisPage() {
		BuddiesObj.BuddiesBtn.click();
	}
	
	public void SearchInContact(String SearchValue) {
		try {
			BuddiesObj.ContactSearch.click();
			BuddiesObj.SearchText.sendKeys(SearchValue);
		}catch(Exception e) {
			CancelSearch();
			BuddiesObj.ContactSearch.click();
			BuddiesObj.SearchText.sendKeys(SearchValue);
		}
		
		
	}
	
	public void CancelSearch() {
		BuddiesObj.SearchCloseBtn.click();
		BuddiesObj.SearchCloseBtn.click();
	}
	
	public boolean ContactFoundOrNotCheck() {
		try {
			BuddiesObj.NoContactFound.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	public void getContactDetails() {
		BuddiesObj.ContactSelect.get(0).click();
	}
	public void contactDelete() {
		BuddiesObj.DeleteContact.click();
		BuddiesObj.YesBtn.click();
	}
	public void ExpandHoneyWellOnlineAccountList() {
		BuddiesObj.OnlineOfflineBuddyList.get(0).click();
	}
	public void ExpandHoneyWellOfflineAccountList() {
		BuddiesObj.OnlineOfflineBuddyList.get(1).click();
	}
	
	public String CheckBuddyName() {
		try {
			BuddiesObj.BuddyDisplayName.isDisplayed();
			
		}catch(Exception e) {
			ExpandHoneyWellOnlineAccountList();
			ExpandHoneyWellOfflineAccountList();
			try {
				BuddiesObj.BuddyDisplayName.isDisplayed();
			}catch(Exception ex) {
				return null;
			}
			return BuddiesObj.BuddyDisplayName.getText();
		}
		return BuddiesObj.BuddyDisplayName.getText();
		
	}
	
	public void addContact() {
		BuddiesObj.AddContacts.click();
	}
	
	public String getContactName() {
		return BuddiesObj.ContactSelect.get(0).getText();
	}
	
	
}
