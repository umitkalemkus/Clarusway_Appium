package BDD.stepdefinition;

import BDD.pom.HomePage;
import BDD.pom.ItemPage;
import BDD.pom.RegistrationPage;
import BDD.pom.SeachPage;
import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.hpsf.Array;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.MDriver;
import utilities.MobilUtilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utilities.MDriver.getAndroidDriver;
import static utilities.MDriver.getMDriver;

public class HomeDefinition {

    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();

    ItemPage itemPage = new ItemPage();

    SeachPage seachPage = new SeachPage();

    public Faker faker = new Faker();

    List<String> contentList1 = new ArrayList<>();
    List<String> contentList2 = new ArrayList<>();

    int contentfirstsize;

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
    }

    @And("I select photo from library")
    public void iSelectPhotoFromLibrary() throws IOException {
        String sourceFilePath = "\"C:\\Users\\umitkalemkus\\Pictures\\DCIM\\belt.png\"";
        File sourcefile = new File(sourceFilePath);
        MDriver.getAndroidDriver().pushFile("/sdcard/indirilenler/belt.jpg",sourcefile);
        itemPage.watchButton.click();




    }



    @Then("I verify the results related to my photo")
    public void iVerifyTheResultsRelatedToMyPhoto() {
        List<WebElement> contentOfSearchListTitle = seachPage.contentOfSearchListTitle;
        List<String> titleText = new ArrayList<>();
        for (int i = 0; i < contentOfSearchListTitle.size(); i++) {
            titleText.add(contentOfSearchListTitle.get(i).getText());
            System.out.println(contentOfSearchListTitle.get(i).getText());

        }

        int countOfItem =0;
        for (int i = 0; i < titleText.size(); i++) {
            if (titleText.get(i).toLowerCase().contains("belt"))
                countOfItem = countOfItem + 1;


        }
        System.out.println(countOfItem);

       Assert.assertTrue(countOfItem>2);

    }

    @Given("I collect current total content number")
    public void iCollectCurrentTotalContentNumber() {
        int contentfirstsize = homePage.contentList.size();
        System.out.println("content1 size = " + contentfirstsize);

    }

    @When("I scroll down")
    public void iScrollDown() {
        MobilUtilities.scrollDown();
       // MobilUtilities.scrollDownToElement(By.xpath("//*[@content-desc='Comfortwear ']"));




    }

    @Then("I verify total content number increased")
    public void iVerifyTotalContentNumberIncreased() {
        int contentsecondsize = homePage.contentList.size();
        System.out.println("content2 size = "+contentsecondsize);

        Assert.assertTrue(contentsecondsize>contentfirstsize);

    }

    @Given("Add item in Set list")
    public void addItemInSetList() {

        for (int j = 0; j < 3; j++) {
            Set<String> totalContent =new HashSet<>();
            List<WebElement> contents = homePage.contentList;
            List<String> myTextcontents = new ArrayList<>();
            for (int i = 0; i <contents.size() ; i++) {
                myTextcontents.add(contents.get(i).getAttribute("content-desc"));
            }
            totalContent.addAll(myTextcontents);
            System.out.println("totalContent = " + totalContent);
            MobilUtilities.scrollDown();

            
        }
    }



    @Given("I find all homepage content list")
    public void iFindAllHomepageContentList() {
        List<WebElement> contents = homePage.contentList;
        List<String> myContentList = new ArrayList<>();
        for (int i = 0; i <contents.size() ; i++) {
            myContentList.add(contents.get(i).getAttribute("content-desc"));

        }
        System.out.println(myContentList);
    }

    @When("I search {string} item")
    public void iSearchItem(String itemName) {
        homePage.searchBox.click();
        homePage.searchBox.sendKeys(itemName);
        getAndroidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @And("I click on first item")
    public void iClickOnFirstItem() {
        homePage.contentList2.get(0).click();
    }


    @And("I scroll down to the Add to cart button")
    public void iScrollDownToTheAddToCartButton() {
        MobilUtilities.scrollDownToElement(By.id("com.etsy.android:id/button_add_to_cart_text_switcher"));

    }


    @And("I select random options, if available, for the item")
    public void iSelectRandomOptionsIfAvailableForTheItem() {
        int sizeOfoptions= itemPage.optionsList.size();
        for (int i = 0; i <sizeOfoptions ; i++) {
            itemPage.optionsList.get(i).click();
            itemPage.optionsItemLength.get(0).click();

        }
    }

    @When("I click on the Add to cart button")
    public void iClickOnTheAddToCartButton() {
        itemPage.addToCard.click();

    }

    @Then("I verify that the item has been added to my basket")
    public void iVerifyThatTheItemHasBeenAddedToMyBasket() {

        String text = homePage.basketItemNumber.getAttribute("content-desc");
        System.out.println("text = " + text);






    }

    @Test
    public void testName3(){
        String test ="Cart tab, 5 of 5, 1 new notification";
      String replace =  test.split(",")[2].replace("new notification","").trim();
        System.out.println(replace);




    }

}