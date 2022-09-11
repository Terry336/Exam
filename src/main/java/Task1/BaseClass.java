package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BaseClass(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriverWait Wait() {return wait;}

    public WebDriver Driver() {return driver;}

    public WebElement findElementWithWait(By locator){
        return Wait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElementsWithWait(By locator){
        return Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

}
