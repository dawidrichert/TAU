package pl.edu.pjatk.tau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObject {

    private static final PageElement SIGN_IN_MENU_BUTTON = new PageElement(null, "//a[contains(text(), 'Sign in')]");

    private static final String PAGE_URL = "http://automationpractice.com/index.php";

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickBestSellersButton() {
        driver.findElement(By.className("blockbestsellers")).click();
    }

    public void clickSignInMenuButton() {
        clickOn(SIGN_IN_MENU_BUTTON);
    }

    public boolean isElementDisplayed(String linkText) {
        driver.findElement(By.partialLinkText(linkText)).getText();
        try {
            driver.findElement(By.partialLinkText(linkText));
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public int getNumberOfProducts() {
        return getProducts().size();
    }

    public int getNumberOfDisplayedProducts() {
        return getDisplayedProducts().size();
    }

    public WebElement goToDressesLocation() throws IOException {
        WebElement Dresses =
                driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(Dresses).build().perform();

        return Dresses;
    }

    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public List<WebElement> getDresses() {
        return driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul")).findElements(By.tagName("li"));
    }

    public void goToLoginPage() {
        driver.findElement(By.className("login")).click();
    }

    public void navigate() {
        driver.get(PAGE_URL);
    }

    private List<WebElement> getProducts() {
        return driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li"));
    }

    private List<WebElement> getDisplayedProducts() {
        List<WebElement> listIsDisplayed = new ArrayList<>();
        List<WebElement> list = new ArrayList<>();
        list.addAll(driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li")));
        for (int i = 0; i < list.size(); i++) {
            if (driver.findElement(By.cssSelector("#blockbestsellers")).findElement(By.tagName("li")).isDisplayed())
                listIsDisplayed.add(driver.findElement(By.cssSelector("#blockbestsellers")).findElement(By.tagName("li")));
        }
        return listIsDisplayed;
    }
}