Feature: Test the data table
  Scenario: This is used to test the feature
    Given SetUp enter URL
    When Try data Table
      | sreeravindhar | sangeetha |
      | Data          | Table     |
    Then Verify the user is able to get the above data