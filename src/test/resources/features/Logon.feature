@loginFeature
Feature: Login/Logout

  Scenario Outline: Successfully Logon to Buggy Cars Rating
    Given User is on the default page
    When User enters logon credentials "<username>" "<password>"
    Then User should be able to see the logout button
    Examples:
    |username        |password  |
    |TestWestpac1    |Password@1 |

  Scenario Outline: Unsuccessful Logon to Buggy Cars Rating
    Given User is on the default page
    When User enters logon credentials "<username>" "<password>"
    Then User should be able to see the error message
    Examples:
    |username           |password  |
    |TestWestpac1       |WrongPassword@123 |
    |TestWestpacX       |Password@1   |
    
