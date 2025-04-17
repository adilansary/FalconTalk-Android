package com.FalconTalk.ContactsFunctionality;
import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.ContactsFunctionalityPage;
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

public class ContactsFunctionalityFromHistoryDetails {
    public int size;
    public int size1;
    public String device=null;
    @BeforeTest
    public void Server_Start() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(5000);
    }

    @DataProvider(name = "ContactFromHistoryDB")
    public Object[] readJson() throws Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/Contacts.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("ContactFromHistory");
        size=contactsDetailsArray.size();
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
            String previousPhone = (String) contacts.get("PrePhone");
            contact[i] = prifix+","+ fname+ ","+mname+"," +lname+","+suffix+"," +phone + "," + email+","+previousPhone;
        }

        return contact;
    }
    @DataProvider(name = "AddToExistingContactFromHistoryDB")
    public Object[] readJsonForExistion() throws Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/Contacts.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("AddToExistingContactFromHistoryDB");
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
            String previousPhone = (String) contacts.get("PrePhone");
            contact[i] = prifix+","+ fname+ ","+mname+"," +lname+","+suffix+"," +phone + "," + email+","+previousPhone;
        }

        return contact;
    }

    @Test(priority = 1,dataProvider = "ContactFromHistoryDB",description = "Create New Contact from History Details")
    @Severity(SeverityLevel.BLOCKER)
    public void CreateNewContactFromHistoryDetailsTest(String contactFromHistory) throws InterruptedException {
        device = ActiavityMain.deviceName();
        String[] contactsdata =contactFromHistory.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getKeypadPage();
        ContactFunction.dialFromKeypad(contactsdata[5]);
        ContactFunction.callFromKeypad();
        Thread.sleep(3000);
        ContactFunction.callEnd();
        ContactFunction.getHistorypage();
        ContactFunction.getFirstCallDetailsFromHistory();
        ContactFunction.AddContactFromHistoryDetails();
        ContactFunction.getNewContact();
        ContactFunction.CreateNewContact(device,contactsdata[0], contactsdata[1], contactsdata[2], contactsdata[3],contactsdata[4],null, contactsdata[6]);
        String ContactExpectedName = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),ContactExpectedName,"New Contact From History Details Cann't Saved");
        ContactFunction.getBack();
        //ContactFunction.deleteAlldigitFromKeypad();
    }

    @Test(priority = 2,dataProvider = "ContactFromHistoryDB",description = "Create New Contact from History Details and verify that contact is synced in contacts list")
    public void ContactSyncedInContactsList(String contactFromHistory){
        String[] contactsdata =contactFromHistory.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.ContactSearch(contactsdata[5]);
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        System.out.println(  ContactFunction.getContactSearchname());
        Assert.assertEquals(ContactFunction.getContactSearchname(),Str,"New Contact Cann't Synced in Contact List list");
        ContactFunction.CloseSearchOption();
    }

    @Test(priority = 3,dataProvider = "ContactFromHistoryDB",description = "Create New Contact from History Details and verify that contact is synced in history list and history details")
    public void ContactSyncWithHistoryListAndDetails(String contactFromHistory){
        String[] contactsdata =contactFromHistory.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getHistorypage();
        System.out.println(ContactFunction.getCallerNameFromHistory(size-1));
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getCallerNameFromHistory(size-1),Str,"New Contact from Keypad Cann't Synced in History list");
        ContactFunction.getCallDetailsFromHistory(size-1);
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact from Keypad Cann't Synced in History list");
        size--;
        ContactFunction.getBack();
    }

    @Test(priority = 4,dataProvider = "AddToExistingContactFromHistoryDB",description = "Add to Existing Contact from History Details")
    public void AddToExistingContactFromHistoryDetailsTest(String AddToExistingcontactFromHistory) throws InterruptedException {
        String[] contactsData = AddToExistingcontactFromHistory.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getKeypadPage();
        String Str = contactsData[0]+" "+ contactsData[1]+" "+ contactsData[2]+" "+contactsData[3]+","+" "+contactsData[4];
        ContactFunction.dialFromKeypad(contactsData[5]);
        ContactFunction.CreateContactFormKeypad();
        Thread.sleep(3000);
        ContactFunction.SearchForSelectContact(contactsData[7]);
        ContactFunction.getContactDetailsAndEditName(device,contactsData[0],contactsData[1],contactsData[2],contactsData[3],contactsData[4],null,null);
        ContactFunction.deleteAlldigitFromKeypad();
        System.out.println(Str);

    }
    @Test(priority = 5,description = "Add to Existing Contact from History Details and verify that contact is synced in contacts list")
    public void ExistingContactFromHistoryDetailsSyncInContactListTest(){

    }

    @Test(priority = 6,description = "Add to Existing Contact from History Details and verify that contact is synced in history list")
    public void ExistingContactFromHistoryDetailsSyncInHistoryListTest(){

    }
    @Test(priority = 7,description = "Add to Existing Contact from History Details and verify that contact is synced in history details")
    public void ExistingContactFromHistoryDetailsSyncInHistoryDetailsTest(){

    }

    @AfterTest
    public void tearDown() {
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }
}
