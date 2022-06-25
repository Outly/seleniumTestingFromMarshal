import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Actions {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.udemy.com/");

        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Ищите что угодно']"));

        // Очищает поле ввода, в котором что-либо введено
        input.clear();

        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);

        // Клик правой кнопкой мыши
        actions.contextClick();

        // Клик левой кнопкой мыши с удержанием
        actions.clickAndHold();

        // Двойное нажатие левой кнопкой мыши
        actions.doubleClick();

        // Вызов паузы на 3 секунды
        actions.pause(3000);

        actions
                .moveToElement(input) // Наввести курсор на элемент
                .keyDown(Keys.ENTER) // Нажимаем на кнопку
                .keyUp(Keys.ENTER) // Отжимаем нажатую кнопку
                .release() // Отпустить зажатую левую кнопку мыши
                .build() // Собираем созданную последовательность
                .perform(); // Применяем созданную последовательность

    }
}
