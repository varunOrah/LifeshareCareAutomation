Feature: Aide test cases

@AUTO_TC_002 @Web
Scenario: Create a new aide
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When user clicks on Add Aide link
Then User should be on Create Aide form
When User enters the required fields to create aide
When User clicks on SaveAide button
Then aide should be saved successfully

@AUTO_TC_003 @Web
Scenario: Create a new aide and set availability
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When user clicks on Add Aide link
Then User should be on Create Aide form
When User enters the required fields to create aide
When User clicks on SaveAide button
Then aide should be saved successfully
When User clicks on "AVAILABILITY" accordian
Then User should be able to set the below data
|Day   |TimeOfDay         |
|Monday|MORNING,AFTERNOON|
When User clicks on SaveAide button
Then aide should get updated

@AUTO_TC_005 @Web
Scenario: Create a new aide and delete it
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When user clicks on Add Aide link
Then User should be on Create Aide form
When User enters the required fields to create aide
When User clicks on SaveAide button
Then aide should be saved successfully
When User enter aide name in the search box
And User clicks on delete aide
And User enters password in the dialog box
And User clicks on Proceed
Then aide should get deleted