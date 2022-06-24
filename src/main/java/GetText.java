import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.avito.ru/rossiya/transport?cd=1");

        WebElement element = driver.findElement(By.cssSelector(".popular-rubricator-count-CX8Mx"));

        // Получение текста элемента так, как видит её пользователь, а не так как она указана в html
        String textElement = element.getText();
        System.out.println(textElement);
    }
}