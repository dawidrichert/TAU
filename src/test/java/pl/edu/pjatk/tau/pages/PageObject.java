package pl.edu.pjatk.tau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class PageObject {
    WebDriver driver;

    PageObject(WebDriver driver) {
        this.driver = driver;
    }

    void clickOn(PageElement pageElement) {
        findElement(pageElement).click();
    }

    private WebElement findElement(PageElement pageElement) {
        if (pageElement.getId() != null) {
            return driver.findElement(By.id(pageElement.getId()));
        }
        if (pageElement.getXpath() != null) {
            return driver.findElement(By.xpath(pageElement.getId()));
        }
        return null;
    }
}
