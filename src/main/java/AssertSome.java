import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class AssertSome {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        try {
            driver.get("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");
            Thread.sleep(5000);

            // Берём title страницы
            String title = driver.getTitle();

            // Делаем проверку нашего title на соответствие значению Document
            Assert.assertEquals(title, "Document"); // При несоответствии выйдет AssertionError

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}