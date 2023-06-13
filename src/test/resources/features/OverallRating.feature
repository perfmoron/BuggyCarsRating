@overallRatingFeature
Feature: Overall rating page features

  Scenario Outline: Overall rating page - Navigate to a different make
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the overall rating page
    And User selects a Car type
    Then User should be able to navigate to the page
    |username        |password   |
    |TestWestpac1    |Password@1 |

   Scenario Outline: Overall rating page - Author should be displayed after commenting
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the overall rating page
    And User selects a Car model
    Then Author name should be updated
    Examples:
    |username        |password   |
    |TestWestpac1    |Password@1 |

  Scenario Outline: Overall rating page - Navigate to different pages
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the overall rating page
    Then User should be able to navigate to other pages
    Examples:
    |username        |password    |
    |TestWestpac1    |Password@1  |