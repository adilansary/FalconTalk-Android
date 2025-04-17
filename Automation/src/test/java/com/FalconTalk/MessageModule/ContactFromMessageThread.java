package com.FalconTalk.MessageModule;
import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.ContactsFunctionalityPage;
import com.FalconTalk.PageActions.HistoryFunctionalityPage;
import com.FalconTalk.PageActions.MessageModulePage;
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

public class ContactFromMessageThread {
    public int size = 0;

    @DataProvider(name = "contactDB")
    public Object[] readJson() throws FileNotFoundException, IOException,Exception,Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/ContactFromMessage.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("ContactForMessageThread");
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
            String SearchNumber = (String) contacts.get("SearchNumber");
            contact[i] = prifix+","+ fname+ ","+mname+"," +lname+","+suffix+"," +phone + "," + email + "," + SearchNumber;
        }

        return contact;
    }

    @BeforeTest
    public void Server_Start() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(5000);
    }

    @Test(priority = 0,description = "Check account sign in and message service online or not")
    public void CheckMessageServiceOnlineStatus() throws InterruptedException {
        MessageModulePage messagepage = new MessageModulePage();
        messagepage.NavigationdDrawerOpen();
        messagepage.SignIn();
        int i=0;
        while(true) {
            if(messagepage.MessageModuleOnlineCheck() == true) {
                messagepage.getBack();
                break;
            }else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i==12) {
                    try {
                        messagepage.ResyncAccForMessageModule();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i=0;
                }
                i++;
                continue;
            }
        }
    }


    @Test(priority = 1,dataProvider = "contactDB",description = "Create New Contact from Message Thread option icon and verify that contact is synced in Message list")
    public void CreateNewContactFromMessageThreadOption(String contactData){

        MessageModulePage messagepage = new MessageModulePage();
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        messagepage.getMessagePage();
        messagepage.newMessageSent();
        messagepage.BuddySearchNumber(contactsdata[7]);
        messagepage.sentMessage("Message Sent");
        messagepage.getMoreOptionsFromMessageThread();
        messagepage.getAddToContactFromMessageThread();
        String device = ActiavityMain.deviceName();
        System.out.println(device);
        Contact.getNewContact();
        String expected = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Contact.CreateNewContact(device,contactsdata[0],contactsdata[1],contactsdata[2],contactsdata[3],contactsdata[4],null,null);
        Contact.getBack();
        Assert.assertEquals(messagepage.getBuddyNameOnMessageList(0),expected,"BuddyName Can't Sync with Message List");

    }
    @Test(priority = 2,dataProvider = "contactDB",description = "Create New Contact from Message Thread and verify that contact is synced in contacts list")
    public void ContactfromMessageThreadisSyncedInContactList(String contactData){
        MessageModulePage messagepage = new MessageModulePage();
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        Contact.getContactPage();
        Contact.ContactSearch(contactsdata[7]);
        String actual = Contact.getContactSearchname();
        String expected = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual,expected,"Contact name Can't Sync with contact List");
        Contact.CloseSearchOption();
        messagepage.getMessagePage();
    }

    @Test(priority = 3,dataProvider = "contactDB",description = "Create New Contact from Message Thread and verify that contact is synced in buddies list and details")
    public void ContactfromMessageThreadisSyncedInBuddiesListAndDetails(String contactData){
        MessageModulePage messagepage = new MessageModulePage();
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        String expected = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Contact.getContactPage();
        Contact.getBuddiesPage();
        //Contact.BuddiesListShowingOrNot();
        Contact.spadHoneywellOfflineList();
        Contact.ContactSearch(expected);
        String buddyName = Contact.getBuddyName();
        Contact.getBuddyDetails();
        String buddyNameinBuddyDetails = Contact.getBuddyDetailsName();
        System.out.println(buddyName);
        System.out.println(buddyNameinBuddyDetails);
        Contact.getBack();
        Contact.CloseSearchOption();
        Assert.assertEquals(buddyName,expected,"Buddy name can't sync in buddy list");
        Assert.assertEquals(buddyNameinBuddyDetails,expected,"Buddy name can't sync in buddy details");


    }

    @Test(priority = 4,dataProvider = "contactDB",description = "Create New Contact from Message Thread and verify that contact is synced in history list and details")
    public void ContactfromMessageThreadSyncedInHistory(String contactData) throws InterruptedException {
        MessageModulePage messagepage = new MessageModulePage();
        HistoryFunctionalityPage HistoryPage = new HistoryFunctionalityPage();
        String[] contactsdata =contactData.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        String expected = contactsdata[0]+" "+ contactsdata[1]+" "+ contactsdata[2]+" "+contactsdata[3]+","+" "+contactsdata[4];
        Contact.getContactPage();
        Contact.getBuddiesPage();
        Contact.ContactSearch(expected);
        Contact.getBuddyDetails();
        Contact.callFromBuddyDetails_SaveName();
        Thread.sleep(5000);
        Contact.callEnd();
        HistoryPage.getHistoryTab();
        String callerName = HistoryPage.getCallerName();
        HistoryPage.getHistoryDetailsPage();
        String callerNameinDetailsPage = HistoryPage.getCallerName();
        System.out.println(callerName);
        System.out.println(callerNameinDetailsPage);
        HistoryPage.getBack();


    }


    @AfterTest
    public void tearDown() {
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }
}
