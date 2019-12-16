@TagTestReport
Feature: Test create computer Action


  Background:
    Given Browser is opened and user is navigated to application url

  Scenario: user creates a computer and verify the computer is successfully created
    When user adds computer with data
    |Home basic	 |Sony	       |2019-09-15     |
    And verify the computer in the Filter list "Home basic"
    Then added computer should be available in the list "15 2019"