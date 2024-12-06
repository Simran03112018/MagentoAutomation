
@tag
Feature: User Login
  I want to use this template for my feature file

  @tag1
  Scenario Outline: User should be able to login with valid credentials
    Given the user is on the login page
    When the user enters valid login details "<email>" "<password>"
    Then the user should be logged in successfully


    Examples: 
      | email  | password |
      | karmani.simrn@gmail.com | Testtest@123 |
      | test.user@gmail.com | Testpass@123 |
