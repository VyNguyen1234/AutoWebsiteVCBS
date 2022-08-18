package Page;

import Core.BaseTest;
import org.openqa.selenium.By;

public class TradePage_Element extends BaseTest {
    public By choosePage = By.xpath("//div[contains(text(),'1') and  @class='choose_pages current']");
    public By orderType = By.xpath("//div[@id='HomeContent']//td[contains(text(), 'Loại lệnh')]//following-sibling::td//select[@id='ordertype']");
    public By normalOrder = By.xpath("//div[@id='HomeContent']//td[contains(text(), 'Loại lệnh')]//following-sibling::td//select//option[@value='L']");
    public By buySell = By.xpath("//td[contains(text(), 'Mua/bán')]//following-sibling::td//select[@id='Side']");
    public By buy = By.xpath("//td[contains(text(), 'Mua/bán')]//following-sibling::td//select//option[@value='NB']");
    public By symBol= By.xpath("//div[@id='HomeContent']//td[contains(text(), 'Mã CK')]//following-sibling::td//input[@id='Symbol']");
    public By order = By.xpath("//div[@id='PriceType_div']//select[@id='PriceType']");
    public By lo = By.xpath("//div[@id='PriceType_div']//select[@id='PriceType']//option[@value='LO']");
    public By ato = By.xpath("//div[@id='PriceType_div']//select[@id='PriceType']//option[@value='ATO']");
    public By atc = By.xpath("//div[@id='PriceType_div']//select[@id='PriceType']//option[@value='ATC']");
    public By price  = By.xpath("//div[@id='HomeContent']//td[contains(text(), 'Giá')]//following-sibling::td//input[@id='Price']");
    public By qtty= By.xpath("//div[@id='HomeContent']//tr//following-sibling::tr//input[@id='Qtty']");
    public By qtymulti = By.xpath("//div[contains(text(), 'Nhân lệnh')]/..//following-sibling::td//input[@id='pv_qtymulti']");
    public By buyBtn = By.xpath("//input[@id='btn_NormalOrder' and @value='Mua']");
    public By passOrder =By.id("TradingPassword_TK");
    public By confirmOrder =By.id("preview_advance_order_button_submit");
    public By okBtn =By.xpath("//button[@class='buttonOK']");
    public By messTrans =By.id("messageErrorDiv");
    public By referPrice =By.xpath("//tr//td[@class='w33center no_change_arial_13']");


    //Element for Selling
    public By sell = By.xpath("//td[contains(text(), 'Mua/bán')]//following-sibling::td//select//option[@value='NS']");
    public By sellBtn = By.xpath("//input[@id='btn_NormalOrder' and @value='Bán']");



}
