Feature: [SUC:08-02] Maintain Debt Management Case

  @Debt-Officer
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "DebtOfficer1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "New"
    And wait for plan to load "Total Debt:"
    When user enters Enforcement Action "Debt Write Off" and Reason "Debt Write-Off"
    And clicks Submit button
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    When user enters Enforcement Action "Debt Write Off" and Reason "Debt Write-Off"
    And clicks Submit button
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    Then switch to frame1
    And Click on NextStage button
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button

  @taxCollector
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "StationManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button

  @DeputyComOp
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "DeputyComOp1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button

  @DomTaxCom
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "DomTaxCom1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button

  @ComGen
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "ComGen"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt:"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button


