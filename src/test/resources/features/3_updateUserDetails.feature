Feature: Update Details
Scenario Outline: User Updates Details with valid credentials
Given user is in signin page
When user enters details in the form from given sheetNumber "<SheetName>" and rowNumber <RowNumber>
And user clicks on save button
Then it shows successful message "Your personal information has been successfully updated."
Examples:
|SheetName|RowNumber|
|details|0|
|details|1|