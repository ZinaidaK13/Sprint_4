package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    By cookie =By.className("App_CookieButton__3cvqF");
    private static final String BASEURL="https://qa-scooter.praktikum-services.ru";
    private By[] questions = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };
    private By[] answers = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };
    private static By buttonOrderTop = By.className("Button_Button__ra12g");
    private static By buttonOrderDown = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(BASEURL);
    }

    public void clickCookie() {
        driver.findElement(cookie).click();
    }
    public void clickQuestion(int index) {
        driver.findElement(questions[index]).click();
    }
    public String getAnswerText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answers[index]));
        return driver.findElement(answers[index]).getText();
    }

    public void clickButtonDown(){
        driver.findElement(buttonOrderDown).click();
    }

    public void clickButtonTop(){
        driver.findElement(buttonOrderTop).click();
    }


}
