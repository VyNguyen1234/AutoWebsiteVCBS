package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final By usernameSelector = By.id("Username");
    private final By passwordSelector = By.id("Password");
    private final By loginBtnSelector = By.cssSelector("[type='submit']");
    private final WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement username() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSelector));
    }

    public WebElement password() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordSelector));
    }

    public WebElement loginBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnSelector));
    }

    public LoginPage inputUsername(String username) {
        username().clear();
        username().sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        password().sendKeys(password);
        return this;
    }

    public LoginPage clickOnLoginBtn() {
        loginBtn().click();
        return this;
    }
}
