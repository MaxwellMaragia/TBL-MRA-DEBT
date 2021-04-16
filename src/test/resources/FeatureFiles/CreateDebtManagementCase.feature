Feature: [SUC:08-03]-Create Debt Management Case
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:08-01 @UAT_M8-08-01-01 @UAT_M8-08-01-02
  Scenario: UAT_M8-08-01-01-Verify the process of installment agreement-Organization
    And Click on debt management > Create debt management case
    And enter "C0021739" and click search
    Then CREATE DEBT MANAGEMENT CASE window is placed
    When the user enters taxtype "Non Resident Tax(NRT)" and value of debt "100"


  @SUC:08-01 @UAT_M8-08-01-03
  Scenario: UAT_M8-08-01-01-Verify the process of installment agreement-Individual
    And Click on debt management > Create debt management case
    And enter "C0021739" and click search
    Then CREATE DEBT MANAGEMENT CASE window is placed
    When the user enters taxtype "Non Resident Tax(NRT)" and value of debt "100"

  @SUC:08-01 @UAT_M8-08-01-04
  Scenario: UAT_M8-08-01-01-Verify the process of System creates Debt Management Case
    And Click on Accounting > Dishonoured Payment
    Then Find Payment To Dishonour page is displayed
    When user enters TIN "%" to find dishonour payment details
    And selects a dishonored payment from table
    Then Dishonoured Payment page is displayed
    When user enters Dishonoured Date  and Reason "Instrument Dishonoured"
    Then Verify message "The Payment is dishonoured successfully for Receipt Id"

  @SUC:08-01 @UAT_M8-08-01-05
  Scenario: UAT_M8-08-01-01-Verify the process of Validation Field
    And Click on debt management > Create debt management case
    And enter "C0021739" and click search
    Then CREATE DEBT MANAGEMENT CASE window is placed
    When the user leaves details blank and clicks submit
    Then Verify message "Validation Error: Value is required"
    When the user enters taxtype "Non Resident Tax(NRT)" and value of debt " "
    Then Verify message "Validation Error: Value is required"


