package Test;
import Core.BasePage;
import Page.Login_Element;
import Page.TradePage_Element;
import Test.Common;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderAction extends Common {
    public OrderAction(WebDriver driver) {
        super(driver);
    }
    TradePage_Element tradePageElement = new TradePage_Element();
    Common common= new Common(driver);
    public void BuyOrder (String symbol, String price, String qtty, String qttymu, String orderPass, String order ) throws InterruptedException {
        common.ClickElementPresent(tradePageElement.choosePage);
        Thread.sleep(4000);
        common.ClickElementPresent(tradePageElement.orderType);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.normalOrder);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.buySell);
        Thread.sleep(4000);
        common.ClickElementPresent(tradePageElement.buy);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.symBol,symbol);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.order);
        Thread.sleep(3000);
        switch (order){
            case  "LO":
                common.ClickElementPresent(tradePageElement.lo);
                Thread.sleep(3000);
                common.sendKeysElementPresent(tradePageElement.price, price);
                Thread.sleep(3000);
                break;
            case  "ATO":
                common.ClickElementPresent(tradePageElement.ato);
                Thread.sleep(3000);
                break;
        }

        common.sendKeysElementPresent(tradePageElement.qtty, qtty);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.qtymulti, qttymu);
        Thread.sleep(5000);
        common.ClickElementPresent(tradePageElement.buyBtn);
        common.sendKeysElementPresent(tradePageElement.passOrder,orderPass);
        common.ClickElementPresent(tradePageElement.confirmOrder);
        common.ClickElementPresent(tradePageElement.okBtn);
        String messTran = common.visibilityOfElement(tradePageElement.messTrans).getText();
        Assert.assertEquals(messTran,"Lệnh đặt thành công!");
        System.out.println(messTran);
    }
    public void SellOrder (String symbolS, String priceS, String qttyS, String qttymuS, String orderPass, String order ) throws InterruptedException {
        common.ClickElementPresent(tradePageElement.choosePage);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.orderType);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.normalOrder);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.buySell);
        Thread.sleep(4000);
        common.ClickElementPresent(tradePageElement.sell);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.symBol,symbolS);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.order);
        Thread.sleep(3000);
        switch (order){
            case  "LO":
                common.ClickElementPresent(tradePageElement.lo);
                Thread.sleep(3000);
                common.sendKeysElementPresent(tradePageElement.price, priceS);
                Thread.sleep(3000);
                break;
            case  "ATO":
                common.ClickElementPresent(tradePageElement.ato);
                Thread.sleep(3000);
                break;
        }
        common.ClickElementPresent(tradePageElement.lo);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.price,priceS);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.qtty,qttyS);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.qtymulti,qttymuS);
        Thread.sleep(2000);
        common.ClickElementPresent(tradePageElement.sellBtn);
        common.sendKeysElementPresent(tradePageElement.passOrder,orderPass);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.confirmOrder);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.okBtn);
        common.VerifyDisplay(tradePageElement.messTrans);
        String messTran = common.visibilityOfElement(tradePageElement.messTrans).getText();
        Assert.assertEquals(messTran,"Lệnh đặt thành công!");
        System.out.println(messTran);

    }
}
