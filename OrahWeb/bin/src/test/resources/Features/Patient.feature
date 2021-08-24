Feature: Patient Test Cases

@AUTO_TC_001 @Web
Scenario: Create new patient

Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User clicks on Add Patient
Then User should be on Create Patient form
When User enters the required fields to create patient
And User clicks on Save button
Then patient should be saved successfully

@AUTO_TC_004 @Web
Scenario: Create a new patient and delete it
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User clicks on Add Patient
Then User should be on Create Patient form
When User enters the required fields to create patient
And User clicks on Save button
Then patient should be saved successfully
When User enter patient name in the search box
And User clicks on delete patient
And User enters password in the dialog box
And User clicks on Proceed
Then patient should get deleted


@AUTO_TC_006 @Web
Scenario: Create a new patient and assign an aide with clock in and clock out
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
|CLOCK IN/CLOCK OUT      |Friday  |09:00 AM  |10:00 AM  |  ZWILSZ JDZMRT     |
Then it should get added to patient schedule

@AUTO_TC_007 @Web
Scenario: Assign a medical aide to a patient
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
|Accordian               |Day     |ClockIn   |ClockOut  | Aide             | Activity                    |
|MEDICAL                 |        |09:00 AM  |10:00 AM  |  ZWILSZ JDZMRT   | Before Breakfast Medication |
Then aide activity should get created


@AUTO_TC_008 @Web
Scenario: Assign a personal care or nutrition aide to a patient
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
| Accordian                 |Day     |ClockIn   |ClockOut  | Aide               |Activity|
| PERSONAL CARE & NUTRITION |        | 09:00 AM |10:00 AM  | ZWILSZ JDZMRT      |  See profile for list of nutritional needs and allergies  |
Then aide activity should get created

@AUTO_TC_009 @Web
Scenario: Assign a client activity aide to a patient
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
| Accordian                 |Day     |ClockIn   |ClockOut  | Aide               |Activity|
| CLIENT ACTIVITY           |        |09:00 AM  |10:00 AM  |  ZWILSZ JDZMRT     |  Independent  |
Then aide activity should get created

@AUTO_TC_010 @Web
Scenario: Assign a homemaker service aide to a patient
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
| Accordian                 |Day     |ClockIn   |ClockOut  | Aide               |Activity|
|HOMEMAKER SERVICES         |        | 09:00 AM  |10:00 AM  |  ZWILSZ JDZMRT      |  Living Areas  |
Then aide activity should get created

@AUTO_TC_011 @Web
Scenario: Requested Aide services for a patient 
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User searches for any patient
And User clicks on that patient name
And User clicks on "care plan" tab
And User clicks on "PROFILE" tab of patient
Then I should be able to select below aide services
|Accordian               |TypeOfCare       |License                            | Expertise    | Activity        | AddRequest |
|REQUESTED AIDE SERVICES |Live in,Live out |Cardiopulminary Resuscitation (CPR)|ALS,Diabeties | Cooking,Bathing | Other      |

@AUTO_TC_012 @Web
Scenario: Add general medical information for a patient 
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User searches for any patient
And User clicks on that patient name
And User clicks on "care plan" tab
And User clicks on "PROFILE" tab of patient
Then I should be able to select below general medical history
|Accordian               |Diagnosis       |Height       | Weight    | Blood   | Allergy |
|MEDICAL INFORMATION     |Pain            |170          | 80        | A+      | Itching   |


@AUTO_TC_013 @Web
Scenario: Add and remove medication details for a patient 
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User searches for any patient
And User clicks on that patient name
And User clicks on "care plan" tab
And User clicks on "PROFILE" tab of patient
Then I should be able to add below medication details
|Accordian               |Medicine        |Dose         | Frequency     | Purpose | 
|MEDICAL INFORMATION     |PCM             |5mg          | Once in a day | Fever   |
And I should be able to delete medication details for "PCM"

@AUTO_TC_014 @Web 
Scenario: Add and remove supplement details for a patient 
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User searches for any patient
And User clicks on that patient name
And User clicks on "care plan" tab
And User clicks on "PROFILE" tab of patient
Then I should be able to add below supplement details
|Accordian               |Supplement      |Dose          | Frequency     | 
|MEDICAL INFORMATION     |Whey             |5mg          | Once in a day | 
And I should be able to delete supplement details for "Whey"

@AUTO_TC_015 @Web
Scenario: Create a new patient and add emergency contact details
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User clicks on Add Patient
Then User should be on Create Patient form
When User enters the required fields to create patient
And User clicks on Save button
Then patient should be saved successfully
Then I should be able to enter below emergency contact information
|Accordian                         |Name           |Number         | Email               | Relation | Address | 
|EMERGENCY CONTACT INFORMATION     |John Smith     |7987210390     | contact@yopmail.com | Brother  | Kanpur  |

@AUTO_TC_016 @Web
Scenario: Create a new patient and add payor information
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User clicks on Add Patient
Then User should be on Create Patient form
When User enters the required fields to create patient
And User clicks on Save button
Then patient should be saved successfully
Then I should be able to enter below payor information
|Accordian             | Carrier        |Subscriber | SubscriberId        | 
|PAYOR INFORMATION     | John Smith     |Ben        | 218762              |

@AUTO_TC_017 @Web 
Scenario: Verify that error message are displayd when any of the required fields are missing while creating a patient
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User clicks on Add Patient
Then User should be on Create Patient form
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
 |             | John      | Smith    | Kanpur  | Cell      | 3454379089 | Any       | Any | Male   |
Then User should get the error message - "Please Select Start of Care Date"
Then User refreshes the page
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         |           | Smith    | Kanpur  | Cell      | 3454379089 | Any       | Any | Male   |           
Then User should get the error message - "Please Enter first name"
Then User refreshes the page
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         | John      |          | Kanpur  | Cell      | 3454379089 | Any       | Any | Male   |            
Then User should get the error message - "Please Enter Last name"
Then User refreshes the page
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         | John      | Smith    |         | Cell      | 3454379089 | Any       | Any | Male   |              
Then User should get the error message - "Please Enter address"
Then User refreshes the page
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         | John      | Smith    | Kanpur  | Cell      |            | Any       | Any | Male   |         
Then User should get the error message - "Please enter phone number"
Then User refreshes the page
When User enters the below patient data
|CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         | John      | Smith    | Kanpur  | Cell      | 3454379089 |           | Any | Male   |       
Then User should get the error message - "Please select date of birth"
Then User refreshes the page
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         | John      | Smith    | Kanpur  | Cell      | 3454379089 | Any       |     | Male   |              
Then User should get the error message - "Please select image."
Then User refreshes the page
When User enters the below patient data
 |CareStartDate| FirstName |LastName |Address |PhoneType |PhoneNo |BirthDate |Pic |Gender|
| Any         | John      | Smith    | Kanpur  | Cell      | 3454379089 | Any       | Any |        |              
Then User should get the error message - "Please select gender"


@AUTO_TC_023 @Web @QA
Scenario: Create a care plan for a patient and verify it in schedule
Given User is on Home Page
When User Clicks on Agency Portal	
Then He should be navigated to Agency Portal Page
When User enters Agency Login Detials
And User Clicks on Sign in Button
Then he should be on Agency Home Page with Agency Header as "Varun"
When User clicks on Add Patient
Then User should be on Create Patient form
When User enters the required fields to create patient
And User clicks on Save button
Then patient should be saved successfully
Then User creates 1 aides
When User enter patient name in the search box
And User clicks on that patient name
And User clicks on "care plan" tab
Then User should be able to enter below Clockin and Clocout Time
|Accordian               |Day  |ClockIn   |ClockOut  | Aide               |
|CLOCK IN/CLOCK OUT      |Any  |09:00 AM  |10:00 AM  | CreatedAbove       |
Then it should get added to patient schedule
And User clicks on "SCHEDULE" tab of patient

