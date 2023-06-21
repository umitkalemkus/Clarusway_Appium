package BDD.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs {


    @Given("test1")
    public void test1() {
        System.out.println("Hello World ");
    }
    @When("test2")
    public void test2() {
        System.out.println("Sampiyon Galatasaray");
       
    }


}
