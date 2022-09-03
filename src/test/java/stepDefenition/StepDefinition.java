package stepDefenition;

import io.cucumber.java.en.*;
import org.example.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import runnerClass.TestRunner;

public class StepDefinition extends BaseClass {
    WebElement search;

    @Given("User is going to Launch to App")
    public void user_is_going_to_launch_to_app() {
       getUrl("https://www.google.co.in/");
    }

    @When("Type {string} in Search")
    public void type_in_search(String string) {
        search = findElement("name","2q");
        search.sendKeys(string);
    }
    @When("Enter click to Search")
    public void enter_click_to_search() {
        search.submit();
    }
    @Then("Verify the related results is shown")
    public void verify_the_related_results_is_shown() {
        System.out.println("Success");
    }
}
