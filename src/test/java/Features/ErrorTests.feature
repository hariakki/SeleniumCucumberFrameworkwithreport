@Hema
Feature: As an user , I should be displayed with proper error message according to necessary action.

  Background:
    Given Browser is opened and user is navigated to application url

  Scenario Outline: verify user is not able to login with invalid credential and getting proper error message
    When user clicks on Sign-In Button
    Then user should be navigated to page with title "my HEMA"
    When user login with below credentials:
      | <email> | <password> |
    Then error message "<errorMsg>" should be displayed
    Examples:
      | email     | password  | errorMsg                               |
      | qwer@.com | Asdf@1234 | Sorry we don't recognise your details. |
      |           | Asdf@1234 | Sorry we don't recognise your details. |

  Scenario Outline: verify user is not able to navigate to registration form without giving valid email id and getting proper error message
    When user clicks on Sign-In Button
    Then user should be navigated to page with title "my HEMA"
    When user enters "<emailAddress>" for registration and click on continue
    Then error message "<errorMsg>" should be displayed for registration
    Examples:
      | emailAddress | errorMsg                    |
      |              | enter a valid value         |
      | aswd@.com    | e-mail address is not valid |

  Scenario Outline: verify user is not able to register without filling all mandatory field and getting proper error message
    When user clicks on Sign-In Button
    Then user should be navigated to page with title "my HEMA"
    When user enters valid email address for registration and click on continue
    Then user should be navigated to page with title "register"
    When user fill in registration form and click on Sign-up
      | <addressed> | <firstName> | <lastName> | <address1> | <postCode> | <city> | <password> |
    Then error message "<errorMsg>" should be displayed for registration form
    Examples:
      | addressed | firstName | lastName | address1 | postCode | city      | password  | errorMsg                                                  |
      | Mr        |           | Roy      | Address  | post     | Amsterdam | Asdf@1234 | some information below is incomplete or must be corrected |
      | Mr        | Jason     |          | Address  | post     | Amsterdam | Asdf@1234 | some information below is incomplete or must be corrected |
      | Mr        | Jason     | Roy      |          | post     | Amsterdam | Asdf@1234 | some information below is incomplete or must be corrected |
      | Mr        | Jason     | Roy      | Address  |          | Amsterdam | Asdf@1234 | some information below is incomplete or must be corrected |
      | Mr        | Jason     | Roy      | Address  | post     |           | Asdf@1234 | some information below is incomplete or must be corrected |