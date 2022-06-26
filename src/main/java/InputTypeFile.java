import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InputTypeFile {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        JavascriptExecutor js = (JavascriptExecutor) driver;


        try {
            driver.get("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");
            Thread.sleep(5000);

            // Устанавливаем через js стили так, чтобы элемент был видимый
            js.executeScript("document.querySelector('#d').setAttribute('style', 'opacity:1; display:block; height: 1000px; width: 1000px;')");

            // Прикрепляем с помощью sendKeys необходимый нам файл
            WebElement inputFile = driver.findElement(By.id("d"));
            inputFile.sendKeys("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
