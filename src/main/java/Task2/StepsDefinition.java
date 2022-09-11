package Task2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepsDefinition {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void SetUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @After
    public void After() {
        driver.quit();
    }

    public WebElement findElementWithWait(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElementsWithWait(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }


    @Given("user navigates to the page")
    public void user_navigates_to_the_page() {
      driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @When("user clicks on button Bank Manager Login")
    public void user_clicks_on_button_bank_manager_login() {
        findElementWithWait(By.xpath("//button[@ng-click='manager()']")).click();
    }
    @When("user clicks on button Customers")
    public void user_clicks_on_button_customers() {
        findElementWithWait(By.xpath("//button[@ng-class='btnClass3']")).click();
    }
    @When("user verifies the number of customers in the table")
    public void user_verifies_the_number_of_customers_in_the_table() {
        List <WebElement> customers= findElementsWithWait(By.xpath("//tbody/tr"));
        Assertions.assertEquals(customers.size(), 5);
        }

    @When("user deletes one of the customers")
    public void user_deletes_one_of_the_customers() {
        findElementWithWait(By.xpath("//tr[2]/td/button[@ng-click='deleteCust(cust)']")).click();

    }
    @Then("verifies that the number of customers is minus one")
    public void verifies_that_the_number_of_customers_is_minus_one() {
        List <WebElement> customersUpdated= findElementsWithWait(By.xpath("//tbody/tr"));
        Assertions.assertEquals(customersUpdated.size(), 5-1);

    }
}
