import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waiting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        // Установка неявного ожидания элемента 10 секунд (изменяется значение по умолчанию)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // устаревшая форма записи
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // новая форма записи

        // Установка явного ожидания элемента 10 секунд
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123")))); // ожидание появления элемента по его локатору
    }
}
