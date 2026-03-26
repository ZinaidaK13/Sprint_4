package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    WebDriver driver;


    private static By inputName = By.xpath("//input[@placeholder='* Имя']");
    private static By inputSurname =By.xpath("//input[@placeholder='* Фамилия']");
    private static By inputAddress =By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private static By inputMetro =By.xpath("//input[@placeholder='* Станция метро']");
    private static By inputTelephone =By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static By buttonNext =By.xpath("//button[text()='Далее']");

    private static By inputWhen = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    private static By inputRentalPeriod = By.xpath("//div[contains(text(), 'Срок аренды')]");

    private static By inputColor = By.className("Order_Title__3EKne");

    private static By buttonOrder= By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private static By buttonYes= By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private static By windowOrder =By.className("Order_ModalHeader__3FDaJ");
    private static By headerLocator = By.className("Order_Header__BZXOb");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputName(String name){
        driver.findElement(inputName).sendKeys(name);
    }
    public void setInputSurname(String surname){
        driver.findElement(inputSurname).sendKeys(surname);

    }

    public void setInputAddress(String address){
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setInputTelephone(String telephone){
        driver.findElement(inputTelephone).sendKeys(telephone);
    }

    public void selectMetro(String stationName){
        driver.findElement(inputMetro).click();
        By metroLocator = By.xpath("//*[contains(text(), '" + stationName + "')]");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroLocator))
                .click();
    }

    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }

    public void selectWhen(String dayNumber){
        driver.findElement(inputWhen).click();
        By calendarDay = By.xpath("//div[contains(@class, 'react-datepicker__day--" + dayNumber + "')]");
        driver.findElement(calendarDay).click();
    }

    public void selectRentalPeriod(String periodText){
        driver.findElement(inputRentalPeriod).click();
        By periodOption = By.xpath("//*[@role='option' and text()='" + periodText + "']");
        driver.findElement(periodOption).click();
    }

    public void selectColor(String colorId){
        driver.findElement(inputColor).click();
        By colorOption = By.xpath("//input[@id='" + colorId + "']");
        driver.findElement(colorOption).click();
    }
    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }
    public void clickButtonYes(){
        driver.findElement(buttonYes).click();
    }

    public String OpenOrderHeaderLocator() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(windowOrder));
       return driver.findElement(windowOrder).getText();
    }
   public String openWindowOrder() {
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
       return driver.findElement(headerLocator).getText();
    }
}
