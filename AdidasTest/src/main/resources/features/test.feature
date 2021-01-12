Feature: Validate front end and backend services

@ui
Scenario: Validate online shoping operations
Given user is on home page
When user add products
|Sony vaio i5|
|Dell i7 8gb|
And user delete product "Dell i7 8gb"
And user fill form with below data
|Aditya     |India | Noida   |  NA   | March   |  2021   |
Then verify the purchase amount

@api
Scenario: Validate http requests for pet store api
Given I am an authorised user
When user get the records of "available" pets
Then verify response code 200
When user add "available" pet to the store
Then verify response code 200
When user update added pet status as "sold"
Then verify response code 200
When user delete pet from record
Then verify response code 200
