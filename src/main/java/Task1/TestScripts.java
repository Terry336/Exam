package Task1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestScripts extends BaseTestClass{

    @Test
    public void Test1()throws InterruptedException{
        LoginPage page= new LoginPage(driver, wait);
        page.Navigate();
        page.CustomerClicklLogin();
        page.SelectName();
        page.ClickLogin();
        page.ClickDeposit();
        page.AssertBalance();

    }
}
