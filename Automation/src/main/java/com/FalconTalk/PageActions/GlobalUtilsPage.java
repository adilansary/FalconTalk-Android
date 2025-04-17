package com.FalconTalk.PageActions;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.KeypadObj;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GlobalUtilsPage {
    KeypadObj routerName = new KeypadObj();
    public GlobalUtilsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    public String getSelectRouter(){
        boolean router;
        boolean status;
        try{
            router = routerName.SelectAccountNameAxxess.isDisplayed();
            status = routerName.SelectAccountStatusOnline.isDisplayed();
            System.out.println("Axxess"+router+status);
            if (router!=false && status!=false)return "Axxess";
        }catch (Exception e){
            try{
                router = routerName.SelectAccountNameLegacy.isDisplayed();
                status = routerName.SelectAccountStatusOnline.isDisplayed();
                System.out.println("L"+router+status);
                if (router!=false && status!=false)return "CG-710 (Legacy)";
            }catch (Exception ex){
                try{
                    router = routerName.SelectAccountNameFC.isDisplayed();
                    status = routerName.SelectAccountStatusOnline.isDisplayed();
                    System.out.println("F"+router+status);
                    if (router!=false && status!=false)return "CG-710 (FC)";
                }catch (Exception exs){
                    try{
                        router = routerName.SelectAccountNameCNX.isDisplayed();
                        status = routerName.SelectAccountStatusOnline.isDisplayed();
                        if (router!=false && status!=false)return "CNX-900";
                    }catch (Exception ec){
                        try{
                            router = routerName.SelectAccountNameGDR.isDisplayed();
                            status = routerName.SelectAccountStatusOnline.isDisplayed();
                            if (router!=false && status!=false)return "GDR";
                        }catch (Exception GDR){
                            try{
                                router = routerName.SelectAccountNameSDR.isDisplayed();
                                status = routerName.SelectAccountStatusOnline.isDisplayed();
                                if (router!=false && status!=false)return "SDR";
                            }catch (Exception SDR){
                                System.out.println(SDR);
                            }
                        }
                    }
                }
            }
        }
        return "No Router Found";
    }

}
