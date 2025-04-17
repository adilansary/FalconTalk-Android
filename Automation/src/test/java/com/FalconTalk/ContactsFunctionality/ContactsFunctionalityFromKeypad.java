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

public class ContactsFunctionalityFromKeypad {
    public int size;
    public int size1;
    public String SearchNumber=null;
    public String device=null;
    @BeforeTest
    public void Server_Start() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(8000);
    }

    @DataProvider(name = "keypadDB")
    public Object[] readJson() throws Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/Contacts.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("keypadContactsDB");
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
            contact[i] = prifix+","+ fname+ ","+mname+"," +lname+","+suffix+"," +phone + "," + email;
        }

        return contact;
    }

    @DataProvider(name = "ExistingContactDB")
    public Object[] readJsons() throws Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/Contacts.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("ExistingContactDB");
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


    @Test(priority = 1,dataProvider = "keypadDB",description = "Create New Contact from Keypad")
    @Severity(SeverityLevel.BLOCKER)
    public void ContactNewContactfromKeypadTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        device = ActiavityMain.deviceName();
        ContactFunction.dialFromKeypad(contactsdata[5]);
        ContactFunction.CreateNewContactFromKeypad();
        ContactFunction.CreateNewContact(device,contactsdata[0], contactsdata[1], contactsdata[2], contactsdata[3],contactsdata[4],null, contactsdata[6]);
        ContactFunction.deleteAlldigitFromKeypad();
    }

    @Test(priority = 2,dataProvider = "keypadDB",description = "Create New Contact from Keypad and verify that contact is synced in contacts list")
    @Severity(SeverityLevel.CRITICAL)
    public void VerifyContactFromContactListTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.ContactSearch(contactsdata[5]);
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        System.out.println(  ContactFunction.getContactSearchname());
        Assert.assertEquals(ContactFunction.getContactSearchname(),Str,"New Contact Cann't Synced in Contact List list");
        ContactFunction.CloseSearchOption();
    }

    @Test(priority = 3,dataProvider = "keypadDB",description = "Create New Contact from Keypad and verify that contact is synced in history list")
    @Severity(SeverityLevel.CRITICAL)
    public void ContactSyncwithHistoryTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.ContactSearch(contactsdata[5]);
        ContactFunction.getContactSearchDetails();
        ContactFunction.GetCallFromContactDetailspage();
        ContactFunction.callEnd();
        ContactFunction.getBack();
        ContactFunction.CloseSearchOption();
        ContactFunction.getHistorypage();
        ContactFunction.getFirstCallNameFromHistory();
        System.out.println(ContactFunction.getFirstCallNameFromHistory());
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact from Keypad Cann't Synced in History list");
    }

    @Test(priority = 4,dataProvider = "keypadDB",description = "Create New Contact from Keypad and verify that contact is synced in history details")
    @Severity(SeverityLevel.CRITICAL)
    public void ContactSyncWithHistoryDetailsTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        System.out.println(size);
        SearchNumber = contactsdata[5];
        ContactFunction.getCallDetailsAccordingToData(size-1);
        size--;
        ContactFunction.getFirstCallNameFromHistory();
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact Cann't Synced in History list");
        ContactFunction.getBack();
    }

    @Test(priority = 5,dataProvider = "ExistingContactDB",description = "Add to Existing Contact from Keypad")
    @Severity(SeverityLevel.BLOCKER)
    public void AddToExistingContactFromKeypadTest(String ExistingcontactData) throws InterruptedException {
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getKeypadPage();
        String[] contactsdata = ExistingcontactData.split(",");
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        ContactFunction.dialFromKeypad(contactsdata[5]);
        ContactFunction.CreateContactFormKeypad();
        Thread.sleep(3000);
        ContactFunction.SearchForSelectContact(contactsdata[7]);
        ContactFunction.getContactDetailsAndEditName(device,contactsdata[0],contactsdata[1],contactsdata[2],contactsdata[3],contactsdata[4],null,null);
        ContactFunction.deleteAlldigitFromKeypad();
        System.out.println(Str);

    }

    @Test(priority = 6,dataProvider = "ExistingContactDB",description = "Add to Existing Contact from Keypad and verify that contact is synced in contacts list")
    @Severity(SeverityLevel.CRITICAL)
    public void ExistingContactSyncInContactListTest(String ExistingcontactData){
        String[] contactsdata =ExistingcontactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.ContactSearch(contactsdata[5]);
        String Strs = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        System.out.println(  ContactFunction.getContactSearchname());
        Assert.assertEquals(ContactFunction.getContactSearchname(),Strs,"Existing Contact Cann't Synced in Contact List list");
        ContactFunction.CloseSearchOption();
    }
    @Test(priority = 7,dataProvider = "ExistingContactDB",description = "Add to Existing Contact from Keypad and verify that contact is synced in history list")
    @Severity(SeverityLevel.CRITICAL)
    public void ExistingContactSyncWithHistoryListTest(String ExistingcontactData){
        String[] contactsdata =ExistingcontactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.ContactSearch(contactsdata[5]);
        ContactFunction.getContactSearchDetails();
        ContactFunction.GetCallFromContactDetailspage();
        ContactFunction.callEnd();
        ContactFunction.getBack();
        ContactFunction.CloseSearchOption();
        ContactFunction.getHistorypage();
        ContactFunction.getFirstCallNameFromHistory();
        System.out.println(ContactFunction.getFirstCallNameFromHistory());
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"Existing Contact from Keypad Cann't Synced in History list");
    }

    @Test(priority = 8,dataProvider = "ExistingContactDB",description = "Add to Existing Contact from Keypad and verify that contact is synced in history details")
    @Severity(SeverityLevel.CRITICAL)
    public void ExistingContactFromKeypadSyncInHistoryDetailsTest(String ExistingcontactData){
        String[] contactsdata =ExistingcontactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        System.out.println(size1);
        SearchNumber = contactsdata[5];
        ContactFunction.getCallDetailsAccordingToData(size1-1);
        size1--;
        ContactFunction.getFirstCallNameFromHistory();
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"Existing Contact Cann't Synced in History Details");
        ContactFunction.getBack();
    }

    @AfterTest
    public void tearDown() {
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }
}
