Feature: Amazon Registration

Scenario: User registers on Amazon
  Given I navigate to Amazon registration page
  When I fill the registration form with name "Veeru", mobile "7428730894", email "jdjbcdhc@gmail.com", and password "123P@09"
  Then I should be on OTP verification page