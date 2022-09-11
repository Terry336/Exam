Feature: Check customers number

  Scenario: Adding and removing customer
    Given user navigates to the page
    When user clicks on button Bank Manager Login
    And user clicks on button Customers
    And user verifies the number of customers in the table
    And user deletes one of the customers
    Then verifies that the number of customers is minus one

