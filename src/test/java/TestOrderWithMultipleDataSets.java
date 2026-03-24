import org.junit.Test;
import pages.MainPage;
import pages.OrderPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pages.OrderPage.*;


public class TestOrderWithMultipleDataSets extends BaseUITest {
    @Test
    public void openButtonDawn() {
        MainPage Page = new MainPage(driver);
        Page.openPage();
        Page.clickCookie();
        Page.clickButtonDown();

        String actualText = driver.findElement(headerLocator).getText();
        String expectedText = "Для кого самокат";
        assertEquals("Заголовок не совпадает", expectedText, actualText);

    }

    @Test
    public void checkOdderButton() {
        MainPage Page = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        Page.openPage();
        Page.clickCookie();
        Page.clickButtonTop();
        orderPage.setInputName();
        orderPage.setInputSurname();
        orderPage.setInputAddress();
        orderPage.setInputTelephone();
        orderPage.selectMetro();
        orderPage.clickButtonNext();
        orderPage.selectWhen();
        orderPage.selectRentalPeriod();
        orderPage.selectColor();
        orderPage.clickButtonOrder();
        orderPage.clickButtonYes();

        String actualText = driver.findElement(windowOrder).getText();
        String expectedText = "Заказ оформлен\n" +
                "Номер заказа: .  Запишите его:\n" +
                "пригодится, чтобы отслеживать статус";
        assertEquals("Заголовок не совпадает", expectedText, actualText);
    }
}

