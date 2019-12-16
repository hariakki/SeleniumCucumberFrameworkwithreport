
@TagTestReport
Feature: Test Edit computer Action

  Background:
    Given Browser is opened and user is navigated to application url

  Scenario: user Edit a computer and verify the computer is successfully created create
    When user Edit introduced date as "1965-08-01" of computer "ARRA"
    Then verify the introduced date has been changed to "01 Aug 1965" of computer "ARRA"