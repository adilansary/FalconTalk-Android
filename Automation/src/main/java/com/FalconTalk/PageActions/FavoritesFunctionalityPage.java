package com.FalconTalk.PageActions;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.FavoritesFunctionalityObj;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FavoritesFunctionalityPage {
    public FavoritesFunctionalityPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }
    FavoritesFunctionalityObj FavObject = new FavoritesFunctionalityObj();

    public void add_To_Favorite_From_Contact_Details(){
        FavObject.AddFavorites.click();
    }
    public int How_Many_Number_In_Contact(){
        return FavObject.ContactNumber.size();
    }

    public void Choose_Favorite_Number(int index){
        FavObject.Choose_Favorite_Number.get(index).click();
    }

    public void getFavoritPage(){
        FavObject.Favorites.click();
    }
    public String getFavorites_Contact_Name(){
        return FavObject.Favorite_Contact_Name.get(0).getText();
    }

    public void getFavoritesDetails(){
        FavObject.Fvt_Contact_info.click();
    }
    public String getContactFullNameInFavoriteDetailsPage(){
        return FavObject.Contact_Name_Fav_Details.getText();
    }

    public String Favorite_Contact_Number_Type(){
        return FavObject.Fav_Contact_Number_Type.getText();
    }

    public boolean getContactDetailsPageorNot(){
        return FavObject.FavContactsDetailsPage.isDisplayed();
    }
    public boolean addContactIconShwoingOrNot(){return FavObject.AddContctIcon.isDisplayed();}

    public void Edit_Contact(){
        FavObject.Edit_Contact.click();
    }
    public String GetNumberInFavoriteDetailsPage(){
        int SizeOfList = FavObject.ContactNumber.size();
        String Num = FavObject.ContactNumber.get(SizeOfList-1).getText();
        return Num;
    }
}
