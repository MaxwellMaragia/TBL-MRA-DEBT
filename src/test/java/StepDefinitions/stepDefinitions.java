package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass  {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten ;
    public WebDriverWait fifteen;
    public WebDriverWait twenty ;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;



    public static sharedatastep sharedata;
    public String ReferenceNumber = "IA000000045";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    public void switchToFrameBackoffice(){
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {

//    	intergtation link for backoffice
//    	driver.get("http://18.202.88.7:8001/trips-ui/faces/login/tripsLogin.xhtml");

        //    	SIT link for backoffice
        driver.get("https://backoffice.mra.mw:8443/trips-ui/faces/login/tripsLogin.xhtml");
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.xpath("//*[@id=\"loginForm:j_idt19\"]/span")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
        driver = getDriver();
        driver.get("https://" + strArg1 + ":Passw0rd@trips-crm.mra.mw:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
    }


    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @And("Click on debt management > Installment agreements > Create installment agreement")
    public void clickOnDebtManagementInstallmentAgreementsCreateInstallmentAgreement() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Debt Management']"))).click();
        driver.findElement(By.xpath("//a[span='Instalment Agreements']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sub1\"]/ul/li[1]/a")).click();
    }

    @Then("Find taxpayer using tin {string}")
    public void findTaxpayerUsingTin(String tin) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:find"))).click();
        switchToFrameBackoffice();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        
    }

    @Then("Select taxtype under outstanding debt {string}")
    public void selectTaxtypeUnderOutstandingDebt(String taxtype) throws InterruptedException {
        Thread.sleep(10000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:TaxType\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + taxtype + "')]"))).click();
    }

    @Then("Click add under outstanding debts")
    public void clickAddUnderOutstandingDebts() throws InterruptedException {
        Thread.sleep(3500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:outstandingDebtsTable:AddOutstandingDebt"))).click();
    }

    @Then("Select return type under outstanding debts {string}")
    public void selectReturnTypeUnderOutstandingDebts(String returnType) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OutstandingDebt:ReturnType\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + returnType + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Select period and year under outstanding debts {string}")
    public void selectPeriodAndYearUnderOutstandingDebts(String period) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OutstandingDebt:PeriodYear\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + period + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Enter value of debt as {string}")
    public void enterValueOfDebtAs(String debt) {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("OutstandingDebt:ValueofDebt_input"))).sendKeys(debt);
    }

    @Then("Click ok under installment agreements")
    public void clickOkUnderInstallmentAgreements() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("OutstandingDebt:Ok"))).click();
    }

    @Then("Enter number of installments as {string}")
    public void enterNumberOfInstallmentsAs(String number) throws InterruptedException {
        Thread.sleep(5000);
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:NumberofInstalments_input"))).sendKeys(number);
    }

    @Then("Select payment frequency as {string}")
    public void selectPaymentFrequency(String frequency) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:PaymentFrequency\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + frequency + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Select first installment due date as today")
    public void selectFirstInstallmentDueDateAsToday() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:FirstInstalmentDueDate_input"))).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Select reason for installment {string}")
    public void selectReasonForInstallment(String reason) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:Reason\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + reason + "')]"))).click();
        Thread.sleep(1500);

    }

    @Then("Select office as {string}")
    public void selectOfficeAs(String office) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:Office\"]/div[3]"))).click();
        Thread.sleep(1500);
//        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + office + "')]"))).click();
//        Thread.sleep(1500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Enter notes for agreement")
    public void enterNotesForAgreement() {
         ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:Notes"))).sendKeys("Notes");
    }

    @Then("Click save to submit installment agreement")
    public void clickSaveToSubmitInstallmentAgreement() {
         ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:Save"))).click();
    }


    @Then("Switch to backoffice frame")
    public void switchToBackofficeFrame() {
        switchToFrameBackoffice();
    }

    @Then("Obtain installment agreement ARN {string}")
    public void obtainInstallmentAgreementARN(String success) {
        //Instalment Agreement with reference no IA000000042 has been successfully created
        String FullMessage = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + success + "')]"))).getText();

        ReferenceNumber =FullMessage.substring(39,50);
        System.out.println("Actual ARN to be used in CRM is " +ReferenceNumber);
    }

    @Then("Click add under related documents")
    public void clickAddUnderRelatedDocuments() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:AddRelatedDocument"))).click();
    }

    @Then("Select related document type as {string}")
    public void selectRelatedDocumentTypeAs(String docType) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchForm:DocumentType\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + docType + "')]"))).click();
        Thread.sleep(1500);
    }


    @Then("Click search to search for document")
    public void clickSearchToSearchForDocument() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
    }

    @Then("Verify data for return document {string} is populated in table")
    public void verifyDataForReturnDocumentIsPopulatedInTable(String data) {
        WebElement DataXpath = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+data+"')]")));
        if (DataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Then("Click calculate to calculate installment plan")
    public void clickCalculateToCalculateInstallmentPlan() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:calculate"))).click();
    }

    @Then("Verify calculation data is populated in table")
    public void verifyCalculationDataIsPopulatedInTable() {
        WebElement DataXpath = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'DUE')]")));
        if (DataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Then("Click return document table row")
    public void clickReturnDocumentTableRow() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:relatedDocTableHandler_data\"]/tr/td[1]"))).click();
    }

    @Then("Click view to view return document")
    public void clickViewToViewReturnDocument() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:ViewRelatedDocument"))).click();
    }

    @Then("Verify return document screen is displayed with readonly fields")
    public void verifyReturnDocumentScreenIsDisplayedWithReadonlyFields() {
        WebDriverWait wait = new WebDriverWait(driver,60);
        WebElement tinfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_Tin")));
        String tin = tinfield.getAttribute("value");
        if(tin.isEmpty() || tinfield.isEnabled()){
            Assert.fail("Return document does not contain any data or fields are not readonly");
        }
        else{
            Assert.assertTrue("Return document page contains data",!tin.isEmpty());
        }
    }

    @Then("Click cancel to return to create installment screen")
    public void clickCancelToReturnToCreateInstallmentScreen() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:Cancel"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:InstalmentAgreementNumber"))).isDisplayed();
    }

    @Then("Remove return document")
    public void removeReturnDocument() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:DeleteRelatedDocument"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:deleteYesDoc"))).click();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("MRA_crm_url_Registration"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @Then("Click on debt application link")
    public void clickOnDebtApplicationLink() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Pro.getProperty("Cases_Management_Dropdown_XPATH")))).click();

        Thread.sleep(2000);
        driver.findElement(By.id(Pro.getProperty("Debt_Application_ID"))).click();
    }

    @Then("search for reference number")
    public void searchForReferenceNumber() throws InterruptedException {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);
        //search.sendKeys("*AV/000000875/2021");
        search.sendKeys(ReferenceNumber);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {

        WebElement elementLocator = driver.findElement(By.xpath(Pro.getProperty("CaseManagement_Queue_Select_ReffNo_XPATH")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();

    }

    @Then("^approve transaction$")
    public void approve_transaction() throws Throwable {

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Instalment Agreement Number:']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("^Click save CRM$")
    public void ClickSaveCRM() throws Throwable {
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_debtmanagementapplication|NoRelationship|Form|Mscrm.Form.tbg_debtmanagementapplication.Save")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("^Debt installment status should be \"([^\"]*)\"$")
    public void Verify_status_from_CRM(String Status) throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver,200);
        WebElement statusLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + Status + "')]")));

        if (statusLabel.isDisplayed()) {
            Assert.assertTrue("Approved", true);
        } else {
            Assert.fail("Approval failed");
        }
        Thread.sleep(2000);
    }
}



