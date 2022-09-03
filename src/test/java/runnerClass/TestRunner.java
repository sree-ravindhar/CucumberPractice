package runnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.BaseClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features"},
        glue = {"stepDefenition","hooks"},
        monochrome = true,
        dryRun = false,
        publish = true,
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@TestRun"
)
public class TestRunner {

}
