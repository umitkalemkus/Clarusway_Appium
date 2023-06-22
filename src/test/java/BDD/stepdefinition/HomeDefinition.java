package BDD.stepdefinition;

import BDD.pom.HomePage;
import BDD.pom.RegistrationPage;
import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import utilities.MDriver;

import java.util.ArrayList;
import java.util.List;

public class HomeDefinition {

    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();

    List<WebElement> contentList1=new ArrayList<>();

    public static TouchAction touchAction = new TouchAction(MDriver.getMDriver());
    @When("I click on continue as guest button")
    public void iClickOnContinueAsGuestButton() {

    registrationPage.ContinueAsGuest.click();

    }

    @And("I click on maybe later button")
    public void iClickOnMaybeLaterButton() {
        homePage.maybelater.click();

    }

    @When("I refresh page")
    public void iRefreshPage() {
        touchAction.press(PointOption.point(500,500)).waitAction().moveTo(PointOption.point(500,900)).release().perform();



    }
}
