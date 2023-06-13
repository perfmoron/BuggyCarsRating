@popularMakeFeature
Feature: Popular Make page features

  Scenario Outline: Popular Make page - Navigate to car page
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the popular make page
    And User selects a "<car>"
    Then User should be able to navigate to the "<car>" page
    Examples:
    |username        |password    |car         |
    |TestWestpac1    |Password@1  |'Lamborghini Diablo'    |
    |TestWestpac1    |Password@1  |'Alfa Romeo Mito'    |
    |TestWestpac1    |Password@1  |'Alfa Romeo Giulietta'  |

  Scenario Outline: Popular Make page - Traverse to different pages
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the popular make page
    Then User should be able to navigate to other pages
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