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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

public class ContactsFunctionality {
    public int size = 0;
    //public static String device = ActiavityMain.deviceName();
    @BeforeTest
    public void Server_Start() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(5000);
    }

    @DataProvider(name = "contactDB")
    public Object[] readJson() throws FileNotFoundException,IOException,Exception,Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/Contacts.json";
        JSONParser jsonParser = new JSONParser();

            FileReader reader = new FileReader(path);
            Object obj = jsonParser.parse(reader);
            JSONObject contactsJsonObj = (JSONObject) obj;
            JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("contactsdetails");
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

    @Test(priority = 1,description = "Access any contacts details page and verify if it is showing properly with all info or not")
    @Severity(SeverityLevel.CRITICAL)
    public void ContactTestTest() throws InterruptedException {
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        try {
            System.out.println(Arrays.toString(readJson()));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //Utils.scrollDown();
        //ContactFunction.scrollContactPage();
        //int num = ContactFunction.getContactSize();
        //ContactFunction.getContactDetails(num-1);
        //Thread.sleep(60000);
        System.out.println(14);
    }

    @Test(priority = 2,dataProvider = "contactDB",description = "Create New Contact from Contacts module")
    @Severity(SeverityLevel.BLOCKER)
    public void AddContactTest(String contactData) throws NullPointerException,IndexOutOfBoundsException,InterruptedException{
        int i;
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.getNewContact();
        String device = ActiavityMain.deviceName();
        System.out.println(device);
        Thread.sleep(3000);
        for (i=0;i<1;i++) {
            ContactFunction.CreateNewContact(device,contactsdata[0], contactsdata[1], contactsdata[2], contactsdata[3],contactsdata[4],contactsdata[5] , contactsdata[6]);
        }
        Thread.sleep(3000);
        ContactFunction.getBack();
    }

    @Test(priority = 3,dataProvider = "contactDB",description = "Create New Contact from Contacts module and verify that contact is showing in contacts list")
    @Severity(SeverityLevel.CRITICAL)
    public void ContactShowingOnContactsListTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.ContactSearch(contactsdata[5]);
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        System.out.println(  ContactFunction.getContactSearchname());
        Assert.assertEquals(ContactFunction.getContactSearchname(),Str,"New Contact Cann't Synced in Contact List list");
        ContactFunction.CloseSearchOption();
    }

    @Test(priority = 4,dataProvider = "contactDB",description = "Create New Contact from Contacts module and verify that contact is synced in history list")
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
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact Cann't Synced in History list");
    }

    @Test(priority = 5,dataProvider = "contactDB",description = "Create New Contact from Contacts module and verify that contact is synced in history details")
    @Severity(SeverityLevel.CRITICAL)
    public void ContactSyncWithHistoryDetailsTest(String contactData){
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        System.out.println(size);
        ContactFunction.getCallDetailsAccordingToData(size-1);
        size--;
        ContactFunction.getFirstCallNameFromHistory();
        String Str = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact Cann't Synced in History list");
        ContactFunction.getBack();
    }

    @AfterTest
    public void tearDown() {
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }
}
