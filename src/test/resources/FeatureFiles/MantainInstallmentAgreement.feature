Feature: [SUC:08-06]-Mantain installment agreement

  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:08-06 @UAT_M8-08-06-05 @backoffice
  Scenario: UAT_M8-08-03-05-Verify the process of abandon cancel
    And Click on debt management > Installment agreements > cancel installment agreement
    Then Search for case using tin "V0023145" and agreement number "IA000000070"
    Then Enter cancellation reason "Breech of Compliance Rules (System compliance default)"
    Then Enter cancellation date
    Then Enter cancellation notes "Invalid"
    Then Cancel cancellation
    Then user is navigated back to "https://backoffice.mra.mw:8443/trips-ui/faces/core/GenericSearch.xhtml"

  @SUC:08-06 @UAT_M8-08-06-06 @backoffice
  Scenario: UAT_M8-08-03-06-Verify the process of view installment agreement
    And Click on debt management > Installment agreements > view installment agreement
    Then Search for case using tin "V0023145" and agreement number "IA000000071"
    Then Verify view field has correct data "IA000000071"

  @SUC:08-06 @UAT_M8-08-06-02 @backoffice
  Scenario: UAT_M8-08-03-02-Verify the process of cancel installment agreement
    And Click on debt management > Installment agreements > cancel installment agreement
    Then Search for case using tin "V0023145" and agreement number "IA000000070"
    Then Enter cancellation reason "Breech of Compliance Rules (System compliance default)"
    Then Enter cancellation date
    Then Enter cancellation notes "Invalid"
    Then Submit cancellation
    Then Verify success message "Instalment Agreement with reference no"

  @SUC:08-06 @UAT_M8-08-06-04 @backoffice
  Scenario: UAT_M8-08-03-04-Verify the process of installment agreement Not found
    And Click on debt management > Installment agreements > cancel installment agreement
    Then Search for case using tin "C002297066hj" and agreement number "IA00000004"
    Then Verify no data is found in table

