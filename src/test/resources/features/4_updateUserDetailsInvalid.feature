Feature:  Updates invalid details

Scenario Outline: User Updates Details with invalid credentials
Given user is in Signin page
When user enters details in the form from the given sheetNumber "<SheetName>" and rowNumber <RowNumber>
And user clicks the save button
Then user should be able to see a error message "<errormessage>"

Examples:
|SheetName|RowNumber|errormessage|
|invalid_details|0|This email address is not valid|
|invalid_details|1|firstname is invalid.|
|invalid_details|2|This email address is not valid|
|invalid_details|3|lastname is invalid.|
|invalid_details|4|lastname is invalid.|
|invalid_details|5|An account using this email address has already been registered.|
