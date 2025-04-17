package com.FalconTalk.PageObject;

import com.FalconTalk.Config.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritesFunctionalityObj {
    public FavoritesFunctionalityObj() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }
    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_contact")
    public WebElement AddFavorites;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_default_fvt")
    public List<WebElement> Button_Default_Favorite;

    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> Choose_Favorite_Number;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_contact_info")
    public WebElement Fvt_Contact_info;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_contact_name")
    public List<WebElement> Favorite_Contact_Name;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_number")
    public List<WebElement> ContactNumber;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_list_btn")
    public WebElement Favorites;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/contact_full_name")
    public WebElement Contact_Name_Fav_Details;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/fvt_contact_phone_type")
    public WebElement Fav_Contact_Number_Type;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Details']")
    public WebElement FavContactsDetailsPage;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/menu_edit_contact")
    public WebElement Edit_Contact;

    @AndroidFindBy(id = "com.dassault.HONfalcontalk:id/add_fab")
    public WebElement AddContctIcon;
}
