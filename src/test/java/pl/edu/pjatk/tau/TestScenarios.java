package pl.edu.pjatk.tau;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pl.edu.pjatk.tau.pages.CreateAccountPage;
import pl.edu.pjatk.tau.pages.HomePage;
import pl.edu.pjatk.tau.pages.LoginPage;
import pl.edu.pjatk.tau.utils.Helpers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestScenarios {
    private static WebDriver driver;
    private HomePage homePage = new HomePage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private CreateAccountPage createAccount = new CreateAccountPage(driver);

    private static final String PHANTOM_JS_DRIVER_PATH = "src/test/resources/phantomjs";
    private static final int BROWSER_WIDTH = 1920;
    private static final int BROWSER_HEIGHT = 1080;
    private static final int WAIT_SECONDS = 10;
    private static final String EMAIL_POSTFIX = "@test.test";

    public static final String APP_URL = "http://automationpractice.com/index.php";

    @BeforeClass
    public static void driverSetup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PHANTOM_JS_DRIVER_PATH
        );
        driver = new PhantomJSDriver(caps);
        driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(BROWSER_WIDTH, BROWSER_HEIGHT));
    }

    @Before
    public void before() {
    }

    @Test
    public void shouldContainsSpecificElementsWhenGoToHomePage() {
        homePage.navigate();

        assertTrue(driver.findElement(By.cssSelector("#homeslider > li:nth-child(3) > div")).isEnabled());
        assertTrue(driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")).isDisplayed());
    }

    @Test
    public void shouldShowProperProductsWhenUserClicksBestSellersButton() {
        HomePage homePage = new HomePage(driver);

        homePage.navigate();
        homePage.clickBestSellersButton();
        homePage.isElementDisplayed("Printed Chiffon Dress");

        assertEquals(7, homePage.getNumberOfProducts());
        assertEquals(7, homePage.getNumberOfDisplayedProducts());
    }

    @Test
    public void shouldShowMenuWith3ElementsWhenUserMovesMouseToDressesSection() throws IOException {
        homePage.navigate();

        WebElement dresses = homePage.goToDressesLocation();
        Helpers.takeScreenshot(driver, dresses, "screenshot1.png");

        assertEquals(3, homePage.getDresses().size());
    }

    @Test
    public void shouldNavigateUserToProperPageWhenUserVerifyAddress() {
        homePage.navigate();
        homePage.goToLoginPage();
        assertEquals(LoginPage.PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void shouldShowErrorsOnRegisterPageWhenUserEntersInvalidData() {
        homePage.navigate();
        homePage.goToLoginPage();
        loginPage.setEmailAddress(homePage.randomString(6) + EMAIL_POSTFIX);
        loginPage.clickCreateAccountButton();
        createAccount.clickRegisterButton();

        assertTrue(createAccount.checkErrorsValidFields());
    }

    @Test
    public void shouldSuccessfullyRegisterAccount() {
        loginPage.navigate();

        loginPage.setEmailAddress(homePage.randomString(6) + EMAIL_POSTFIX);
        loginPage.clickCreateAccountButton();
        createAccount.checkGender("M");
        createAccount.setFirstName("John");
        createAccount.setLastName("Smith");
        createAccount.setPassword("password123");
        createAccount.setDateOfBirth(5, 8, "1994");
        createAccount.setStreet("Sunny 1");
        createAccount.setCountry("United States");
        createAccount.setCity("Los Angeles");
        createAccount.setState("Alabama");
        createAccount.setMobilePhone("111222333");
        createAccount.setZipCode("12345");
        createAccount.clickRegisterButton();

        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).isDisplayed();//sign out button
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click();
    }

    @Test
    public void shouldSuccessfullyLoginToAccount() {
        loginPage.navigate();
        loginPage.setEmail("emailEsadasdleAs" + EMAIL_POSTFIX);
        loginPage.setPassword("pasdsadword123");
        loginPage.loginButtonClick();
        //valid
        loginPage.setEmail("emailExampleAs" + EMAIL_POSTFIX);
        loginPage.setPassword("password123");
        loginPage.loginButtonClick();

        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a")).click(); //sign out button
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}