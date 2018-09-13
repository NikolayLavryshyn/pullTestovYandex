import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestA extends TestBase {

    @Before
    public void init() {
        loginPage = basePage.openLoginPage(driver);
    }

    //Логин на яндекс почту:
    @Test
    public void checkLogin(){
        String username = "AutotestUser";
        String password = "AutotestUser123";
        loginPage.loginOnPage(username,password);
        Assert.assertEquals(username,loginPage.loginName.getText());
    }

    //Яндекс почта - логаут:
    @Test
    public void checkLogout(){
        checkLogin();
        loginPage.logOut();
        Assert.assertEquals("Яндекс",driver.getTitle());
    }

    @Test
    public void checkPasswordAreNotValid(){
        String username = "AutotestUser";
        String password = " NoAutotestUser123";
        loginPage.loginOnPageWithError(username,password);
        Assert.assertEquals("Неверный пароль",loginPage.errorMessagePassword.getText());

    }

    @Test
    public void checkUsernameAreNotValid(){
        String username = "NoAutotestUser";
        String password = " AutotestUser123";
        loginPage.loginOnPageWithError(username,password);
        Assert.assertEquals("Такого аккаунта нет",loginPage.errorMessagePassword.getText());

    }

    @Test
    public void checkNavigateOnTabs(){
        basePage.navigateOnVideo();
        Assert.assertEquals("https://yandex.by/video/",driver.getCurrentUrl());

        driver.navigate().back();

        basePage.navigateOnMaps();
        Assert.assertEquals("Яндекс.Карты — подробная карта Беларуси и мира",driver.getTitle());

        driver.navigate().back();

        basePage.navigateOnMarket();
        Assert.assertEquals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов",driver.getTitle());

        driver.navigate().back();

        basePage.navigateOnPictures();
        Assert.assertEquals("Яндекс.Картинки: поиск изображений в интернете, поиск по картинке",driver.getTitle());

        driver.navigate().back();

        basePage.navigateOnNews();
        Assert.assertEquals("Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости Беларуси онлайн",driver.getTitle());

        driver.navigate().back();

        basePage.navigateOnTranslater();
        Assert.assertEquals("Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки.",driver.getTitle());

        driver.navigate().back();

        basePage.navigateOnMusic();
        Assert.assertEquals("Яндекс.Музыка",driver.getTitle());
    }

    @Test
    public void changeLanguage(){
        basePage.changeLanguage();
        Assert.assertEquals("Interface language",basePage.textEng.getText());
    }
}
