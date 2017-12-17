package pl.edu.pjatk.tau.stepDefinitions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pl.edu.pjatk.tau.pages.CreateAccountPage;
import pl.edu.pjatk.tau.pages.HomePage;
import pl.edu.pjatk.tau.pages.LoginPage;
import pl.edu.pjatk.tau.pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

abstract class AbstractSteps {

    private static WebDriver driver;
    private static final String PHANTOM_JS_DRIVER_PATH = "src/test/resources/phantomjs";

    static LoginPage loginPage;
    static MyAccountPage myAccountPage;
    static HomePage homePage;
    static CreateAccountPage createAcc;

    void beforeScenario() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PHANTOM_JS_DRIVER_PATH
        );
        driver = new PhantomJSDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().deleteAllCookies();

        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        createAcc = new CreateAccountPage(driver);
    }

    void afterScenario() {
        driver.manage().deleteAllCookies();
    }
}
