package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static  void setDriver(String browser) {
       if (browser.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--start-maximized");
           driver.set(new ChromeDriver(options));
       } else if (browser.equalsIgnoreCase("edge")) {
           WebDriverManager.edgedriver().setup();
           driver.set(new EdgeDriver());

       }

    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void closeBrowser()
    {
        driver.get().close();
        driver.remove();
    }

    public static void takeScreenShot(String path) throws IOException {

        try {
            TakesScreenshot a = (TakesScreenshot) getDriver();
            File screenshotAs = a.getScreenshotAs(OutputType.FILE);
            File b = new File(path);
            FileUtils.copyFile(screenshotAs, b);
        } catch (WebDriverException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static WebElement findElement(String Option, String Value) {

        try {
            if (Option.equalsIgnoreCase("id")) {
                WebElement id = getDriver().findElement(By.id(Value));
                return id;
            } else if (Option.equalsIgnoreCase("xpath")) {
                WebElement xpath = getDriver().findElement(By.xpath(Value));
                return xpath;
            } else if (Option.equalsIgnoreCase("css")) {
                WebElement css = getDriver().findElement(By.cssSelector(Value));
                return css;
            } else if (Option.equalsIgnoreCase("name")) {
                WebElement name = getDriver().findElement(By.name(Value));
                return name;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static void getUrl(String url) {

        try {
            getDriver().get(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void dropDown(WebElement element, String option, String value) {

        try {
            Select a = new Select(element);

            if (option.equalsIgnoreCase("index")) {
                int parseInt = Integer.parseInt(value);
                a.selectByIndex(parseInt);

            } else if (option.equalsIgnoreCase("value")) {

                a.selectByValue(value);

            } else if (option.equalsIgnoreCase("text")) {

                a.selectByVisibleText(value);

            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void sendkeyss(WebElement element, String value) {

        try {
            element.sendKeys(value);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void clickk(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void mouseActions(WebElement element, String option) {
        try {
            Actions a = new Actions(getDriver());
            if (option.equalsIgnoreCase("move")) {
                a.moveToElement(element).perform();
            } else if (option.equalsIgnoreCase("rightclick")) {
                a.contextClick(element).perform();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void javaScriptExecute(WebElement element, String option) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            if (option.equalsIgnoreCase("scrollelement")) {
                js.executeScript("arguments[0].scrollIntoView();", element);
            } else if (option.equalsIgnoreCase("highlight")) {
                js.executeScript("arguments[0].style.border='3px dotted blue'", element);
            } else if (option.equalsIgnoreCase("click")) {

                js.executeScript("arguments[0].click();", element);

            } else if (option.equalsIgnoreCase("scrollpixel")) {
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            } else if (option.equalsIgnoreCase("idclick")) {


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTextElement(WebElement element){

        try {
            String text = element.getText();
            System.out.println(text);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}