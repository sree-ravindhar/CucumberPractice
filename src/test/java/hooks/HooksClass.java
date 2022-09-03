package hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utilities.LoadProperties;

import java.io.IOException;

public class HooksClass extends BaseClass {


    @Before
    public void launchBrowser() throws IOException {

        setDriver("chrome");
        LoadProperties.loadProperties();

    }

    @AfterStep
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }

    }

    @After
    public void closeDriver() {
        getDriver().close();
    }


}
