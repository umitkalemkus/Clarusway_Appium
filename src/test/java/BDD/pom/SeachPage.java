package BDD.pom;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.MDriver;

import java.util.List;

public class SeachPage {

    public SeachPage() {
        PageFactory.initElements(new AppiumFieldDecorator(MDriver.getMDriver()),this);

    }

  /*  @AndroidFindAll({

        @AndroidBy(id = "com.etsy.android:id/listing_image"),
            @AndroidBy(id = "com.etsy.android:id/listing_image")


    }
    )
    List<WebElement> abc;*/







    @AndroidFindBy(id = "com.etsy.android:id/listing_image")
    public List<WebElement> contentOfSearchListTitle;




}
