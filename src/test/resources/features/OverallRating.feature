@overallRatingFeature
Feature: Overall rating page features

  Scenario Outline: Overall rating - Navigate to a different make
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the overall rating page
    And User selects a "<make>"
    Then User should be able to navigate to the "<makeName>" page
    Examples:
    |username        |password   |make         |makeName          |
    |TestWestpac1    |Password@1 |'Alfa Romeo' |'Alfa Romeo'      |


   Scenario Outline: Overall rating - Navigate to different model
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the overall rating page
    And User selects a "<car>"
    Then User should be able to navigate to the "<carName>" page
    Examples:
    |username         |password   |car           |carName                    |
    |TestWestpac1     |Password@1 |'Diablo'      |'Guilia Quadrifoglio'      |
    |TestWestpac1     |Password@1 |'Lamborghini' |'Diablo'                   |
    |TestWestpac1     |Password@1 |'Rally 037'   |'Lancia 037 Stradale'      |

   Scenario Outline: Overall rating - Author should be displayed after commenting
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the overall rating page
    And User selects a "<car>"
    Then Author name should be updated
    Examples:
    |username        |password   |car         |carName                    |
    |TestWestpac1    |Password@1 |'Diablo'    |'Diablo'                   |