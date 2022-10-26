Feature: This is to test login invalid 

Background: PreRequisite fr login
Given User enters the website through URL https://rahulshettyacademy.com/client/auth/login


@AddItemToCart
Scenario Outline: Login in Rahul Shetty academy Shopping Application

When User fills the emailID and Password from given Sheet name "<EmailID>" and row number "<Password>" to login to the Application
Then it shows a failed error message "Incorrect email or password."
Examples: 

|EmailID|Password|
|ak12@gmail.com|Rideoie@34|