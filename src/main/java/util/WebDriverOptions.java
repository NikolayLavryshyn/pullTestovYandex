package util;

        import org.openqa.selenium.WebDriver;

        import java.util.concurrent.TimeUnit;

public class WebDriverOptions {

    private static WebDriver.Timeouts elementSearchTimeout;
    private static WebDriver.Timeouts pageLoadTimeout;
    private static WebDriver.Timeouts scripttimeout;

    static WebDriver applyTimeouts(WebDriver driver){
        pageLoadTimeout = driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        scripttimeout = driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        return driver;
    }

    static WebDriver applyWindowSettings(WebDriver driver){
        driver.manage().window().maximize();
        return driver;
    }
}
