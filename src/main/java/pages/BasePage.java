package pages;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.*;

public class BasePage extends Automation {

    public BasePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH, using = "//div[@aria-label='Авторизация']//a[@role='button']")
    public WebElement buttonToMail;

    @FindBy(how = How.XPATH, using = "//span[@class='link__inner']//span[contains(text(),'Rus')]")
    public WebElement textSwitcher;

    @FindBy(how = How.XPATH, using = "//a[@class='link'][contains(text(),'ещё')]")
    public WebElement more;

    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    public WebElement button;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'English')]")
    public WebElement buttonEng;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement buttonSave;

    @FindBy(how = How.XPATH, using = "//h1[@class='options__header']")
    public WebElement textEng;

    @FindBy(how = How.XPATH, using = "//a[@data-metrics='Клик на Вернуться на сервис']")
    public WebElement back;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Видео')]")
    public WebElement video;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Карты')]")
    public WebElement maps;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Маркет')]")
    public WebElement market;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Картинки')]")
    public WebElement pictures;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Новости')]")
    public WebElement news;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Переводчик')]")
    public WebElement translater;

    @FindBy(how = How.XPATH, using = "//a[@class='home-link home-link_blue_yes home-tabs__link home-tabs__search'][contains(text(),'Музыка')]")
    public WebElement music;

    @FindBy(how = How.XPATH, using = "//input[@id='header-search']")
    public WebElement searchField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div[@data-id='model-1731400948']//i[@class='image image_name_compare']")
    public WebElement addFirstElement;

    @FindBy(how = How.XPATH, using = "//div[@data-id='model-1731400948']//i[@class='image image_name_compare']")
    public WebElement addSecondElement;

    @FindBy(how = How.XPATH, using = "//a[@class='button button_size_m button_theme_normal i-bem button_js_inited']")
    public WebElement compareButton;

    @FindBy(how = How.XPATH, using = "//img[contains(@title,'Смартфон Samsung Galaxy Note8 64GB')]")
    public WebElement imgPhone;

    @FindBy(how = How.XPATH, using = "//img[contains(@title,'Смартфон Samsung Galaxy Note8 128GB')]")
    public WebElement imgPhone2;

    @FindBy(how = How.XPATH, using = "//a[@class='link topmenu__link'][contains(text(),'Электроника')]")
    public WebElement electronics;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Экшн-камеры')]")
    public WebElement camers;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'по цене')]")
    public WebElement sortButton;

    @FindBy(how = How.XPATH, using = "//div[@data-id='model-1731400948']//a[@class='link n-smart-link i-bem n-smart-link_js_inited link_js_inited']/div")
    public WebElement firstPrice;

    @FindBy(how = How.XPATH, using = "//div[@data-id='model-1731400948']//a[@class='link n-smart-link i-bem n-smart-link_js_inited link_js_inited']/div")
    public WebElement secondPrice;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Удалить список')]")
    public WebElement deleteFromCompareButton;

    @FindBy(how = How.XPATH, using = "//a[@class='link topmenu__link'][contains(text(),'Бытовая техника')]")
    public WebElement houseElectronics;

    @FindBy(how = How.XPATH, using = "//div[@data-452ecda2='true']//div[2]//div[1]//div[1]//a[1]")
    public WebElement frigerators;

    @FindBy(how = How.XPATH, using = "//input[@id='15464317to']")
    public WebElement sizeField;

    @FindBy(how = How.XPATH, using = "//div[@data-id='model-1731307808']//ul[@class='n-snippet-card2__desc n-snippet-card2__desc_type_list']/li[1]")
    public WebElement frigeratorSize;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Трек, альбом, исполнитель']")
    public WebElement musicSearch;

    @FindBy(how = How.XPATH, using = "//div[@class='d-suggest__items d-suggest__items_type_album']//div[2]//a[1]")
    public WebElement metallica;

    @FindBy(how = How.XPATH, using = "//h1[@class='deco-typo']")
    public WebElement artistMetallica;

    @FindBy(how = How.XPATH, using = "//div[@class='d-album-summary__pregroup']//div")
    public WebElement albumMetallica;

    @FindBy(how = How.XPATH, using = "//div[@class='title title_size_18']")
    public WebElement noElementsToCompare;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Смартфон Samsung Galaxy Note8 128GB')]")
    public WebElement phoneName1;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Смартфон Samsung Galaxy Note8 64GB')]")
    public WebElement phoneName2;



    public LoginPage openLoginPage(WebDriver driver){
        buttonToMail.click();
        waiting().until(ExpectedConditions.titleContains("Авторизация"));
        return new LoginPage(driver);
    }

    public void changeLanguage(){
        clickOnElement(back);
        waiting().until(ExpectedConditions.visibilityOf(textSwitcher));
        clickOnElement(textSwitcher);
        clickOnElement(more);
        waiting().until(ExpectedConditions.visibilityOf(button));
        clickOnElement(button);
        waiting().until(ExpectedConditions.visibilityOf(buttonEng));
        clickOnElement(buttonEng);
        clickOnElement(buttonSave);
        waiting().until(ExpectedConditions.visibilityOf(textSwitcher));
        clickOnElement(textSwitcher);
        clickOnElement(more);
        waiting().until(ExpectedConditions.visibilityOf(button));
    }

    public void navigateOnVideo(){
        clickOnElement(back);
        waiting().until(ExpectedConditions.visibilityOf(textSwitcher));
        clickOnElement(video);
    }

    public void navigateOnMaps(){
        clickOnElement(maps);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='route-control__inner']//button[@type='button']")));
    }

    public void navigateOnMarket(){
        clickOnElement(market);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
    }
    public void navigateOnPictures(){
        clickOnElement(pictures);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon icon_type_cbir textinput__cbir']")));
    }

    public void navigateOnNews(){
        clickOnElement(news);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Новости']")));
    }
    public void navigateOnTranslater(){
        clickOnElement(translater);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='name']")));
    }

    public void navigateOnMusic(){
        clickOnElement(music);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='d-logo__ya-sub']")));
    }

    public void addElementsToCompare(WebDriver driver,String name){
        sendText(searchField,name);
        clickOnElement(searchButton);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='Мобильные телефоны']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(imgPhone).build().perform();
        waiting().until(ExpectedConditions.elementToBeClickable(addFirstElement));
        clickOnElement(addFirstElement);
        actions.moveToElement(imgPhone2).build().perform();
        waiting().until(ExpectedConditions.visibilityOf(addSecondElement));
        clickOnElement(addSecondElement);
        waiting().until(ExpectedConditions.visibilityOf(compareButton));
        clickOnElement(compareButton);
    }

    public void deleteFromComparing(){
        waiting().until(ExpectedConditions.elementToBeClickable(deleteFromCompareButton));
        clickOnElement(deleteFromCompareButton);
        waiting().until(ExpectedConditions.visibilityOf(noElementsToCompare));
    }

    public void sortPrice(){
        clickOnElement(electronics);
        waiting().until(ExpectedConditions.visibilityOf(camers));
        clickOnElement(camers);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='Экшн-камеры']")));
        clickOnElement(sortButton);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Экшн-камера Smarterra B1')]")));
        clickOnElement(sortButton);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Экшн-камера GoPro Fusion (CHDHZ-103)')]")));
        waiting().until(ExpectedConditions.visibilityOf(firstPrice));
    }

    public void sortTag(String size){
        clickOnElement(houseElectronics);
        waiting().until(ExpectedConditions.visibilityOf(frigerators));
        clickOnElement(frigerators);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='Холодильники']")));
        sendText(sizeField,size);
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='Холодильники шириной до 50 см']")));
    }

    public void searchMusic(WebDriver driver,String genre){
        waiting().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='d-logo__ya-sub']")));
        sendText(musicSearch, genre);

        waiting().until(ExpectedConditions.elementToBeClickable(metallica));
        clickOnElement(metallica);
    }
}