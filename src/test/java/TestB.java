import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestB extends TestBase {

    @Before
    public void init() {
        basePage = startPage.openBasePage();
    }

    //Яндекс маркет - добавление в сравнение
    @Test
    public void addToCompare() {
        basePage.navigateOnMarket();
        basePage.addElementsToCompare(driver, "Note 8");
        Assert.assertEquals("Смартфон Samsung Galaxy Note8 128GB",basePage.phoneName1.getText());
        Assert.assertEquals("Смартфон Samsung Galaxy Note8 64GB",basePage.phoneName2.getText());
    }

    //- Удаление добавленных товаров :
    @Test
    public void deleteItemsFromCompare() {
        addToCompare();
        basePage.deleteFromComparing();
        Assert.assertEquals("Товаров нет. Чтобы увидеть ранее добавленные вами товары, авторизуйтесь.",basePage.noElementsToCompare.getText());
    }

    //- Яндекс маркет - сортировка по цене:
    @Test
    public void sortByPrice() {
        basePage.navigateOnMarket();
        basePage.sortPrice();
        System.out.println(basePage.firstPrice.getText());
        System.out.println(basePage.secondPrice.getText());
        Assert.assertNotSame(basePage.firstPrice.getText(), basePage.secondPrice.getText());
    }

    //Яндекс маркет - сортировка по тегу:
    @Test
    public void sortByTag() {
        basePage.navigateOnMarket();
        basePage.sortTag("50");
        System.out.println(basePage.frigeratorSize.getText().substring(0, 2));
        Assert.assertTrue(50 >= Integer.valueOf(basePage.frigeratorSize.getText().substring(0, 2)));
    }

    //Яндекс - музыка:
    @Ignore
    @Test
    public void searchMusic() {
        basePage.navigateOnMusic();
        basePage.searchMusic(driver,"Metal");
        Assert.assertEquals("Metallica",basePage.albumMetallica.getText());
        System.out.println(basePage.artistMetallica.getText());
        Assert.assertEquals("Metallica",basePage.artistMetallica.getText());
    }

    @Ignore
    @Test
    //Яндекс - музыка - вопроизведение:
    public void playMusic(){
        basePage.navigateOnMusic();
        basePage.searchMusic(driver,"beyo");
    }
}
