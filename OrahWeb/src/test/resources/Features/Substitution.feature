Feature: Substitution Test Cases

@AUTO_TC_019 @Web
Scenario: Substitute an aide

Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User searches for any patient
And User clicks on that patient name
And User clicks on "care plan" tab
Then User should be able to enter below Clockin and Clocout Time
|Accordian               |Day     |ClockIn   |ClockOut  | Aide               |
|CLOCK IN/CLOCK OUT      |Monday  |09:00 AM  |10:00 AM  | Check Aide         |
Then it should get added to patient schedule
And User clicks on "Substitution" tab
And User searches for aide "Check Aide"
And User enters start and end dates
And User clicks on search button
Then User should be able to select substitute aide "AideTwo Last"
When User clicks on Ok button in the pop up
Then Substitute should be saves successfully

@AUTO_TC_020 @Web @QA
Scenario: Verify that an error message is obtained when there are no tasks found between selected dates

Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
Then User creates 1 aides
And User clicks on "Substitution" tab
And User searches for aide created above
And User enters start and end dates
And User clicks on search button
Then No task found message should be displayed