Feature: This is to test Items added to Cart on RahulShetty Academy Registration page 

Background: PreRequisite for adding Adding Item to Cart
Given User enters the website through URL https://rahulshettyacademy.com/client/auth/login


@AddItemToCart
Scenario Outline: Add Item to Cart in Rahul Shetty academy Shopping Application

When User fills the emailID and Password from given Sheet name "<EmailID>" and row number "<Password>" to login to the Application
When User search the item and add the Item searched "<SearchItem>" to the Cart for shopping
And User click on the Cart to view the Items added and check whether the Item searched is added to Cart
Then User click on "Sign Out" to sign out of the Application
Examples: 

|EmailID|Password|SearchItem|
|keer26@gmail.com|Keerthu@1988|adidas|
#|LoginDetails|1|adidas|

@InvalidItem_AddToCart
Scenario Outline: Add Invalid Item to Cart in Rahul Shetty academy Shopping Application

When User fills the emailID and Password from given Sheet name "<EmailID>" and row number "<Password>" to login to the Application
When User search the Invalid Item "<SearchItem>" at add to Cart
And User view the message that Showing No results found
Then User click on "Sign Out" to sign out of the Application
Examples: 

|EmailID|Password|SearchItem|
|keer26@gmail.com|Keerthu@1988|samsung|








