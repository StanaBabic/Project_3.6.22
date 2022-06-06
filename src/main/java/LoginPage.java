import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class LoginPage extends BasePage{

    private By bankManagerLoginButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    private By customerLoginBtn=By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By homeBtn=By.xpath("/html/body/div/div/div[1]/button[1]");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickBankManagerLoginButton() {

        getDriverWait().until(ExpectedConditions.elementToBeClickable(bankManagerLoginButton)).click();

    }

    public void clickCustomerLoginButton(){

        getDriverWait().until(ExpectedConditions.elementToBeClickable(customerLoginBtn)).click();
    }

    public void clickHomeButton(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(homeBtn)).click();
    }
}

