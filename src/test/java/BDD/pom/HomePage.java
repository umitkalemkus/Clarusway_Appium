package BDD.pom;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.MDriver;

import java.util.List;


public class HomePage {

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(MDriver.getMDriver()),this);

    }

    @AndroidFindBy(id = "android:id/autofill_save_no")
    public WebElement saveNo;


    @AndroidFindBy(xpath="//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    public WebElement allowButton;



    @AndroidFindBy(xpath ="//*[@resource-id='com.etsy.android:id/empty_view_tertiary_button']")
    public WebElement maybelater;


    @AndroidFindBy(id ="com.etsy.android:id/menu_bottom_nav_home")
    public List<WebElement> homeIconList;


}
