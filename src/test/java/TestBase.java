import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.Automation;
import pages.BasePage;
import pages.LoginPage;
import util.DriverFactory;

public class TestBase {

    public WebDriver driver;
    public Automation startPage;
    public BasePage basePage;
    public LoginPage loginPage;

    @Before
    public void setup() {
        driver = DriverFactory.getInstance().getWebDriver();
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        startPage = basePage.openBasePage();
    }
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }



}
