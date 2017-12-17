package pl.edu.pjatk.tau.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps extends AbstractSteps {

    @Before
    public void setUpBrowser() {
        super.beforeScenario();
    }

    @After
    public void cleanUp() {
        super.afterScenario();
    }

    @Given("^user is on the Login Page$")
    public void userIsOnTheLoginPage() {
        loginPage.navigate();
    }

    @When("^user enters email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_use_login_and_password_in_form(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @And("^user clicks Sign In button$")
    public void userClicksSignInButton() {
        loginPage.loginButtonClick();
    }

    @Then("^'Authentication' page is displayed$")
    public void authenticationPageIsDisplayed() {
        Assert.assertTrue(loginPage.isDisplayed());
    }

    @Then("^'My Account' page is displayed$")
    public void myAccountPageIsDisplayed() {
        Assert.assertTrue(myAccountPage.isDisplayed());
    }

    @Then("^\"([^\"]*)\" alert is displayed$")
    public void alertIsDisplayed(String message) {
        Assert.assertTrue(loginPage.alertMessageIsDisplayed(message));
    }
}