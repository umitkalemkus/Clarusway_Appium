package BDD.stepdefinition;

import BDD.pom.HomePage;
import BDD.pom.RegistrationPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.MDriver;

import static utilities.MDriver.getMDriver;

public class Registraton  {

    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
    public Faker faker = new Faker();

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {



    }

    @When("I enter a valid email")
    public void iEnterAValidEmail() {
    registrationPage.email.sendKeys(faker.internet().emailAddress());




    }

    @And("I click on the continue button")
    public void iClickOnTheContinueButton() {
        registrationPage.continuebutton.click();
    }

    @When("I enter valid firstName and password")
    public void iEnterValidFirstNameAndPassword() {
        registrationPage.firstname.sendKeys(faker.name().firstName());
        registrationPage.password.sendKeys(faker.internet().password());




    }

    @And("I click on register button")
    public void iClickOnRegisterButton() {
        registrationPage.registrationButton.click();
    }

    @Then("I should be on home page")
    public void iShouldBeOnHomePage(){
        WebDriverWait wait = new WebDriverWait(MDriver.getMDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(homePage.allowButton)).click(); //homePage.allowButton.click();
        homePage.maybelater.click();
        boolean displayed = homePage.homeIconList.get(0).isDisplayed();



      /*  int size = homePage.homeIconList.size(); // ctrl alt V ye basarsaniz direk karsindaki (integer string (hangi return tipi)otomatik cikiyor)
        System.out.println("size = " + size);
        Assert.assertTrue(size==1);
        Assert.assertEquals(1,size);*/
        // inspector ile xpath  islem yaparken
        //tek / ilk direkt çocuğu
        // bütün torunları ve çocukları
        //*[@content-desc='Similar items on Etsy ']/..//androidx.cardview.widget.CardView
        //Yan tarafa tekrar inspect ile dosyayi acacaksin dom da  ararken inspectorde cikiyor.


         //Ornek  Parent-child iliskisi
        //*[@content-desc="Similar items on Etsy"] kendisi
        //*[@content-desc="Similar items on Etsy "]/..  -> parentina git

                                                    //parent                     //child
        //*[@content-desc="Similar items on Etsy "]/../android.widget.FrameLayout//androidx.cardview.widget.CardView





    }


    @Test
    public void test5(){
     int    


    }

}
