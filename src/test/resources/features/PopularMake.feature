@popularMakeFeature
Feature: Popular Make page features

  Scenario Outline: Popular Make page - Navigate to car page
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the popular make page
    And User selects a Car model
    Then User should be able to navigate to the page
    Examples:
    |username        |password    |
    |TestWestpac1    |Password@1  |

   Scenario Outline: Popular Make page - Navigate back to home page
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the popular make page
    And User clicks the buggy rating link
    Then User should be able to navigate back to the default page
     Examples:
     |username        |password    |
     |TestWestpac1    |Password@1  |