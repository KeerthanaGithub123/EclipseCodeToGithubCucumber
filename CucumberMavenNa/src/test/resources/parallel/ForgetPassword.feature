Feature: This is to test Reset the password functionality on RahulShetty Academy Registration page 

Background: For resetting the password 
Given User enters website through URL https://rahulshettyacademy.com/client/auth/login


@Forgotpassword
Scenario Outline: Reset the password

When User fill the emailID and Password and confirm password from given Sheet name "<EmailID>" and row number "<Password>" and row number "<confirmpwd>" to login to the Application


Examples: 

|EmailID|Password|confirmpwd|
|amrutha.tv@visionetsystems.com|abcd@1234|abcd@1234|