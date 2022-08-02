package Test;

import Core.BasePage;
import Page.Login_Element;
import org.openqa.selenium.WebDriver;

public class LoginAction extends BasePage {
    public LoginAction(WebDriver driver) {
        super(driver);
    }
    Login_Element loginPage = new Login_Element();
    Common common= new Common(driver);
    public void Login (String user, String pass){
        common.sendKeysElementPresent(loginPage.userName,user);
//        common.ScrollEvent(loginPage.passLogin);
        common.sendKeysElementPresent(loginPage.passLogin,pass);
        common.ClickElementPresent(loginPage.btnTruyCap);
        common.VerifyDisplay(loginPage.succLogin);

    }
}

