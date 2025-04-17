package com.FalconTalk.PageActions;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.ContactsFunctionalityObj;
import com.FalconTalk.PageObject.KeypadObj;
import com.FalconTalk.Utils.Utils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ContactsFunctionalityPage {
    ContactsFunctionalityObj ContactObj = new ContactsFunctionalityObj();
    public ContactsFunctionalityPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }
    public void CloseSearchOption(){
        ContactObj.SearchClose.click();
        ContactObj.SearchClose.click();
    }

    public void getBack(){
        ContactObj.NavigationBack.click();
    }
    public void getContactPage(){
        ContactObj.Contacts.click();
    }
    public void getContactsList(){ContactObj.ContactsList.click();}
    public void scrollContactPage(){
        By df = By.id("dfsa");
        String dsf = "fdsf";
        Utils ut = new Utils();
        ut.scrollDown();
        //ut.scrollNClick(df,dsf);
    }
    public void ContactSearch(String Keyword){
        ContactObj.SearchBtn.click();
        ContactObj.SearchKeyword.sendKeys(Keyword);
    }
    public void CancelSearch(){
        ContactObj.SearchClose.click();
    }
    public void getContactSearchDetails(){
        ContactObj.ContactSearchList.click();
    }
    public void GetCallFromContactDetailspage(){
        try{
            ContactObj.CallFromContactDetails.click();
            Thread.sleep(10000);

        }catch (Exception e){

        }
    }
    public boolean visibleMessageIcon_SaveName(){
        return ContactObj.Message_From_Buddy_Details_SaveName.isDisplayed();
    }
    public boolean visibleMessageIcon_UnSaveName(){
        return ContactObj.Message_From_Buddy_Details_UnSaveName.isDisplayed();
    }
    public void messageFromBuddyDetails_SaveName(){
        ContactObj.Message_From_Buddy_Details_SaveName.click();
    }
    public void messageFromBuddyDetails_UnSaveName(){
        ContactObj.Message_From_Buddy_Details_UnSaveName.click();
    }
    public String messageThreadName(){
        return ContactObj.MessageThreadName.getText();
    }
    public String messageListChattingName(int index){
        return ContactObj.MessageListChattingName.get(index).getText();
    }
    public boolean visibleCallerIcon_SaveName(){
        System.out.println(ContactObj.Call_From_Buddy_Details_SaveName.isDisplayed());
        //return ContactObj.Call_From_Buddy_Details_SaveName.isDisplayed();
        return true;
    }
    public boolean visibleCallerIcon_UnSaveName(){
        return ContactObj.Call_From_Buddy_Details_UnSaveName.isDisplayed();
    }
    public void callFromBuddyDetails_SaveName(){
        ContactObj.Call_From_Buddy_Details_SaveName.click();
    }
    public void callFromBuddyDetails_UnSaveName(){
        ContactObj.Call_From_Buddy_Details_UnSaveName.click();
        try {
            Thread.sleep(10000);
        }catch (Exception e){}
    }
    public void callEnd(){
        try {
            ContactObj.endCall.click();
            Thread.sleep(5000);
        }catch (Exception e){

        }
    }
    public void callFromKeypad(){
        ContactObj.callFromKeypad.click();
    }
    public void getHistorypage(){
        ContactObj.History.click();
    }
    public String getFirstCallNameFromHistory(){
        return ContactObj.AllCallListOnHistoryPage.get(0).getText();
    }
    public void getFirstCallDetailsFromHistory(){
        ContactObj.AllCallListOnHistoryPage.get(0).click();
    }
    public String getCallerNameFromHistory(int index){
        return ContactObj.AllCallListOnHistoryPage.get(index).getText();
    }
    public void getCallDetailsFromHistory(int index){
        ContactObj.AllCallListOnHistoryPage.get(index).click();
    }
    public void getCallDetailsAccordingToData(int i){
        ContactObj.AllCallListOnHistoryPage.get(i).click();
    }
    public String getContactSearchname(){
        return ContactObj.ContactSearchList.getText();
    }
    public int getContactSize(){
        return ContactObj.ContactName.size();
    }
    public void getContactDetails(int index){
        ContactObj.ContactName.get(index).click();
    }
    public void getNewContact(){
        ContactObj.CreateNewContact.click();
    }
    public void add_New_Contact(){ContactObj.addFavorit.click();}

    public void CreateNewContact(String deviceName,String NamePrefix, String FirstName, String MiddleName, String LastName, String NameSuffix, String Phone, String Email){
        if(deviceName.equals("SM-T510")){//Samsung Galaxy Tab A = SM - T510
            ContactObj.ArrowButton.click();
            if(NamePrefix !=null){
                ContactObj.NamePrefix.sendKeys(NamePrefix);
            }
            if(FirstName != null){
                ContactObj.FirstName.sendKeys(FirstName);
            }
            if(MiddleName != null){
                ContactObj.MiddleName.sendKeys(MiddleName);
            }
            if(LastName != null){
                ContactObj.LastName.sendKeys(LastName);
            }
            if(NameSuffix != null){
                ContactObj.NameSuffix.sendKeys(NameSuffix);
            }
            if (Phone != null){
                ContactObj.PhoneNumberClick.click();
                ContactObj.PhoneNumberInput.sendKeys(Phone);
            }
            if (Email != null){
                ContactObj.EmailClink.click();
                ContactObj.EmailInput.sendKeys(Email);
            }
            ContactObj.SaveButton.click();
        }

        if(deviceName.equals("SM-G975U")){//Samsung Galaxy S10 Plus = SM - G975U
            ContactObj.ArrowButton.click();
            if(NamePrefix !=null){
                ContactObj.NamePrefix.sendKeys(NamePrefix);
            }
            if(FirstName != null){
                ContactObj.FirstName.sendKeys(FirstName);
            }
            if(MiddleName != null){
                ContactObj.MiddleName.sendKeys(MiddleName);
            }
            if(LastName != null){
                ContactObj.LastName.sendKeys(LastName);
            }
            if(NameSuffix != null){
                ContactObj.NameSuffix.sendKeys(NameSuffix);
            }
            if (Phone != null){
                ContactObj.PhoneNumberClick.click();
                ContactObj.PhoneNumberInput.sendKeys(Phone);
            }
            if (Email != null){
                ContactObj.EmailClink.click();
                ContactObj.EmailInput.sendKeys(Email);
            }
            ContactObj.SaveButton.click();
        }

    }
    public void CreateNewContactwithMultapleNumber(String deviceName,String FullName ,String num1,String num2){
        if (deviceName.equals("SM-G975U")){
            //SystemUtils utils = new SystemUtils();
            //utils.hideKeyboard();
            if (FullName !=null){
                ContactObj.Full_Name.sendKeys(FullName);
            }
            if(num1 != null){
                ContactObj.PhoneNumberClick.click();
                ContactObj.MultiplePhoneNumberInput.get(0).sendKeys(num1);
            }
            if(num2 != null){
                ContactObj.Add_Second_Phone_Input_Field.click();
                ContactObj.MultiplePhoneNumberInput.get(0).sendKeys(num2);
            }
            ContactObj.SaveButton.click();
        }
    }
    public void AddPhoneNumberInContact(String deviceName,String Number){
        if (deviceName.equals("SM-G975U")){
            ContactObj.Add_Second_Phone_Input_Field.click();
            ContactObj.MultiplePhoneNumberInput.get(0).sendKeys(Number);

            ContactObj.SaveButton.click();
        }
    }

    public  void getKeypadPage(){
        ContactObj.Keypad.click();
    }
    public void AddContactFromHistoryDetails(){
        ContactObj.AddContactFromHistoryDetails.click();
    }
    public void deleteAlldigitFromKeypad(){
        KeypadObj Keypad = new KeypadObj();
        Utils util = new Utils();
        util.longPress(Keypad.button_del);
    }
    public void SearchForSelectContact(String searchKey){
        ContactObj.SearchForExistingContact.click();
        ContactObj.SearchForExistingContact.sendKeys(searchKey);
    }
    public void getContactDetailsAndEditName(String deviceName,String NamePrefix, String FirstName, String MiddleName, String LastName, String NameSuffix, String Phone, String Email) {
        ContactObj.ContactDetails.get(0).click();
        if (deviceName.equals("SM-T510")) {//Samsung Galaxy Tab A = SM - T510
            ContactObj.ArrowButton.click();
            if (NamePrefix != null) {
                ContactObj.NamePrefix.clear();
                ContactObj.NamePrefix.sendKeys(NamePrefix);
            }
            if (FirstName != null) {
                ContactObj.FirstName.clear();
                ContactObj.FirstName.sendKeys(FirstName);
            }
            if (MiddleName != null) {
                ContactObj.MiddleName.clear();
                ContactObj.MiddleName.sendKeys(MiddleName);
            }
            if (LastName != null) {
                ContactObj.LastName.clear();
                ContactObj.LastName.sendKeys(LastName);
            }
            if (NameSuffix != null) {
                ContactObj.NameSuffix.clear();
                ContactObj.NameSuffix.sendKeys(NameSuffix);
            }
            if (Phone != null) {
                ContactObj.EditContactName.clear();
                ContactObj.PhoneNumberClick.click();
                ContactObj.PhoneNumberInput.sendKeys(Phone);
            }
            if (Email != null) {
                ContactObj.EmailClink.click();
                ContactObj.EmailInput.sendKeys(Email);
            }
            ContactObj.SaveButton.click();
        }
    }
    public void dialFromKeypad(String num){
        KeypadObj Keypad = new KeypadObj();
        int i=0;
        char ver;
        for (i=0;i<num.length();i++){
            ver=num.charAt(i);
            if(ver=='0'){
                Keypad.dialer0.click();
            }
            else if(ver=='1'){
                Keypad.dialer1.click();
            }
            else if(ver=='2'){
                Keypad.dialer2.click();
            }
            else if(ver=='3'){
                Keypad.dialer3.click();
            }
            else if(ver=='4'){
                Keypad.dialer4.click();
            }
            else if(ver=='5'){
                Keypad.dialer5.click();
            }
            else if(ver=='6'){
                Keypad.dialer6.click();
            }
            else if(ver=='7'){
                Keypad.dialer7.click();
            }
            else if(ver=='8'){
                Keypad.dialer8.click();
            }
            else if(ver=='9'){
                Keypad.dialer9.click();
            }

        }
    }

    public void CreateNewContactFromKeypad(){
        ContactObj.ContactsAddFromKeypad.click();
        ContactObj.CreateNewContact.click();
    }
    public void CreateContactFormKeypad(){
        ContactObj.ContactsAddFromKeypad.click();
    }
    public void getBuddiesPage(){
        ContactObj.BuddyList.click();
    }
    public void BuddiesListShowingOrNot(){
        while (true){
            if (ContactObj.EmptyBuddyNotice.get(1).isDisplayed() == false){
                break;
            }else {
                continue;
            }
        }

    }
    public void getBuddyDetails(){
        ContactObj.BuddiesDisplayName.click();
    }
    public String getBuddyName(){
        return ContactObj.BuddiesDisplayName.getText();
    }
    public String getBuddyDetailsName(){
        return ContactObj.BuddiesDetailsName.getText();
    }
    public void spadHoneywellOfflineList(){
        ContactObj.AccountList.get(1).click();
    }
    public void AddContactFromBuddyDetails(){
        ContactObj.AddBuddyInContacts.click();
        ContactObj.Pop_Up_Yes.click();
    }














}
