package pl.edu.pjatk.tau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pl.edu.pjatk.tau.TestScenarios.APP_URL;

public class LoginPage extends PageObject {

    private static final PageElement CREATE_ACCOUNT_BUTTON = new PageElement("SubmitCreate");
    private static final PageElement SUBMIT_LOGIN_BUTTON = new PageElement("SubmitLogin");
    private static final PageElement PAGE_HEADER = new PageElement(null, "//h1[contains(text(), 'Authentication')]");
    private static final String EMAIL_CREATE_INPUT_ID = "email_create";
    private static final String EMAIL_INPUT_ID = "email";
    private static final String PASSWORD_INPUT_ID = "passwd";

    public static final String PAGE_URL = APP_URL + "?controller=authentication&back=my-account";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailAddress(String email) {
        driver.findElement(By.id(EMAIL_CREATE_INPUT_ID)).sendKeys(email);
    }

    public void clickCreateAccountButton() {
        clickOn(CREATE_ACCOUNT_BUTTON);
    }

    public void setEmail(String email){
        driver.findElement(By.id(EMAIL_INPUT_ID)).clear();
        driver.findElement(By.id(EMAIL_INPUT_ID)).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(By.id(PASSWORD_INPUT_ID)).clear();
        driver.findElement(By.id(PASSWORD_INPUT_ID)).sendKeys(password);
    }

    public void loginButtonClick() {
        clickOn(SUBMIT_LOGIN_BUTTON);
    }

    public void navigate() {
        driver.get(PAGE_URL);
    }

    public boolean alertMessageIsDisplayed(String message) {
        return driver.findElement(By.xpath("//div[contains(@class, 'alert')]//li[contains(text(), '" + message + "')]")).isDisplayed();
    }

    public boolean isDisplayed() {
        return findElement(PAGE_HEADER).isDisplayed();
    }
}