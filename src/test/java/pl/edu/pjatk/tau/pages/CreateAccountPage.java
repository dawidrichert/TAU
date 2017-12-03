package pl.edu.pjatk.tau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class CreateAccountPage extends PageObject {

    private static final String FIRST_NAME_INPUT_ID = "customer_firstname";
    private static final String LAST_NAME_INPUT_ID = "customer_lastname";
    private static final String PASSWORD_INPUT_ID = "passwd";
    private static final String DAYS_INPUT_ID = "days";
    private static final String MONTH_INPUT_ID = "months";
    private static final String YEAR_INPUT_ID = "years";
    private static final String ADDRESS_1_INPUT_ID = "address1";
    private static final String CITY_INPUT_ID = "city";
    private static final String POSTCODE_INPUT_ID = "postcode";
    private static final String STATE_INPUT_ID = "id_state";
    private static final String COUNTRY_INPUT_ID = "id_country";
    private static final String PHONE_INPUT_ID = "phone_mobile";

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void submitAccountClick () {
        driver.findElement(By.id("submitAccount")).click();
    }

    public boolean checkErrorsValidFields(){
        return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).isDisplayed();
    }

    public void CheckGender(String gender){
        if (Objects.equals(gender, "M")) {
            driver.findElement(By.id("id_gender1")).click();
        } else {
            driver.findElement(By.id("id_gender2")).click();
        }
    }

    public void setFirstName(String firstName) {
        driver.findElement(By.id(FIRST_NAME_INPUT_ID)).click();
        driver.findElement(By.id(FIRST_NAME_INPUT_ID)).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.id(LAST_NAME_INPUT_ID)).click();
        driver.findElement(By.id(LAST_NAME_INPUT_ID)).sendKeys(lastName);
    }

    public void setPassword(String password) {
        driver.findElement(By.id(PASSWORD_INPUT_ID)).click();
        driver.findElement(By.id(PASSWORD_INPUT_ID)).sendKeys(password);
    }

    public void setDateOfBirth(int date, int month, String year) {
        new Select(driver.findElement(By.id(DAYS_INPUT_ID))).selectByIndex(date);
        new Select(driver.findElement(By.id(MONTH_INPUT_ID))).selectByIndex(month);
        new Select(driver.findElement(By.id(YEAR_INPUT_ID))).selectByValue(year);
    }

    public void setStreet(String street) {
        driver.findElement(By.id(ADDRESS_1_INPUT_ID)).click();
        driver.findElement(By.id(ADDRESS_1_INPUT_ID)).sendKeys(street);
    }

    public void setCity(String city) {
        driver.findElement(By.id(CITY_INPUT_ID)).click();
        driver.findElement(By.id(CITY_INPUT_ID)).sendKeys(city);
    }

    public void setState(String state) {
        new Select(driver.findElement(By.id(STATE_INPUT_ID))).selectByVisibleText(state);
    }

    public void setZipCode(String zip) {
        driver.findElement(By.id(POSTCODE_INPUT_ID)).click();
        driver.findElement(By.id(POSTCODE_INPUT_ID)).sendKeys(zip);
    }

    public void setCountry(String country) {
        new Select(driver.findElement(By.id(COUNTRY_INPUT_ID))).selectByVisibleText(country);
    }

    public void setMobilePhone(String number) {
        driver.findElement(By.id(PHONE_INPUT_ID)).click();
        driver.findElement(By.id(PHONE_INPUT_ID)).sendKeys(number);
    }
}