import Page.CorporateActionPage;
import Page.LoginPage;
import Page.TradingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ultils.Url;
import ultils.Webdriver;

public class CorporateAction {
    static WebDriver driver = Webdriver.getChromeDriver();
    static CorporateActionPage corporateActionPage = new CorporateActionPage(driver);
    static TradingPage tradingPage = new TradingPage(driver);

    @BeforeTest
    public static void login() {
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        driver.manage().window().maximize();

        //Open Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername("009C000002")
                .inputPassword("xyz123")
                .clickOnLoginBtn();
    }

    @Test
    public static void case1VerifyRegisterSuccess(){
        //Register Corporate Action
        tradingPage.clickOnCorporateActionBtn();
        corporateActionPage
                .clickOnRegisterBtn()
                .inputVolume("1")
                .clickOnCheckboxAgree()
                .inputTradingPassword("xyz321")
                .clickOnSubmitBtn();

        Assert.assertTrue(corporateActionPage.message().isDisplayed());

        String expectedSuccessMessage = "Giao dịch thành công!";
        String actualSuccessMessage;
        actualSuccessMessage = corporateActionPage.message().getText();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
        System.out.println("Register Success Message: " + actualSuccessMessage);

        corporateActionPage.clickOnOKBtn();
        corporateActionPage.clickOnCloseBtn();
    }

    @Test
    public static void case2VerifyRegisterWithWrongTradingPassword() {
        //Register Corporate Action
        tradingPage.clickOnCorporateActionBtn();
        corporateActionPage
                .clickOnRegisterBtn()
                .inputVolume("1")
                .clickOnCheckboxAgree()
                .inputTradingPassword("xyz123")
                .clickOnSubmitBtn();

        Assert.assertTrue(corporateActionPage.message().isDisplayed());

        String expectedWrongTradingPasswordMessage = "Sai PIN";
        String actualWrongTradingPasswordMessage;
        actualWrongTradingPasswordMessage = corporateActionPage.message().getText();
        Assert.assertEquals(actualWrongTradingPasswordMessage, expectedWrongTradingPasswordMessage);
        System.out.println("Wrong Trading Password Message: " + actualWrongTradingPasswordMessage);
//        System.out.println("Wrong Trading Password Message raw: " + corporateActionPage.message().getText());

        corporateActionPage.clickOnOKBtn();
        corporateActionPage.ClickOnCloseBtnPopupInputAmount();
//        corporateActionPage.clickOnCloseBtn();
    }

    @Test
    public static void case3VerifyRegisterWithVolumeGreaterThanRemainNumber() {
        //Register Corporate Action
//        tradingPage.clickOnCorporateActionBtn();
        corporateActionPage
                .clickOnRegisterBtn();
        String remainNumber = corporateActionPage.remainNumber().getText();
        remainNumber = remainNumber.replace(",","");
        Integer volumeInputInt = Integer.parseInt(remainNumber) + 1;
        corporateActionPage
                .inputVolume(String.valueOf(volumeInputInt))
                .clickOnCheckboxAgree()
                .inputTradingPassword("xyz123")
                .clickOnSubmitBtn();

        Assert.assertTrue(corporateActionPage.messageError().isDisplayed());

        String expectedExceedRemainNumberMessage = "Vượt quá số lượng chứng khoán được quyền mua!";
        String actualExceedRemainNumberMessage;
        actualExceedRemainNumberMessage = corporateActionPage.messageError().getText();
        Assert.assertEquals(actualExceedRemainNumberMessage, expectedExceedRemainNumberMessage);
        System.out.println("Wrong Exceed Remain Number Message: " + actualExceedRemainNumberMessage);
//        System.out.println("Wrong Exceed Remain Number Message raw: " + corporateActionPage.messageError().getText());

//        corporateActionPage.clickOnOKBtnExceed();
//        corporateActionPage.ClickOnCloseBtnPopupInputAmount();
//        corporateActionPage.clickOnCloseBtn();
        driver.close();
    }
}
