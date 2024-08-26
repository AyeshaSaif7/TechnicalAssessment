Feature: Automated Tests for Web Application

  Background:
    Given I navigate to the home page

  Scenario: Test 1 - Login functionality
    Then I should see the email address input, password input, and login button
    When I enter an email address and password
    And I click the login button


  Scenario: Test 2 - List Group Validation
    Then there should be three values in the listgroup
    And the second list item's value should be "List Item 2"
    And the second list item's badge value should be 6

  Scenario: Test 3 - Dropdown Selection
    Then "Option 1" should be the default selected value in the test 3 div
    When I select "Option 3" from the dropdown

  Scenario: Test 4 - Button State Validation
    Then the first button in the test should be enabled
    And the second button should be disabled

  Scenario: Test 5 - Button Interaction and Validation
    When I wait for the button to appear in the test
    And I click the button
    Then a success message should be displayed
    And the button should be disabled

  Scenario: Test 6 - Table Cell Validation
    When I retrieve the value of the cell at coordinates (2, 2)
    Then the value should be "Ventosanzap"