
@tag
Feature: User Registration
  I want to use this template for my feature file

  @tag1
  Scenario Outline: User should be able to sign up with valid details
    Given the user is on the registration page
    When the user enters valid details "<fname>" "<lname>" "<email>" "<password>" "<cnfpassword>"
    Then the user should be successfully registered
    
 
    Examples: 
      | fname  | lname | email  | password | cnfpassword |
      | Simran | Karmani | karmani.simrn@gmail.com | Testtest@123 | Testtest@123 |
      | Test | User | test.user@gmail.com | Testpass@123 | Testpass@1234 |
      
