Feature: Register
  As a user I want to be able to create new account in the system

  Scenario Outline: Create Account - Happy Path
    Given user is on the 'Home' page
    When user clicks 'Sign In' button on top menu
    Then 'Authentication' page is displayed
    And user enters email address in 'Create An Account' section
    And user clicks 'Create Account' button
    Then 'Create Account' page is displayed
    And user fills the required fields <firstName>, <lastName>, <password>, <city>, <street>
    And user clicks 'Register' button
    Then 'My Account' page is displayed
    Examples:
      | firstName | lastName   | password          | city     | street      |
      | "Jan"     | "Kowalski" | "SuperPassword1!" | "Gdansk" | "Sloneczna" |
      | "Adam"    | "Nowak"    | "password12@"     | "Warsaw" | "Swietna"   |