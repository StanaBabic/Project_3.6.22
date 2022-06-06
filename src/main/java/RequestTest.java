/* Domaći:
    Otići na https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.
    Test 1: Logovanje kao Bank Manager
    Test 2: Kreiranje Customera
    Test 3: Kreiranje Accounta za tog Customera
    Test 4: Logovanje kao Customer
    Test 5: Uspešan Deposit za nekog Customera
    Test 6: Uspešan Withdrawal za nekog Customera
    Test 7: Logout za Bank Managera
    Test 8: Logout za Customera
    Prolaz (ocena 3) - Testovi 1, 2, 4, 5.
    Obavezno koristiti POM.
    May the odds be ever in your favor. (edited)*/
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RequestTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private CustomerPage customerPage;
    private AccountPage accountPage;
    private Alert alert;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT project\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginPage = new LoginPage(driver, driverWait);

        customerPage = new CustomerPage(driver, driverWait);

        accountPage =new AccountPage(driver,driverWait);

        alert= new Alert() {
            @Override
            public void dismiss() {

            }

            @Override
            public void accept() {

            }

            @Override
            public String getText() {
                return null;
            }

            @Override
            public void sendKeys(String keysToSend) {

            }
        };

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test(priority = 1)
    public void testLoginAsBankManager() {

        loginPage.clickBankManagerLoginButton();
        driverWait.until(ExpectedConditions.urlContains("manager"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }

    @Test(priority = 2)

    public void testAddCustomer() {
        customerPage.clickAddCustomerBtn();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form")));
        customerPage.createCustomer("Stana", "Babic", "21000");
        customerPage.clickAddCustomerSubmitBtn();
        driver.switchTo().alert().accept();

    }

    @Test(priority = 4)

    public void testCreateAccount(){
        accountPage.clickOpenAccountBtn();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form")));
        accountPage.createAccount();

        accountPage.clickProcessBtn();
    }
    @Test (priority = 3)

    public void testLoginAsCustomer(){
        loginPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        driverWait.until(ExpectedConditions.urlContains("customer"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }
    @AfterClass
    public void afterClass() {

        driver.close();

    }
}