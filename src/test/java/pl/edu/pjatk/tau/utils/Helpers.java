package pl.edu.pjatk.tau.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class Helpers {

    private static final String SCREENSHOTS_PATH = "screenshots/";
    private static final String SCREENSHOTS_EXTENSION = ".png";

    public static void takeScreenshot(WebDriver driver, WebElement webElement, String fileName) throws IOException {
        if (driver instanceof TakesScreenshot) {
            new Actions(driver).moveToElement(webElement).build().perform();
            File f = ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f,
                    new File(SCREENSHOTS_PATH + fileName + SCREENSHOTS_EXTENSION));
        }
    }
}
