package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    WebDriver driver;

    public static By headerLocator = By.className("Order_Header__BZXOb");
    public static By inputName = By.xpath("//input[@placeholder='* Имя']");
    public static By inputSurname =By.xpath("//input[@placeholder='* Фамилия']");
    public static By inputAddress =By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public static By inputMetro =By.xpath("//input[@placeholder='* Станция метро']");
    public static By inputTelephone =By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static By buttonNext =By.xpath("//button[text()='Далее']");
    public static By inputWhen = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    public static By inputCalendar = By.xpath("//div[contains(@class, 'react-datepicker__day--003')]");
    public static By inputRentalPeriod = By.xpath("//div[contains(text(), 'Срок аренды')]");
    public static By inputPeriod= By.xpath("//*[@role='option' and text()='двое суток']");
    public static By inputColor = By.className("Order_Title__3EKne");
    public static By inputColorBlack = By.xpath("//input[@id='black']");
    public static By buttonOrder= By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    public static By buttonYes= By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    public static By windowOrder =By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputName(){
        driver.findElement(inputName).sendKeys("Иван");
    }

    public void setInputSurname(){
        driver.findElement(inputSurname).sendKeys("Иванов");
    }
    public void setInputAddress(){
        driver.findElement(inputAddress).sendKeys("Москва");
    }
    public void setInputTelephone(){
        driver.findElement(inputTelephone).sendKeys("88888888888");
    }
    public void selectMetro(){
        driver.findElement(inputMetro).click();
        new WebDriverWait(driver,  Duration.ofSeconds (3));
        driver.findElement(By.xpath("//*[contains(text(), 'Рокоссовского')]")).click();
    }

    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }

    public void selectWhen(){
        driver.findElement(inputWhen).click();
        driver.findElement(inputCalendar).click();
    }

    public void selectRentalPeriod(){
        driver.findElement(inputRentalPeriod).click();
        driver.findElement(inputPeriod).click();
    }
    public void selectColor(){
        driver.findElement(inputColor).click();
        driver.findElement(inputColorBlack).click();
    }
    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }
    public void clickButtonYes(){
        driver.findElement(buttonYes).click();
    }
}
