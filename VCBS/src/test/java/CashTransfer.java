import Page.CashTransferPage;
import Page.LoginPage;
import Page.TradingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ultils.DriverBase;
import ultils.Url;
import ultils.Webdriver;



public class CashTransfer {
    @Test
    public static void verifyCashTransferWithWrongOTP() {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        driver.manage().window().maximize();

        //Open Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("009C000002")
                .inputPassword("xyz123")
                .clickOnLoginBtn();

        //Click on Cash Transfer button
        TradingPage tradingPage = new TradingPage(driver);
        tradingPage.clickOnCashTransferBtn();

        //Input cash transfer information
        CashTransferPage cashTransferPage = new CashTransferPage(driver);
        cashTransferPage
                .inputAmount("100000")
                .clickOnAcceptBtn()
                .inputOtp("111111")
                .clickOnAcceptOtpBtn();

        Assert.assertTrue(cashTransferPage.wrongOTPMessage().isDisplayed());

        String expectedWrongOTPMessage = "Sai mã xác thực (OTP)";
        String actualWrongOTPMessage;
        actualWrongOTPMessage = cashTransferPage.wrongOTPMessage().getText();
//        Assert.assertEquals(actualWrongOTPMessage,expectedWrongOTPMessage);
        System.out.println("Wrong OTP Message: " + actualWrongOTPMessage);
//        System.out.println("Wrong OTP Message raw: " + cashTransferPage.wrongOTPMessage().getText());
        driver.close();
    }

}
