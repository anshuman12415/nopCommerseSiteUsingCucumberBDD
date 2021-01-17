Feature: login

Scenario: successful login with valid credentials

Given User launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/login"
And user enter email as "admin@yourstore.com" and password as "admin"
And click on login
Then Page title should be "Dashboard / nopCommerce administration"
When user click on logout link
Then Page title should be "Your store. Login"
And close browser
