package util;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static DriverFactory instance;
    private WebDriver driver;

    public DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getWebDriver(){
        driver = FirefoxFactory.getFactoryInstance().createBrowser();
        driver = WebDriverOptions.applyTimeouts(driver);
        driver = WebDriverOptions.applyWindowSettings(driver);
        return driver;
    }
}

