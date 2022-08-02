package Page;

import Core.BaseTest;
import org.openqa.selenium.By;

public class Login_Element extends BaseTest {
    public By userName = By.id("Username");
    public By passLogin = By.id("Password");
    public By btnTruyCap = By.xpath("//input[@class='login_button']");
    public By succLogin = By.xpath("//label[contains(text(), 'Tiểu khoản')]");
}
