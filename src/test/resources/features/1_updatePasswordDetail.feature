Feature: Update Password 
Scenario Outline: User updates password with valid format
Given user is in sign_in page
When  a user enters details in the form from given sheetNumber  "<SheetName>" and rowNumber  <RowNumber>
And the user clicks  save button
Then the user should be able to see  message "Your personal information has been successfully updated."

Examples:
|SheetName|RowNumber|
|valid_password|0|
|valid_password|1|