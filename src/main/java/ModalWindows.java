import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ModalWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Создаём экземпляр для явного ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        try {
            driver.get("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");
            Thread.sleep(5000);

            WebElement element1 = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 = driver.findElement(By.id("c"));

            // Кликаем, вызывая Alert
            element1.click();

            // Создаём экземпляр Alert и переключаемся на него (в таком варианте мы не знаем, появился Alert или нет)
            //  Alert alert = driver.switchTo().alert();

            // Ожидаем появление Alert, только потом создаём для него экземпляр
            Alert alert = wait.until(alertIsPresent());
            Thread.sleep(2000);
            // Нажимаем на кнопку OK у окна Alert (принимаем его)
            alert.accept();

            element2.click(); // Кликаем для вызова модального окна с вводом данных
            Alert prompt = wait.until(alertIsPresent()); // Ждём появления окна, записываем его в переменную
            Thread.sleep(2000);
            prompt.sendKeys("Super!!!"); // Вводим в окно данные
            prompt.accept(); // Нажимаем OK

            Alert alert2 = wait.until(alertIsPresent());
            Thread.sleep(2000);
            alert2.accept();

            element3.click(); // Кликаем для вызова Alert с подтверждением/отменой
            Alert alert3 = wait.until(alertIsPresent()); // Ждём появления Alert, записываем его в переменную
            Thread.sleep(2000);
            alert.dismiss(); // На нашем Alert нажимаем "Отмена"


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
