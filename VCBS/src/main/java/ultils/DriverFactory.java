package ultils;


import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private WebDriver webDriver;

    WebDriver getDriver() {
        if(webDriver == null) {
            webDriver = Webdriver.getChromeDriver();
        }
        return webDriver;
    }

//    WebDriver getDriver(String browserName) {
//        if(webDriver == null) {
//            webDriver = Webdriver.getChromeDriver(browserName);
//        }
//        return webDriver;
//    }

    void quitDriver(){
        if(webDriver !=null ){
            webDriver.quit();
            webDriver = null;
        }
    }
}
