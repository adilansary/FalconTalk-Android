package com.FalconTalk.FavoritesFunctionality;
import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.ContactsFunctionalityPage;
import com.FalconTalk.PageActions.FavoritesFunctionalityPage;
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

public class FavoritesFunctionality {
    int size;
    String Number = "89738";

    @DataProvider(name = "FavoritesDB")
    public Object[] readJson() throws Throwable{
        String path = "/Users/brotecs/Desktop/Automation/src/main/java/com/FalconTalk/JSONData/FavoritesBD.json";
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject contactsJsonObj = (JSONObject) obj;
        JSONArray contactsDetailsArray=(JSONArray) contactsJsonObj.get("FavoritesData");
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
            String phone1 = (String) contacts.get("phone1");
            String email = (String) contacts.get("email");
            contact[i] = prifix+","+ fname+ ","+mname+"," +lname+","+suffix+"," +phone + ","+phone1+"," + email;
        }

        return contact;
    }

    @BeforeTest
    public void Server_Start() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(5000);
    }
    @Test(priority = 0,dataProvider = "FavoritesDB")
    public void Setup(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        String num1=null,num2=null,name=null;
        name = FavoritsData[0]+FavoritsData[1]+FavoritsData[2];
        num1=FavoritsData[5];
        num2=FavoritsData[6];
        Contact.getContactPage();
        Contact.add_New_Contact();
        //Contact.getNewContact();
        String device = ActiavityMain.deviceName();
        System.out.println(device);
        Contact.CreateNewContactwithMultapleNumber(device,name,num1,num2);
        Contact.getBack();
    }

    @Test(priority = 1,dataProvider = "FavoritesDB",description = "Verify if contact can be set as favorite from Contacts info page or not")
    @Severity(SeverityLevel.CRITICAL)
    public void Add_TO_Favorite_Test(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        String searchNumber = FavoritsData[5];
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        FavoritesFunctionalityPage FavPage = new FavoritesFunctionalityPage();
        String Actual = FavoritsData[0]+FavoritsData[1]+FavoritsData[2];
        Contact.ContactSearch(searchNumber);
        Contact.getContactDetails(0);
        System.out.println(FavPage.How_Many_Number_In_Contact());
        FavPage.add_To_Favorite_From_Contact_Details();
        FavPage.Choose_Favorite_Number(1);
        Contact.getBack();
        Contact.CloseSearchOption();
        FavPage.getFavoritPage();
        String Expected = FavPage.getFavorites_Contact_Name();
        Assert.assertEquals(Expected,Actual,"Favorite Can't added");
    }

    @Test(priority = 2,dataProvider = "FavoritesDB",description = "Verify if all favorites contact is showing in favorites list properly or not")
    @Severity(SeverityLevel.CRITICAL)
    public void Added_Contact_Showing_In_Favorite_List_Test(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        FavoritesFunctionalityPage FavPage = new FavoritesFunctionalityPage();
        String Actual = FavoritsData[0]+FavoritsData[1]+FavoritsData[2];
        String Expected = FavPage.getFavorites_Contact_Name();
        FavPage.getFavoritesDetails();
        String Expected_2 = FavPage.getContactFullNameInFavoriteDetailsPage();
        Contact.getBack();
        Assert.assertEquals(Expected,Actual,"Favorite Can't added");
        Assert.assertEquals(Expected_2,Actual,"Favorite Can't added");
    }

    @Test(priority = 3,dataProvider = "FavoritesDB",description = "Verify if favorites contact number type is showing in favorites list properly or not")
    @Severity(SeverityLevel.CRITICAL)
    public void Contact_Number_Type_Showing_In_Favorites_List_Test(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        FavoritesFunctionalityPage FavPage = new FavoritesFunctionalityPage();
        String Expected = "Home";
        String Actual = FavPage.Favorite_Contact_Number_Type();
        Assert.assertEquals(Expected,Actual,"Favorite Can't added");
    }

    @Test(priority = 4,dataProvider = "FavoritesDB",description = "Verify if favorites contact details page is showing properly or not when press on info icon")
    @Severity(SeverityLevel.CRITICAL)
    public void Favorites_Contact_Details_Test(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        FavoritesFunctionalityPage FavPage = new FavoritesFunctionalityPage();
        FavPage.getFavoritesDetails();
        boolean Expected = true;
        boolean Actual = FavPage.getContactDetailsPageorNot();
        Contact.getBack();
        Assert.assertEquals(Expected,Actual,"Favorite Details Page Can't showing properly");
    }

    @Test(priority = 5,dataProvider = "FavoritesDB",description = "Verify if contact that has multiple number can be set as Favorite or not by choosing default number")
    @Severity(SeverityLevel.CRITICAL)
    public void Multiple_Number_Set_As_Favorite_Test(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        String searchNumber = FavoritsData[5];
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        FavoritesFunctionalityPage FavPage = new FavoritesFunctionalityPage();
        String device = ActiavityMain.deviceName();
        Contact.getContactPage();
        Contact.getContactsList();
        Contact.ContactSearch(searchNumber);
        Contact.getContactSearchDetails();
        FavPage.Edit_Contact();
        Contact.AddPhoneNumberInContact(device,Number);
        FavPage.add_To_Favorite_From_Contact_Details();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FavPage.add_To_Favorite_From_Contact_Details();
        FavPage.Choose_Favorite_Number(2);
        Contact.getBack();
        Contact.CloseSearchOption();
        FavPage.getFavoritPage();
        FavPage.getFavoritesDetails();
        String Actual = FavPage.GetNumberInFavoriteDetailsPage();
        Contact.getBack();
        Assert.assertEquals(Actual,Number,"Number can't added");
    }

    @Test(priority = 6,dataProvider = "FavoritesDB",description = "Verify if contact add button is absent into Favorites tab or not")
    @Severity(SeverityLevel.CRITICAL)
    public void Contact_Add_Button_Absent_In_Favorite_Tab_Test(String FavoritesBD){
        String[] FavoritsData =FavoritesBD.split(",");
        String searchNumber = FavoritsData[5];
        ContactsFunctionalityPage Contact = new ContactsFunctionalityPage();
        FavoritesFunctionalityPage FavPage = new FavoritesFunctionalityPage();
        boolean Actual = FavPage.addContactIconShwoingOrNot();
        Contact.getContactPage();
        Contact.getContactsList();
        Assert.assertEquals(Actual,false,"Button is showing");
    }








    @AfterTest
    public void tearDown() {
        //Activity.CloseApp();
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }
}
