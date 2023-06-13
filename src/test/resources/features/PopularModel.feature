@popularModelFeature
Feature: Popular Model page features

  Scenario: Popular Model page - Vote and comment
    Given User is on the default page
    When User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    And User navigates to the popular model page
    Then User is able to vote
    And comment should be displayed on the page
    |username        |password    |
    |TestWestpac1    |Password@1  |