Feature: [SUC:08-02] Maintain Debt Management Case

  @Debt-Officer @full @Agent-Appointment
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "DebtOfficer1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case

#    And click pick button

    Then switch to frame0
    Then Click on reference number
#    Then Debt status should be "New"
#    And wait for plan to load "Total Debt:"
#    When user enters Enforcement Action "Appointment of Agent" and Reason "Appointment of Agent"
#    And clicks Submit button
    Then Debt status should be "Appointment of Agent"
    And wait for plan to load "Appointment of Agent Number"
    When user clicks add Appointment of Agent
    Then Debt status should be "Appointment of Agent"
    And wait for plan to load "Agent Name"
    When user enters Appointment of Agent details
      | Agent Name        | testAgent |
      | Agent TIN         | P0020804  |
      | Agent Type        | Employee  |
      | Postal Address    | MR        |
      | Physical Address  | M         |
      | MothersMaidenName | Maria     |
#    Then switch to frame1
#    And wait for plan to load "Total Written Off Tax Debt"
#    When user enters Debt Write-Off Reason
#    And Writen Off Tax Debt clicks Submit button
#    Then switch to frame1
#    Then Debt status should be "Pending Write Off Approval By Tax Collector"

  @taxCollector @full
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "TaxCollector1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And pick the debt case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Tax Collector"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Station Manager"

  @stationmanager @full
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "StationManager1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Station Manager"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Deputy Commissioner Operations"

  @DeputyComOp @full
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "DeputyComOp1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Deputy Commissioner Operations"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Domestic Taxes Commissioner"

  @DomTaxCom @full
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "DomTaxCom1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Commissioner General"

  @ComGen @full
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off
    Given Open CRM URL Module as "ComGen"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Commissioner General"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Write Off Approved By Commissioner General"

  @debtofficer @full
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
    Then Debt status should be "Write Off Approved By Commissioner General"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    Then Debt status should be "Write Off Approved By Commissioner General"



