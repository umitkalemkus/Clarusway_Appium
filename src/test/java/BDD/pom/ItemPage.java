package BDD.pom;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.MDriver;

public class ItemPage {
    public ItemPage() {
        PageFactory.initElements(new AppiumFieldDecorator(MDriver.getMDriver()),this);

    }

    @AndroidFindBy(id = "com.etsy.android:id/navigation_button")
    public WebElement backButton;


    @AndroidFindBy(xpath = "(//*[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[1]")
    public WebElement watchButton;








}
