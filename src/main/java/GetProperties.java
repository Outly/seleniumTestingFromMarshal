import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class GetProperties {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.avito.ru/rossiya/transport?cd=1");

        WebElement element = driver.findElement(By.xpath("//a[@title='Audi'][1]"));
        // Получение значения свойства элемента (свойство offsetWidth, значение выводим)
        String parametr = element.getAttribute("offsetWidth");
        System.out.println(parametr);
    }
}
