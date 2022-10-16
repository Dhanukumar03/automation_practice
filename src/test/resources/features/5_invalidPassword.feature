Feature: Enter invalid password

Scenario: User updates new password with wrong current password
Given user is in Sign_In page
When  user enters email as "peter_parker1@gmail.com" and password as "qwerty"
And user enters currentpassword as "abcd12" and newpassword as "xyz123" and confirmpassword as "xyz123" and clicks save
Then it shows  error message "The password you entered is incorrect."


Scenario: User enters details with wrong current password
Given user  in sign_In page
When user enters mailid as "peter_parker1@gmail.com" and password as "qwerty"
And user enters firstname as "Jon" and lastname as "Snow" and email as "jonsnow@gmail.com" and currentpassword as "abcd12" and clicks save
Then it shows a error message "The password you entered is incorrect." 
