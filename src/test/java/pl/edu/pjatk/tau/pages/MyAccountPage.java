package pl.edu.pjatk.tau.pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageObject {

    private static final PageElement PAGE_HEADER = new PageElement(null, "//h1[contains(text(), 'My account')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return findElement(PAGE_HEADER).isDisplayed();
    }
}
