package BDD.pom;

import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.MDriver;

import java.util.Random;

import static utilities.MDriver.getMDriver;

public class RegistrationPage {

     public RegistrationPage() {
          PageFactory.initElements(new AppiumFieldDecorator(MDriver.getMDriver()),this);

     }

     @AndroidFindBy(id = "com.etsy.android:id/clg_text_input")
     public WebElement email;


     @AndroidFindBy(id = "com.etsy.android:id/sign_in_button_email")
     public WebElement continuebutton;


     @AndroidFindBy(id = "com.etsy.android:id/clg_text_input")
     public WebElement ;





}
