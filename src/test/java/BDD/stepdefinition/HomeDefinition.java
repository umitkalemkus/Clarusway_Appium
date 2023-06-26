package BDD.stepdefinition;

import BDD.pom.HomePage;
import BDD.pom.ItemPage;
import BDD.pom.RegistrationPage;
import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.MDriver;

import java.util.ArrayList;
import java.util.List;

import static utilities.MDriver.getMDriver;

public class HomeDefinition {

    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();

    ItemPage itemPage = new ItemPage();

    List<String> contentList1 = new ArrayList<>();
    List<String> contentList2 = new ArrayList<>();

    public static TouchAction touchAction = new TouchAction(getMDriver());

    @When("I click on continue as guest button")
    public void iClickOnContinueAsGuestButton() {

        registrationPage.ContinueAsGuest.click();

    }

    @And("I click on maybe later button")
    public void iClickOnMaybeLaterButton() {
        homePage.maybelater.click();
       /* int size = homePage.homePageContents.size();
        System.out.println("size = " + size);
        WebDriverWait wait1 = new WebDriverWait(MDriver.getMDriver(),4);
        wait1.until(ExpectedConditions.visibilityOf(homePage.homePageContents.get(0)));
        for (int i = 0; i < homePage.homePageContents.size(); i++) {

            contentList1.add(homePage.homePageContents.get(i).getAttribute("content-desc"));
            System.out.println("Content1 = "+ homePage.homePageContents.get(i).getAttribute("content-desc"));*/

            // testDnm.add("garip");
            //System.out.println("testDnm = " + testDnm);
        }




    @When("I refresh page")
    public void iRefreshPage() {
        touchAction.press(PointOption.point(500, 500)).waitAction().moveTo(PointOption.point(500, 900)).release().perform();

    }


    @Then("I verify page content has been updated")
    public void iVerifyPageContentHasBeenUpdated() throws InterruptedException {

        Thread.sleep(3000);
        for (int i = 0; i < homePage.homePageContents.size(); i++) {
            System.out.println("Content2 ="+ homePage.homePageContents.get(i).getAttribute("content-desc"));
            contentList2.add(homePage.homePageContents.get(i).getAttribute("content-desc"));



        }
        System.out.println(contentList1.size());
        contentList1.removeAll(contentList2);
        System.out.println(contentList1.size());
        Assert.assertTrue(contentList1.size()>4);




    }


    @Test
    public void testName(){
        List<String> a1 = new ArrayList<>();
        a1.add("Rukiye");
        a1.add("Akif");
        a1.add("Zeynep");
        a1.add("Harvey");
        System.out.println(a1);

        List<String> a2 = new ArrayList<>();
        a2.add("Rukiye");
        a2.add("Akif");
        a2.add("Zeynep");
        a2.add("Umit");
        System.out.println(a2);

        System.out.println("a1.removeAll(a2) = " + a1.removeAll(a2));  //(a1-a2) demektir.
        System.out.println(a1);


    }


    @And("I handle the presence of the search bar")
    public void iHandleThePresenceOfTheSearchBar() {

        if(homePage.searchBoxList.size()==0){
            homePage.homePageContents.get(0).click();
            itemPage.backButton.click();



        }


    }




    @When("I click on search with image button")
    public void iClickOnSearchWithImageButton() {
        homePage.camIcon.click();

    }

    @And("I click on select an existing photo")
    public void iClickOnSelectAnExistingPhoto() {
        homePage.existingphoto.click();
        Alert alert =getMDriver().switchTo().alert();
        alert.accept();

    }

    @And("I select photo from library")
    public void iSelectPhotoFromLibrary() {
    }
}