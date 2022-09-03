
Feature: This is login feature of SauceDemo
  @TestRun
  Scenario: Verify user is able to login the application
    Given setup and launch the application with valid URL
    When Enter username
    And Enter password
    And Click Login button
    Then Verify the user is abe to login and see the products