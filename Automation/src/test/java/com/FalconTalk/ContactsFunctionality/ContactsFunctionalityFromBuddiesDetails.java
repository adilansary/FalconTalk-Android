package com.FalconTalk.ContactsFunctionality;
import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.ContactsFunctionalityPage;
import com.FalconTalk.PageActions.HoneywellAccountPage;
import com.FalconTalk.PageActions.MessageModulePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.net.MalformedURLException;

public class ContactsFunctionalityFromBuddiesDetails {
    public String deviceName=null;
    public int size1;
    @BeforeTest
    public void Server_Start() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(10000);
    }
    @DataProvider(name = "NewContactFromBuddyDetailsDB")
    public Object[] readJsons() throws Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/Contacts.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("NewContactFromBuddyDetailsDB");
        size1=contactsDetailsArray.size();
        //String arr[]=new String[contactsDetailsArray.size()];
        Object contact[]= new Object[contactsDetailsArray.size()];
        for(int i=0;i<contactsDetailsArray.size();i++) {
            JSONObject contacts = (JSONObject) contactsDetailsArray.get(i);
            String prifix = (String) contacts.get("prefix");
            String fname = (String) contacts.get("fname");
            String mname = (String) contacts.get("mname");
            String lname = (String) contacts.get("lname");
            String suffix = (String) contacts.get("sufix");
            String phone = (String) contacts.get("phone");
            String email = (String) contacts.get("email");
            String previousPhone = (String) contacts.get("searchnumber");
            contact[i] = prifix+","+ fname+ ","+mname+"," +lname+","+suffix+"," +phone + "," + email+","+previousPhone;
        }

        return contact;
    }

    @Test(priority = 1)
    public void SignInAndBuddiesOnlineCheck() throws InterruptedException {
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        MessageModulePage messagePage = new MessageModulePage();
        HoneywellAccountPage honey = new HoneywellAccountPage();
        messagePage.NavigationdDrawerOpen();
        messagePage.CheckSinginOrNot();
        //System.out.println(honey.AccountOnlineOrNot());

        Thread.sleep(10000);
    }

    @Test(priority = 2,dataProvider = "NewContactFromBuddyDetailsDB",description = "Create New Contact from Buddies Details")
    @Severity(SeverityLevel.BLOCKER)
    public void CreateNewContactFromBuddiesDetailsTest(String contactData) throws InterruptedException {
        String[] contactsdata =contactData.split(",");
        deviceName = ActiavityMain.deviceName();
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.getBuddiesPage();
        ContactFunction.spadHoneywellOfflineList();
        Thread.sleep(10000);
        ContactFunction.ContactSearch(contactsdata[7]);
        ContactFunction.getBuddyDetails();
        ContactFunction.AddContactFromBuddyDetails();
        ContactFunction.getNewContact();
        ContactFunction.CreateNewContact(deviceName,contactsdata[0], contactsdata[1], contactsdata[2], contactsdata[3],contactsdata[4],null, contactsdata[6]);
        Thread.sleep(3000);
        ContactFunction.CloseSearchOption();
    }

    @Test(priority = 3,dataProvider = "NewContactFromBuddyDetailsDB",description = "Create New Contact from Buddies Details and verify that contact is synced in contacts list")
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyContactSyncInContactsListTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.getContactsList();
        ContactFunction.ContactSearch(contactsdata[7]);
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        System.out.println(  ContactFunction.getContactSearchname());
        Assert.assertEquals(ContactFunction.getContactSearchname(),Str,"New Contact Cann't Synced in Contact List list");
        ContactFunction.CloseSearchOption();
    }

    @Test(priority = 4,dataProvider = "NewContactFromBuddyDetailsDB",description = "Create New Contact from Buddies Details and verify that contact is synced in buddies list and details")
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyContactSyncInBuddiesListAndDetails(String contactData) throws InterruptedException {
        String[] contactsdata =contactData.split(",");
        String ActualNameInBuddyList=null;
        String ActualNameInBuddyDetails = null;
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
//        ActiavityMain.hideKeyboard();
        ContactFunction.getContactPage();
        ContactFunction.getBuddiesPage();
        ContactFunction.spadHoneywellOfflineList();
        Thread.sleep(10000);
        ContactFunction.ContactSearch(contactsdata[7]);
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        //System.out.println(  ContactFunction.getContactSearchname());
        if(Str.equals(ContactFunction.getBuddyName())){
            ActualNameInBuddyList = ContactFunction.getBuddyName();
            ContactFunction.getBuddyDetails();
            ActualNameInBuddyDetails = ContactFunction.getBuddyDetailsName();
            ContactFunction.getBack();
            ContactFunction.CloseSearchOption();
            Thread.sleep(2000);
        }else {
            ContactFunction.CloseSearchOption();
            ContactFunction.spadHoneywellOfflineList();
            Thread.sleep(2000);
        }

        Assert.assertEquals(ActualNameInBuddyList,Str,"New Contact Cann't Synced in Buddy List");
        Assert.assertEquals(ActualNameInBuddyDetails,Str,"New Contact Cann't Synced in Buddy Details List");
    }

    @Test(priority = 5,dataProvider = "NewContactFromBuddyDetailsDB",description = "Create New Contact from Buddies Details and verify that contact is synced in history list and details")
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyContactSyncInHistoryListAndDetailsTest(String contactData) throws InterruptedException {
        String ActualResultHistoryList=null;
        String ActualResultHistoryDetails=null;
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
//        ActiavityMain.hideKeyboard();
        ContactFunction.getKeypadPage();
        ContactFunction.getContactPage();
        ContactFunction.getBuddiesPage();
        Thread.sleep(20000);
        ContactFunction.spadHoneywellOfflineList();
        ContactFunction.ContactSearch(contactsdata[7]);
        ContactFunction.getBuddyDetails();
        System.out.println(ContactFunction.visibleCallerIcon_SaveName());
        System.out.println(ContactFunction.visibleMessageIcon_UnSaveName());
        if (ContactFunction.visibleCallerIcon_SaveName()==true){
            ContactFunction.callFromBuddyDetails_SaveName();
            System.out.println(ContactFunction.visibleCallerIcon_SaveName());
        }else {
            ContactFunction.callFromBuddyDetails_UnSaveName();
        }
        ContactFunction.callEnd();
        ContactFunction.getBack();
        ContactFunction.CloseSearchOption();
        ContactFunction.getHistorypage();
        if(Str.equals(ContactFunction.getFirstCallNameFromHistory())){
            ActualResultHistoryList = ContactFunction.getFirstCallNameFromHistory();
            ContactFunction.getCallDetailsAccordingToData(0);
            ActualResultHistoryDetails = ContactFunction.getFirstCallNameFromHistory();
            ContactFunction.getBack();
        }else {
            System.out.println("Contact Cann't sync in history list");
        }
        Assert.assertEquals(ActualResultHistoryList,Str,"New Contact Cann't Synced in History List");
        Assert.assertEquals(ActualResultHistoryDetails,Str,"New Contact Cann't Synced in History Details List");
    }

    @Test(priority = 6,dataProvider = "NewContactFromBuddyDetailsDB",description = "Create New Contact from Buddies Details and verify that contact is synced in message Thread and List")
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyContactSyncedInMessageThreadAndListTest(String contactData){
        String MessageThreadName = null;
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        MessageModulePage messagePage = new MessageModulePage();
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        ContactFunction.getContactPage();
        ContactFunction.getBuddiesPage();
        ContactFunction.spadHoneywellOfflineList();
        ContactFunction.ContactSearch(contactsdata[7]);
        ContactFunction.getBuddyDetails();
        if(ContactFunction.visibleMessageIcon_SaveName()==true){
            ContactFunction.messageFromBuddyDetails_SaveName();
            MessageThreadName = ContactFunction.messageThreadName();
            ContactFunction.getBack();
            try {
                messagePage.getMessageBodys("Message From Buddy Details");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            ContactFunction.messageFromBuddyDetails_UnSaveName();
            MessageThreadName = ContactFunction.messageThreadName();
            ContactFunction.getBack();
            try {
                messagePage.getMessageBody("Message From Buddy Details");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(MessageThreadName,Str,"New Contact Cann't Synced in Message Thread");
        Assert.assertEquals( ContactFunction.messageListChattingName(0),Str,"New Contact Cann't Synced in Message Thread");
    }
    @AfterTest
    public void tearDown() {
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }

}
