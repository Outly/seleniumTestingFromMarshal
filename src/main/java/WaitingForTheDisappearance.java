import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitingForTheDisappearance {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Создаём экземпляр ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);

            // Создаём 2 списка: с элементами страницы, со страницами
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

            String text = elements.get(5).getText(); // Заберём текст 5-го элемента
            System.out.println(text);

            pages.get(2).click(); // Меняем страничку
            wait.until(ExpectedConditions.stalenessOf(elements.get(5))); // Ожидаем исчезновения элемента с первой открытой страницы

            elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li")); // Обновляем список элементов, взяв их с новой страницы

            text = elements.get(5).getText(); // Заберём текст 5-го элемента после обновления
            System.out.println(text);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(10000);
            driver.quit();
        }

    }
}
