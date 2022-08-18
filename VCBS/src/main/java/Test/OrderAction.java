package Test;
import Core.BasePage;
import Page.Login_Element;
import Page.TradePage_Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrderAction extends Common {
    public OrderAction(WebDriver driver) {
        super(driver);
    }
    TradePage_Element tradePageElement = new TradePage_Element();
    Common common= new Common(driver);
    public void BuyOrder (String symbol,String orderType, String price, String qtty, String qttymu, String orderPass) throws InterruptedException {
        common.ClickElementPresent(tradePageElement.choosePage);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.orderType);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.normalOrder);
        Thread.sleep(1000);
        common.ClickElementPresent(tradePageElement.buySell);
        Thread.sleep(1000);
        common.ClickElementPresent(tradePageElement.buy);
        Thread.sleep(1000);
        common.sendKeysElementPresent(tradePageElement.symBol,symbol);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.order);
        Thread.sleep(2000);
        switch (orderType){
            case  "LO":
                common.ClickElementPresent(tradePageElement.lo);
                Thread.sleep(2000);
                common.sendKeysElementPresent(tradePageElement.price, price);
                Thread.sleep(2000);
                break;
            case  "ATO":
                common.ClickElementPresent(tradePageElement.ato);
                Thread.sleep(1000);
                break;
            case  "ATC":
                common.ClickElementPresent(tradePageElement.atc);
                Thread.sleep(1000);
                break;
        }

        common.sendKeysElementPresent(tradePageElement.qtty, qtty);
        Thread.sleep(1000);
        common.sendKeysElementPresent(tradePageElement.qtymulti, qttymu);
        Thread.sleep(1000);
        common.ClickElementPresent(tradePageElement.buyBtn);
        common.sendKeysElementPresent(tradePageElement.passOrder,orderPass);
        common.ClickElementPresent(tradePageElement.confirmOrder);
        Thread.sleep(2000);
        WebElement messTransactionBuy = driver.findElement(By.id("messageErrorDiv"));
        String messTranBuy = messTransactionBuy.getText();
       // String messTran = common.visibilityOfElement(tradePageElement.messTrans).getText();
        System.out.println(messTranBuy);
        Assert.assertEquals(messTranBuy,"Lệnh đặt thành công!");
        common.ClickElementPresent(tradePageElement.okBtn);

    }
    public void SellOrder (String symbolS,String orderType, String priceS, String qttyS, String qttymuS, String orderPass) throws InterruptedException {
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
        switch (orderType){
            case  "LO":
                common.ClickElementPresent(tradePageElement.lo);
                Thread.sleep(2000);
                common.sendKeysElementPresent(tradePageElement.price, priceS);
                Thread.sleep(2000);
                break;
            case  "ATO":
                common.ClickElementPresent(tradePageElement.ato);
                Thread.sleep(1000);
                break;
            case  "ATC":
                common.ClickElementPresent(tradePageElement.atc);
                Thread.sleep(1000);
                break;
        }
        common.sendKeysElementPresent(tradePageElement.qtty,qttyS);
        Thread.sleep(3000);
        common.sendKeysElementPresent(tradePageElement.qtymulti,qttymuS);
        Thread.sleep(2000);
        common.ClickElementPresent(tradePageElement.sellBtn);
        common.sendKeysElementPresent(tradePageElement.passOrder,orderPass);
        Thread.sleep(3000);
        common.ClickElementPresent(tradePageElement.confirmOrder);
        Thread.sleep(3000);
        WebElement messTransactionSell = driver.findElement(By.id("messageErrorDiv"));
        String messTranSell = messTransactionSell.getText();
        // String messTran = common.visibilityOfElement(tradePageElement.messTrans).getText();
        System.out.println(messTranSell);
        Assert.assertEquals(messTranSell,"Lệnh đặt thành công!");
        common.ClickElementPresent(tradePageElement.okBtn);

    }
}
