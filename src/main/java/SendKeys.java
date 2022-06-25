import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SendKeys {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.udemy.com/");

        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Ищите что угодно']"));

        // В найденный элемент input вводим текст Java и нажимаем ENTER
        input.sendKeys("Java", Keys.ENTER);
    }
}
