package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation {

    private WebDriver driver;
    int DEFAULT_TIMEOUT = 10;

    Automation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public BasePage openBasePage(){
        driver.get("https://yandex.by");
        waiting().until(ExpectedConditions.titleContains("Яндекс"));
        return new BasePage(driver);
    }

    public WebDriverWait waiting(){
        return new WebDriverWait(driver,DEFAULT_TIMEOUT);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public static void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }
}
