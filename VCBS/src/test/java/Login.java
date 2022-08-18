import Page.LoginPage;
import Page.TradingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ultils.Url;
import ultils.Webdriver;

public class Login {
    @Test
    public static void verifyThatLoginSuccess() {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("009C000002")
                .inputPassword("xyz123")
                .clickOnLoginBtn();

        TradingPage tradingPage = new TradingPage(driver);

        Assert.assertTrue(tradingPage.signOutBtn().isDisplayed());

        driver.close();
    }
}
