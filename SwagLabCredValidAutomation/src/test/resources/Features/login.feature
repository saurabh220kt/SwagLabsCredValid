#Author: saurabh220kt@gmail.com

Feature: Automation for saucedemo website

  Scenario Outline: Login features for saucedemo website
    Given User is on login page
    When User enter valid "<username>" and "<password>"
    And Clicks on login button
    Then User is navigated to the saucedemo website
    And Close the browser

    Examples: 
      | Username  							| Password  				|
      | standard_user 		      |	  secret_sauce    |
      | problem_user            |   secret_sauce    |
      | performance_glitch_user |   secret_sauce    |
