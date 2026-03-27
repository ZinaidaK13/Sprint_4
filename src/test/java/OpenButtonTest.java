import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class OpenButtonTest extends BaseUITest{
    @Test
    public void openButtonDown() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickCookie();
        mainPage.clickButtonDown();

        String actualText = orderPage.openWindowOrder();
        String expectedText = "Для кого самокат";
        assertEquals("Заголовок не совпадает", expectedText, actualText);

    }
}
