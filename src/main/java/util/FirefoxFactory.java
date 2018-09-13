package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;

public class FirefoxFactory {

    private static FirefoxFactory factoryInstance;

    public FirefoxFactory() {
    }

    static FirefoxFactory getFactoryInstance(){
        if(factoryInstance == null){
            factoryInstance = new FirefoxFactory();
        }
        return factoryInstance;
    }

    WebDriver createBrowser(){
        return createBrowserWithGeckoDriver();
    }

    private FirefoxDriver createBrowserWithGeckoDriver(){
        initGeckoDriver();
        return new FirefoxDriver(setFirefoxOptions());
    }

    private void initGeckoDriver(){
        final String GECKO_DRIVER_ENV = "webdriver.gecko.driver";

        String envvalue = System.getenv("webdriver.gecko.driver");
        if (envvalue == null){
            throw new WebDriverException("User's enviroment variable " + GECKO_DRIVER_ENV + " is not defined");
        }

        File file = new File(envvalue);

        if (file.exists()){
            System.setProperty(GECKO_DRIVER_ENV,envvalue);
        }else{
            throw new WebDriverException("User's enviroment variable " + GECKO_DRIVER_ENV
                    + " is not set or has incorrect path " + file.getPath());
        }
    }

    private FirefoxOptions setFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();

        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        options.addPreference("browser.tabs.remote.autostart.2",false);

        options.setProfile(profile);
        return options;
    }
}
