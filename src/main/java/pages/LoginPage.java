package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Automation {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//form[@class='passport-Domik-Form']//div[1]//label[1]//input[1]")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "//form[@class='passport-Domik-Form']//div[2]//label[1]//input[1]")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//span[@class='passport-Button-Text']")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[@class='passport-Domik-Form-Error passport-Domik-Form-Error_active']")
    public WebElement errorMessageUsername;

    @FindBy(how = How.XPATH, using = "//div[@class='passport-Domik-Form-Error passport-Domik-Form-Error_active']")
    public WebElement errorMessagePassword;

    @FindBy(how = How.XPATH, using = "//div[@class='mail-User-Name']")
    public WebElement loginName;

    @FindBy(how = How.XPATH,using = "//span[@id='recipient-1']")
    public WebElement menuButton;

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Выйти из сервисов Яндекса')]")
    public WebElement exit;

    public void loginOnPage(String login, String secret){
        sendText(username,login);
        sendText(password,secret);
        clickOnElement(loginButton);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mail-User-Name']")));
    }

    public void logOut(){
        clickOnElement(menuButton);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Выйти из сервисов Яндекса')]")));
        clickOnElement(exit);
        waiting().until(ExpectedConditions.titleIs("Яндекс"));
    }

    public void loginOnPageWithError(String login, String secret){
        sendText(username,login);
        sendText(password,secret);
        clickOnElement(loginButton);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='passport-Domik-Form-Error passport-Domik-Form-Error_active']")));
    }

}
