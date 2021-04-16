Feature: [SUC:08-03]-Create Installment Agreements
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:08-03 @UAT_M8-08-03-01 @UAT_M8-08-03-02
  Scenario: UAT_M8-08-03-02-Verify the process of installment agreement-Organization
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "P0020797"
    Then Switch to default
    Then Select taxtype under outstanding debt "PAYE"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "PAYE Return"
    Then Select period and year under outstanding debts "7/2020"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Enter number of installments as "1"
    Then Select payment frequency as "Weekly"
    Then Select first installment due date as today
    Then Select reason for installment "Cash Flow Problem"
    Then Select office as "Balaka"
    Then Enter notes for agreement
    Then Click save to submit installment agreement
    Then Verify success message "Instalment Agreement with reference no"
    Then Obtain installment agreement ARN "Instalment Agreement with reference no"

  @SUC:08-03 @UAT_M8-08-03-03
  Scenario: UAT_M8-08-03-03-Verify the process of installment agreement-Individual
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "P0020797"
    Then Switch to default
    Then Select taxtype under outstanding debt "PAYE"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "PAYE Return"
    Then Select period and year under outstanding debts "7/2020"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Enter number of installments as "1"
    Then Select payment frequency as "Weekly"
    Then Select first installment due date as today
    Then Select reason for installment "Cash Flow Problem"
    Then Select office as "Balaka"
    Then Enter notes for agreement
    Then Click save to submit installment agreement
    Then Verify success message "Instalment Agreement with reference no"
    Then Obtain installment agreement ARN "Instalment Agreement with reference no"

  @SUC:08-03 @UAT_M8-08-03-04
  Scenario: UAT_M8-08-03-04-Verify the process of validation errors
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "P0020797"
    Then Switch to default
    Then Select taxtype under outstanding debt "PAYE"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "PAYE Return"
    Then Select period and year under outstanding debts "7/2020"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Click save to submit installment agreement
    Then Verify error message "Number of Instalments: Validation Error: Value is required."
    Then Verify error message "Payment Frequency: Validation Error: Value is required."
    Then Verify error message "First Instalment Due Date: Validation Error: Value is required."
    Then Verify error message "Reason: Validation Error: Value is required."
    Then Verify error message "Office: Validation Error: Value is required."
    Then Verify error message "Notes: Validation Error: Value is required."

  @SUC:08-03 @UAT_M8-08-03-05
  Scenario: UAT_M8-08-03-05-Verify the process taxpayer not found
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "P0020797dgg"
    Then Verify no data is found in table




