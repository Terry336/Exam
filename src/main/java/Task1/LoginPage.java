package Task1;

import dev.failsafe.internal.util.Assert;
import groovy.xml.StreamingDOMBuilder;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseClass{
       public LoginPage(WebDriver driver, WebDriverWait wait) {
           super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
       }

    public void Navigate(){
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    public void CustomerClicklLogin(){
        findElementWithWait(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();
    }

    public void SelectName() throws InterruptedException {
        findElementWithWait(By.id("userSelect")).click();
        Thread.sleep(3000);
        findElementWithWait(By.xpath("//option[contains(text(),'Harry Potter')]")).click();
    }

    public void ClickLogin() {
        findElementWithWait(By.xpath("//button[@class='btn btn-default']")).click();
    }
    public void ClickDeposit(){
           findElementWithWait(By.xpath("//button[@ng-class='btnClass2']")).click();
           findElementWithWait(By.xpath("//input[@type='number']")).sendKeys("1000");
           findElementWithWait(By.xpath("//button[@type='submit']")).click();
        findElementWithWait(By.xpath("//input[@type='number']")).sendKeys("1000");
        findElementWithWait(By.xpath("//button[@type='submit']")).click();
    }

    public void AssertBalance() throws InterruptedException {
           WebElement Balance= findElementWithWait(By.xpath("//strong[2][@class='ng-binding']"));
           Thread.sleep(3000);
        Assertions.assertEquals(Balance.getText(), "2000");
    }
}
