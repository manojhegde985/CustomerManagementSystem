#Author
#Date
#Description
@SmokeScenario
Feature: feature to test login functionality

  @SmokeTest
  Scenario: check the customer details
    Given go to postman api
    When enter cid cname city and email using post method
    And clicks on send button
    Then we get the customer details

  Scenario Outline: check the customer details
    Given go to postman api
    When I enter <cid> <cname> <city> and <email>
    And clicks on send button
    Then we get the customer details

    Examples: 
      | cid | cname | city   | email         |
      |   1 | john  | mumbai | john@gmailcom |
      |   2 | raj   | pune   | raj@gmail.com |
