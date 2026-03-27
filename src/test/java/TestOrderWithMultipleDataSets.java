import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pages.OrderPage.*;

@RunWith(Parameterized.class)
public class TestOrderWithMultipleDataSets extends BaseUITest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String metroStation;
    private final String calendarDay;      // день месяца
    private final String rentalPeriod;     // срок аренды
    private final String colorId;

    public TestOrderWithMultipleDataSets(String name, String surname, String address, String phone, String metroStation, String calendarDay, String rentalPeriod, String colorId) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metroStation = metroStation;
        this.calendarDay = calendarDay;
        this.rentalPeriod= rentalPeriod;
        this.colorId=colorId;
    }
    @Parameterized.Parameters()
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"Иван", "Иванов", "Москва", "88888888888", "Сокольники", "003", "двое суток", "black"},
                {"Петр", "Петров", "Санкт-Петербург", "99999999999", "Рокоссовского", "015", "сутки", "grey"}
        });
    }
@Test
    public void checkOrderButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openPage();
        mainPage.clickCookie();
        mainPage.clickButtonTop();

        orderPage.setInputName(name);
        orderPage.setInputSurname(surname);
        orderPage.setInputAddress(address);
        orderPage.setInputTelephone(phone);
        orderPage.selectMetro(metroStation);

        orderPage.clickButtonNext();

    orderPage.selectWhen(calendarDay);           // ← параметр со Страницы 2
    orderPage.selectRentalPeriod(rentalPeriod);  // ← параметр со Страницы 2
    orderPage.selectColor(colorId);

    orderPage.clickButtonOrder();
        orderPage.clickButtonYes();

    String actualText = orderPage.OpenOrderHeaderLocator() ;
         assertTrue("Текст не содержит 'Заказ оформлен'. Фактический: " + actualText,
         actualText.contains("Заказ оформлен"));
    }

}

