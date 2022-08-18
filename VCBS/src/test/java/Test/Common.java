package Test;

import Core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

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

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
//        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }
}
