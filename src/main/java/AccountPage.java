import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage{

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
    private By openAccountBtn=By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private  By processBtn=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    private CustomerPage firstName;
    private By firstNameField=By.id("userSelect");
    private By currencyField=By.id("//*[@id=\"currency\"]");
    private Currency currency;

    public AccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOpenAccountBtn(){
        getDriver().findElement(openAccountBtn).click();
    }
    public void createAccount(){
        Select customerName= new Select(getDriver().findElement(firstNameField));
        getDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(firstNameField));
        customerName.selectByVisibleText("Stana");
        getDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(currencyField));
        Select currency=new Select(getDriver().findElement(currencyField));
        currency.selectByVisibleText("Dollar");
    }

    public void clickProcessBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(processBtn));
        getDriver().findElement(processBtn).click();


    }
}

