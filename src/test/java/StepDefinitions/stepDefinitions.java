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
    public void clickOnDebtManagementInstallmentAgreementsCreateInstallmentAgreement() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Debt Management']"))).click();
        driver.findElement(By.xpath("//a[span='Instalment Agreements']")).click();
        driver.findElement(By.xpath("//a[span='Create Instalment Agreement']")).click();
    }

    @And("^Click on debt management > Create debt management case$")
    public void click_on_debt_management_create_debt_management_case() throws Throwable {
        driver.findElement(By.xpath("//a[span='Debt Management']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"MenuForm:j_idt29\"]/ul/li[15]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sub1\"]/ul/li/a")).click();
    }

    @And("^enter \"([^\"]*)\" and click search$")
    public void enter_something_and_click_search(String strArg1) throws Throwable {
        WebElement tinSearchInput = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber")));
        tinSearchInput.sendKeys(strArg1);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and span='Search']"));
        searchButton.click();
    }

    @Then("^CREATE DEBT MANAGEMENT CASE window is placed$")
    public void create_debt_management_case_window_is_placed() throws Throwable {
        WebElement createCaseTitle = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("DebtManagementCase:DebtManagementCasePanel_header")));
        Assert.assertEquals("CREATE DEBT MANAGEMENT CASE",createCaseTitle.getText());
    }

    @Then("^Find Payment To Dishonour page is displayed$")
    public void find_payment_to_dishonour_page_is_displayed() throws Throwable {
        WebElement dishonourTitle = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:directorHeader")));
        Assert.assertEquals("Find Payment To Dishonour",dishonourTitle.getText());
    }

    @Then("^Dishonoured Payment page is displayed$")
    public void dishonoured_payment_page_is_displayed() throws Throwable {
        WebElement dishonourTitle = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("dishonourPayment:PageTitleLabel")));
        Assert.assertEquals("Dishonoured Payment",dishonourTitle.getText());
    }

    @When("^the user enters taxtype \"([^\"]*)\" and value of debt \"([^\"]*)\"$")
    public void the_user_enters_taxtype_something_and_value_of_debt_something(String strArg1, String strArg2) throws Throwable {
        WebElement addButton = driver.findElement(By.id("DebtManagementCase:TaxTypeTable:btnAddTaxType"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);
        Thread.sleep(5000);
        addButton.click();

        WebElement iframe = ten.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);

        WebElement taxTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DebtCaseTaxType:TaxType\"]/div[3]")));
        taxTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-label='"+strArg1+"']")).click();

        String returnType= ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("DebtCaseTaxType:ReturnType"))).getText();
        Assert.assertFalse(returnType.isEmpty());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement debtInput = driver.findElement(By.id("DebtCaseTaxType:ValueOfDebt_input"));
        debtInput.sendKeys(strArg2);

        WebElement okButton = driver.findElement(By.id("DebtCaseTaxType:Ok"));
        okButton.click();
    }

    @And("^Click on Accounting > Dishonoured Payment$")
    public void click_on_accounting_dishonoured_payment() throws Throwable {
        driver.findElement(By.xpath("//a[span='Taxpayer Accounting']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[span='Dishonoured Payment']")).click();
    }

    @When("^user enters TIN \"([^\"]*)\" to find dishonour payment details$")
    public void user_enters_tin_something_to_find_dishonour_payment_details(String strArg1) throws Throwable {
        WebElement tinSearchInput = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:TIN")));
        tinSearchInput.sendKeys(strArg1);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and span='Search']"));
        searchButton.click();
    }

    @And("^selects a dishonored payment from table$")
    public void selects_a_dishonored_payment_from_table() throws Throwable {
        WebElement dishonouredPayment = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchForm:resultsDataTable_data\"]/tr[2]")));
        dishonouredPayment.click();

        WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit' and span='Continue']"));
        continueButton.click();
    }

    @When("^user enters Dishonoured Date  and Reason \"([^\"]*)\"$")
    public void user_enters_dishonoured_date_and_reason_something(String strArg1) throws Throwable {
        WebElement dishonouredDate = driver.findElement(By.id("dishonourPayment:DishonourDate_input"));
        dishonouredDate.sendKeys(Keys.ENTER);

        WebElement reasonDropdown = driver.findElement(By.xpath("//*[@id=\"dishonourPayment:Reason\"]/div[3]"));
        reasonDropdown.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@data-label='"+strArg1+"']")).click();

        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit' and span='Save']"));
        saveButton.click();

    }

    @Then("^Verify message \"([^\"]*)\"$")
    public void verify_message_something(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @When("^the user leaves details blank and clicks submit$")
    public void the_user_leaves_details_blank_and_clicks_submit() throws Throwable {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and span='Submit']"));
        submitButton.click();
    }


}



