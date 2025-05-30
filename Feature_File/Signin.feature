Feature: Amazon Sign In and Add to Cart

Scenario: Sign in and add a laptop to the cart
  Given I navigate to Amazon sign-in page
  When I sign in with email and password
  And I search for Laptop and add first item to cart
  Then The product should be added to the cart