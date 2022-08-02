package Page;

import Core.BaseTest;
import org.openqa.selenium.By;

public class Product_Element extends BaseTest {
    public By _product = By.xpath("//a[@href=\"/Admin/Product/List\"]//p[contains(text(),'Products')]");
    public By _addNew = By.xpath("//a[@href=\"/Admin/Product/Create\"]");
    public By _export = By.xpath("//button[@class = 'btn btn-success']");
    public By _import = By.xpath("//button[@name= 'importexcel']");
    public By _download = By.xpath("//button[@name= 'download-catalog-pdf']");
    public By _wareHouse = By.xpath("//label[text()='Warehouse']");
    public By _category = By.xpath("//label[text()='Category']");
    public By _productName = By.xpath("//label[text()='Product name']");
    public By _delete = By.id("delete-selected");
    //add
    public By _productNameText = By.id("Name");
    public By _descript = By.id("ShortDescription");
    public By _sku = By.id("Sku");
    public By _selectCatoClick = By.xpath("//input[@aria-labelledby='SelectedCategoryIds_label']");
    public By _slectedCato = By.xpath("(//ul[@id='SelectedCategoryIds_listbox']//li)[1]");
    public By _price = By.xpath("//input[@id='Price']//preceding-sibling::input");
    public By _save = By.xpath("//button[@name='save']");
    public By price = By.xpath("//input[@id='Price']/preceding-sibling::input");
    public By oldPrice = By.xpath("//input[@id='OldPrice']/preceding-sibling::input");
    public By _oldPrice = By.xpath("//input[@id='OldPrice']//preceding-sibling::input");

}
