package BDD.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                plugin = {
                        "json:target/cucumber.json",
                        "html:target/cucumber-report.html",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber"
                },
                features = "src/test/resources",
                glue = "BDD/stepdefinition"
                //tags = "@Test"
        )
public class Cucumber_Runner extends AbstractTestNGCucumberTests {

// Feature dosyasi icin resoursesin uzerde saga tikla ve content rootunu al ve feature yerine yapistir
// Glue calistirmak icin saga steodefinitionda saga tikla ve   Path from source root u glue yapistir.
}
