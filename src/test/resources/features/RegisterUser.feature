@registerFeature
Feature: Register User

  Scenario: Register a new User
    Given User is on the default page
    When User navigates to the register page
    Then User should be able to register successfully
    And Logon with the new User
    Then User should be able to see the logout button

    