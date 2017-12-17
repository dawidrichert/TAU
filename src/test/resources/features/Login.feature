Feature: Login
  As a user I want to be able to login to the system

  Scenario Outline: Successful login with valid data
    Given user is on the Login Page
    When user enters email <email> and password <password>
    And user clicks Sign In button
    Then 'My Account' page is displayed
    Examples:
      | email                  | password      |
      | "emailExampleAs@wp.pl" | "password123" |
      | "test@testtest.pl"     | "password"    |
      | "jaskier@jaskier.pl"   | "supertajne"  |

  Scenario Outline: Fail login with invalid data
    Given user is on the Login Page
    When user enters email <email> and password <password>
    And user clicks Sign In button
    Then "Authentication failed." alert is displayed
    Examples:
      | email                  | password         |
      | "dask123jkncc@test.pl" | "cxczxlcmasdjak" |
      | "vxcvx@321909cx.uk"    | "vxcvx"          |
      | "kak@k.cz"             | "czczcz"         |