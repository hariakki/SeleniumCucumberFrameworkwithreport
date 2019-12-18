@Hema
Feature: As an user , I should be able to navigate to the HEMA website and be able to add product(s) to the cart


  Background:
    Given Browser is opened and user is navigated to application url

  Scenario: verify valid registered user is able to sign-in and sign-out on the hema web application
    When user clicks on Sign-In Button
    Then user should be navigated to page with title "my HEMA"
    When user login with below credentials:
    |asfasf@asdf.com|Asdf@1234|
    Then logged in screen should be displayed
    When user clicks on Sign-out under myHema dropdown
    Then logged out homepage should be displayed

  Scenario: verify new user is able to register on the hema web application
    When user clicks on Sign-In Button
    Then user should be navigated to page with title "my HEMA"
    When user enters valid email address for registration and click on continue
    Then user should be navigated to page with title "register"
    When user fill in registration form and click on Sign-up
    |Mr|Jason|Roy|Address|post|Amsterdam|Asdf@1234|
    Then logged in user details screen should be displayed

  Scenario: verify registered user is able to add product to cart
    When user clicks on Sign-In Button
    Then user should be navigated to page with title "my HEMA"
    When user login with below credentials:
      |asfasf@asdf.com|Asdf@1234|
    Then logged in screen should be displayed
    When user search for product "stamp set" on homepage
    And user selects item number "2" from the result list
    And selects quantity "1"
    And add the product to basket
    Then mini shopping cart should be displayed
    When user clicks on view basket in mini cart
    Then user should be navigated to page with title "Shopping basket - HEMA"
    And the selected item should be present in shopping basket

  Scenario: verify non-registered user is able to add product to cart
    When user search for product "stamp set" on homepage
    And user selects item number "2" from the result list
    And selects quantity "1"
    And add the product to basket
    Then mini shopping cart should be displayed
    When user clicks on view basket in mini cart
    Then user should be navigated to page with title "Shopping basket - HEMA"
    And the selected item should be present in shopping basket
