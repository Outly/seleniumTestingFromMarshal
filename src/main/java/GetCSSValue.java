import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class GetCSSValue {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://devby.io/");

        WebElement element = driver.findElement(By.xpath("//a[text()='Вход']"));

        // Получение значения свойства display из css элемента
        String cssValue = element.getCssValue("display");
        System.out.println(cssValue);
    }
}
