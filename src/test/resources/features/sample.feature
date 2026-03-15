@smoke @calculation
Feature: Restassured validation

  @addition
  Scenario: Add two numbers
    Given I have two numbers 5 and 3
    When I add the numbers
    Then the result should be 8

  @api @restassured
  Scenario: Calling API end points for restAssured
    Given call API endpoint
    When validating rating count should be 120