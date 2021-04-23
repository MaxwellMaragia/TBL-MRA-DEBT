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
//        driver = getDriver();
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

    @And("^click on Queues$")
    public void click_on_revenue_collection_application() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Queues']")).click();
    }

    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @And("^enters Debt reference number in search results$")
    public void enters_exemption_reference_number_in_search_results() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);
//        search.sendKeys("*DM/000000943/2021");
        search.sendKeys("*"+sharedatastep.DEBT_ARN_ORG);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }


    @And("^picks the audit case$")
    public void picks_the_audit_case() throws Throwable {
        WebElement pickCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(pickCheckBox).perform();

        driver.switchTo().defaultContent();
    }

    @And("^pick the debt case$")
    public void pick_the_debt_case() throws Throwable {
        WebElement pickButton = driver.findElement(By.xpath("//*[@id=\"queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick\"]/span"));
        Actions actions = new Actions(driver);
        actions.doubleClick(pickButton).perform();
    }
    @And("^click pick button$")
    public void click_pick_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement assignDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moreCommands")));
        assignDropdown.click();

        WebElement pickButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick")));
        pickButton.click();
    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]"));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @Then("^Debt status should be \"([^\"]*)\"$")
    public void application_account_adjustment_status_should_be_something(String Status) throws Throwable {
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("contentIFrame1");
        WebDriverWait wait = new WebDriverWait(driver,100);
        Thread.sleep(3000);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+Status+"']"))).getText();
        Assert.assertEquals(Status,text);
        Thread.sleep(2000);
    }
    @And("^wait for plan to load \"([^\"]*)\"$")
    public void wait_for_duplicate_check(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame(frame);
        WebElement DebtCaseSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + strArg1 + "']")));
        Assert.assertTrue(DebtCaseSummary.isDisplayed());
    }

    @When("user enters Public Office Name{string} Address {string} and Place of Filing {string}")
    public void userEntersPublicOfficeNameAddressAndPlaceOfFiling(String strArg1, String strArg2, String strArg3) {
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[2]/div/div/tb-input-text/div/div[2]/div/input")).sendKeys(strArg1);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[2]/div/div/tb-input-text-area[1]/div/div[2]/div/textarea")).sendKeys(strArg2);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[2]/div/div/tb-input-text-area[2]/div/div[2]/div/textarea")).sendKeys(strArg3);
    }

    @When("^user enters summary cost Costs \"([^\"]*)\"$")
    public void user_enters_summary_cost_costs_something(String strArg1) throws Throwable {
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-distraint-action/div/form/div[1]/div[3]/div[4]/div/app-summary/form/div/div/div/tb-png-input-number[4]/div/div[2]/div/span/input")).sendKeys(strArg1);
    }

    @When("^user enters Reason for Enforcement Suspension$")
    public void user_enters_reason_for_enforcement_suspension_something() throws Throwable {
        WebElement Date = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[1]/div/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/input")));
        Date.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[1]/div/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[1]/td[6]/a")).click();

        WebElement reasonEnforcementSuspension = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        reasonEnforcementSuspension.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();
    }

    @When("^user enters Asset Summary Personal Property$")
    public void user_enters_asset_summary_personal_property(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text-area/div/div[2]/div/textarea")).sendKeys(data.get(1).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[1]/div/div[2]/div/span/input")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[2]/div/div[2]/div/span/input")).sendKeys(data.get(3).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(4).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[3]/div/div[2]/div/input")).sendKeys(data.get(5).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[2]/div/button[1]")).click();
    }

    @When("^user enters Asset Seized$")
    public void user_enters_asset_seized(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(1).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-png-input-number[1]/div/div[2]/div/span/input")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-png-input-number[2]/div/div[2]/div/span/input")).sendKeys(data.get(3).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-input-text[3]/div/div[2]/div/input")).sendKeys(data.get(4).get(1));

        WebElement assetSeized = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        assetSeized.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        WebElement dateofSeizure = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-date-picker/div/div[2]/div/p-calendar/span")));
        dateofSeizure.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[1]/td[5]/a")).click();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[2]/div/button[1]")).click();
    }

    @When("^user enters Asset Summary Real Property$")
    public void user_enters_asset_summary_real_property(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text-area/div/div[2]/div/textarea")).sendKeys(data.get(1).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[1]/div/div[2]/div/span/input")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[2]/div/div[2]/div/span/input")).sendKeys(data.get(3).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(4).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[3]/div/div[2]/div/input")).sendKeys(data.get(5).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[2]/div/button[1]")).click();
    }

    @When("^user enters Appointment of Agent details$")
    public void user_enters_appointment_of_agent_details(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(1).get(1));

        WebElement agentTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        agentTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text-area[1]/div/div[2]/div/textarea")).sendKeys(data.get(2).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text-area[2]/div/div[2]/div/textarea")).sendKeys(data.get(3).get(1));

        WebElement dateOfAppointment = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-date-picker[1]/div/div[2]/div/p-calendar/span/input")));
        dateOfAppointment.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-date-picker[1]/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[1]/td[5]/a")).click();

        WebElement expiryDate = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-date-picker[2]/div/div[2]/div/p-calendar/span/input")));
        expiryDate.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-date-picker[2]/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[5]/td[6]/a")).click();

        WebElement appointmentStatus = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label")));
        appointmentStatus.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[2]/div/button[1]")).click();
    }

    @When("^user enters Tax Type Period  and Debt Amount \"([^\"]*)\"$")
    public void user_enters_tax_type_period_and_debt_amount_something(String strArg1) throws Throwable {
        WebElement taxTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        taxTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement debtInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-png-input-number/div/div[2]/div/span/input"));
        debtInput.sendKeys(strArg1);

        WebElement periodDropdown= ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label")));
        periodDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();

        WebElement okButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[2]/div/button[1]"));
        okButton.click();
    }

    @When("^user enters Debt Write-Off Reason")
    public void user_enters_debt_writeoff_reason() throws Throwable {
        WebElement reasonDropdown= ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[2]/div/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        reasonDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[2]/div/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();

    }

    @When("^user clicks add Writen Off Tax Debt$")
    public void user_clicks_add_writen_off_tax_debt() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[2]/div/div[1]/app-tax-debt-list/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Tax Debt Collected by Legal$")
    public void user_clicks_add_tax_debt_collected_by_legal() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-legal-action/div/form/div[3]/div/div/app-tax-debt-list/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Appointment of Agent$")
    public void user_clicks_add_appointment_of_agent() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-agent/div/form/div[1]/div[2]/div/div/div[1]/button[1]"));
        addButton.click();
    }
    @When("^user clicks add Asset Summary Personal Property$")
    public void user_clicks_add_asset_summary_personal_property() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[4]/div/div/app-asset-summary/div/div/button[1]"));
        addButton.click();
    }
    @When("^user clicks add Asset Summary Real Property$")
    public void user_clicks_add_asset_summary_real_property() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[3]/div/div/app-asset-summary/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Asset Seized$")
    public void user_clicks_add_asset_seized() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-distraint-action/div/form/div[1]/div[3]/div[1]/div/app-asset-seized/div/div/button[1]"));
        addButton.click();
    }

    @When("^user enters Enforcement Action \"([^\"]*)\" and Reason \"([^\"]*)\"$")
    public void user_enters_enforcement_action_something_and_reason_something(String strArg1, String strArg2) throws Throwable {
        WebElement enforcementAction = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label"));
        enforcementAction.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='"+strArg1+"']")).click();

        WebElement Reason = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label"));
        Reason.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='"+strArg2+"']")).click();

    }

    @And("^clicks Submit button$")
    public void clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Writen Off Tax Debt clicks Submit button$")
    public void writen_off_tax_debt_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[3]/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Appointment of Agent clicks Submit button$")
    public void appointment_of_agent_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-agent/div/form/div[2]/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Lien Imposition clicks Submit button$")
    public void lien_imposition_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[2]/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Distraint Action clicks Submit button$")
    public void distraint_action_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-distraint-action/div/form/div[2]/div/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Enforcement Suspension clicks Submit button$")
    public void enforcement_suspension_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[3]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Legal Action clicks Submit button$")
    public void legal_action_clicks_submit_button() throws Throwable {
        WebElement submitButton = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-legal-action/div/form/div[4]/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @And("^Select Approval outcome value to Approve \"([^\"]*)\"$")
    public void select_approval_outcome_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_"+strArg1+"approval";
        WebElement  dropDown=driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_debtmanagementapplication|NoRelationship|Form|Mscrm.Form.tbg_debtmanagementapplication.Save")).click();


    }

    @Then("^Click on NextStage button$")
    public void click_on_NextStage_button() throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Pro.getProperty("Individual_NextStage_Button_XPATH"))).click();
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createCaseTitle);
        Thread.sleep(5000);
        Assert.assertEquals("CREATE DEBT MANAGEMENT CASE",createCaseTitle.getText());
    }

    @Then("^Find Payment To Dishonour page is displayed$")
    public void find_payment_to_dishonour_page_is_displayed() throws Throwable {
        WebElement dishonourTitle = fifty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:directorHeader")));
        Assert.assertEquals("Find Payment To Dishonour",dishonourTitle.getText());
    }

    @Then("^Dishonoured Payment page is displayed$")
    public void dishonoured_payment_page_is_displayed() throws Throwable {
        WebElement dishonourTitle = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("dishonourPayment:PageTitleLabel")));
        Assert.assertEquals("Dishonoured Payment",dishonourTitle.getText());
    }

    @When("^the user enters taxtype \"([^\"]*)\" and value of debt \"([^\"]*)\" return tpe and period \"([^\"]*)\"$")
    public void the_user_enters_taxtype_something_and_value_of_debt_something_return_tpe_and_period_something(String strArg1, String strArg2, String strArg3) throws Throwable {
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

        Thread.sleep(8000);
        WebElement returnTypedropdown= driver.findElement(By.xpath("//*[@id=\"DebtCaseTaxType:ReturnType\"]/div[3]"));
        returnTypedropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.id("DebtCaseTaxType:ReturnType_1")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement debtInput = driver.findElement(By.id("DebtCaseTaxType:ValueOfDebt_input"));
        debtInput.sendKeys(strArg2);


        Thread.sleep(8000);
        WebElement periodDropdown= ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DebtCaseTaxType:PeriodValue\"]/div[3]")));
        periodDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-label='"+strArg3+"']")).click();



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

    @Then("^Verify the ARN number \"([^\"]*)\"$")
    public void verify_the_ARN_number_ARN(String ARN) throws Throwable {

        WebDriverWait RefNumber = new WebDriverWait(driver, 150);
        // Capture ARN Number
        String text = RefNumber.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("Precessing_Completed_RefferenceNumber_ID")))).getText();

        System.out.println(text);
        System.out.println("substring is " + text.substring(42));
        sharedatastep.DEBT_ARN_ORG = text.substring(42);
        System.out.println(sharedatastep.DEBT_ARN_ORG);
        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.DEBT_ARN_ORG);

        if (text.contains(ARN)) {
            //  System.out.println(text);
            System.out.println("Text Verified and passed");
        } else {
            System.out.println("Text Not Verified and failed");
        }
    }
    @When("^the user leaves details blank and clicks submit$")
    public void the_user_leaves_details_blank_and_clicks_submit() throws Throwable {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and span='Submit']"));
        submitButton.click();
    }

    @When("^User enters Case Title \"([^\"]*)\" and Office \"([^\"]*)\"$")
    public void user_enters_case_title_something_and_office_something(String strArg1, String strArg2) throws Throwable {
        WebElement caseTitle = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("DebtManagementCase:CaseTitle")));
        caseTitle.sendKeys(strArg1);

        WebElement officeDropdown=driver.findElement(By.xpath("//*[@id=\"DebtManagementCase:CaseOffice\"]/div[3]"));
        officeDropdown.click();
        Thread.sleep(4000);
//        WebElement taxType=driver.findElement(By.xpath("//li[@data-label='"+strArg2+"']"));
        WebElement taxType=driver.findElement(By.id("DebtManagementCase:CaseOffice_1"));
        taxType.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and span='Submit']"));
        submitButton.click();
    }


}



