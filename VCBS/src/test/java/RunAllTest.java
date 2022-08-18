import Core.BaseTest;
import Core.ExcelUtils;
import Test.LoginAction;
import Test.OrderAction;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunAllTest extends BaseTest {

    @DataProvider
    public Object[][] getData() throws InvalidFormatException {
        //String path = "D:\\VyNguyen\\Autoweb\\DATA\\Login.xlsx";
        String path = "D:\\VyNguyen\\Autoweb\\DATA\\Sell.xlsx";
        ExcelUtils excel = new ExcelUtils();
        Object data[][] = excel.getTestData("data", path);
        return data;
    }


    @Test(dataProvider = "getData")
    public void BuyAction (String user, String pass, String symbol,String orderType, String price, String qtty, String qttymu, String orderPass) throws InterruptedException {
        LoginAction login = new LoginAction(driver);
        login.Login(user,pass);
        OrderAction orderAction = new OrderAction(driver);
        orderAction.BuyOrder(symbol,orderType,price,qtty,qttymu,orderPass);

    }
    @Test(dataProvider = "getData")
    public void SellAction (String user, String pass, String symbol, String price, String qtty, String qttymu, String orderPass, String order) throws InterruptedException {
        LoginAction login = new LoginAction(driver);
        System.out.printf(user,pass, symbol);
        login.Login(user,pass);
        OrderAction orderAction = new OrderAction(driver);
        orderAction.SellOrder(symbol,price,qtty,qttymu,orderPass, order);

    }

}
