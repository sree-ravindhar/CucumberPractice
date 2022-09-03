package stepDefenition;

import io.cucumber.java.en.*;
import org.example.BaseClass;
import utilities.Constant;
import utilities.LoadProperties;

public class SauceDemoLogin extends BaseClass {
    @Given("setup and launch the application with valid URL")
    public void setup_and_launch_the_application_with_valid_url() {
        getUrl(Constant.APP_URL);
    }
    @When("Enter username")
    public void enter_username() {
        findElement("css","input[type=text]").sendKeys(Constant.userName);
    }
    @When("Enter password")
    public void enter_password() {
        findElement("css","input.input_error.form_input[type='password']").sendKeys(Constant.passWord);
    }
    @When("Click Login button")
    public void click_login_button() {
        findElement("css",".submit-button.btn_acton").click();
    }
    @Then("Verify the user is abe to login and see the products")
    public void verify_the_user_is_abe_to_login_and_see_the_products() {
        System.out.println("success");
    }

}
