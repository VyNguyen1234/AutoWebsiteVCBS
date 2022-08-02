package Test;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Common extends BasePage {

    public Common(WebDriver driver) {
        super(driver);
    }
    public void VerifyDisplay(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }
    public WebElement visibilityOfElement(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return null;
    }
    public void sendKeysElementPresent( By element ,String string ){
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        el.clear();
        el.sendKeys(string);

    }
    public void ClickElementPresent( By element ){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    public void ScrollEvent(By element ){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
