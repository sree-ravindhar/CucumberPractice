
Feature: Google Search
  @TestRun
  Scenario: Verify wheather user is able to search
    Given User is going to Launch to App
    When Type "Sree Ravindhar" in Search
    And Enter click to Search
    Then Verify the related results is shown