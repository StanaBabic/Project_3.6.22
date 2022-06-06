import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

public class CustomerPage extends BasePage{

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
    private By addCustomerBtn=By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By firstNameField=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastNameField=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCodeField=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomerSubmitBtn=By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public CustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAddCustomerBtn(){
        getDriver().findElement(addCustomerBtn).click();
    }
    public void createCustomer(String firstName, String lastName, String postCode){

        getDriver().findElement(firstNameField).sendKeys(firstName);
        getDriver().findElement(lastNameField).sendKeys(lastName);
        getDriver().findElement(postCodeField).sendKeys(postCode);

    }

    public void clickAddCustomerSubmitBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(addCustomerSubmitBtn));
        getDriver().findElement(addCustomerSubmitBtn).click();


    }
}