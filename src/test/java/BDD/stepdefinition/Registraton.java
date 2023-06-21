package BDD.stepdefinition;

import BDD.pom.RegistrationPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Registraton  {

    RegistrationPage registrationPage = new RegistrationPage();
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



    }
}
