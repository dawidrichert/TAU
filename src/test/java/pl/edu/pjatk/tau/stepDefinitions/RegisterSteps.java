package pl.edu.pjatk.tau.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterSteps extends AbstractSteps {

    @Before
    public void setUpBrowser() {
        super.beforeScenario();
    }

    @After
    public void cleanUp() {
        super.afterScenario();
    }

    @When("^user clicks 'Sign In' button on top menu$")
    public void userClicksSignInButtonOnTopMenu() {
        homePage.clickSignInMenuButton();
    }

    @And("^user clicks 'Register' button$")
    public void userClicksRegisterButton() {
        createAcc.clickRegisterButton();
    }

    @And("^user is on the 'Home' page$")
    public void userIsOnTheHomePage() {
        homePage.navigate();
    }

    @Given("^user enters email address in 'Create An Account' section$")
    public void userEntersEmailAddressInCreateAnAccountSection() {
        loginPage.setEmailAddress(homePage.randomString(8)+"@wp.pl");
    }

    @And("^user clicks 'Create Account' button$")
    public void userClicksCreateAccountButton() {
        loginPage.clickCreateAccountButton();
    }

    @And("^user fills the required fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userFillsTheRequiredFields(String firstName, String lastName, String password, String city, String street) {
        createAcc.setPassword(password);
        createAcc.checkGender("M");
        createAcc.setFirstName(firstName);
        createAcc.setLastName(lastName);
        createAcc.setDateOfBirth(25, 10, "1994");
        createAcc.setStreet(street);
        createAcc.setCountry("United States");
        createAcc.setCity(city);
        createAcc.setState("Alabama");
        createAcc.setMobilePhone("505050505");
        createAcc.setZipCode("00000");
    }

    @Then("^'Create Account' page is displayed$")
    public void createAccountPageIsDisplayed() {
        Assert.assertTrue(createAcc.isDisplayed());
    }
}