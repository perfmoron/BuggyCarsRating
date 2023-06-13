@profileFeature
Feature: Profile change

  Scenario Outline: Edit profile page of the user
    Given User is on the default page
    And User enters logon credentials "<username>" "<password>"
    And User should be able to see the logout button
    When User navigates to the profile page
    Then User is able to edit his profile
    Examples:
    |username        |password  |
    |TestWestpac1    |Password@1 |