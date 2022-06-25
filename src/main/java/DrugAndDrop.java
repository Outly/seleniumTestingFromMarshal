import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DrugAndDrop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // обрабатываем исключения
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000); // Ждём 2 секунды чтобы сайт подгрузился
            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);

            // собираем наше действие для drag and drop
            actions.moveToElement(element1)
                    .clickAndHold()
                    .moveToElement(element2)
                    .release()
                    .build()
                    .perform();

            actions.dragAndDrop(element1, element2); // Альтернативнй способ выболнить drag and drop

            actions.dragAndDropBy(element1, 100, 100) // Drag and drop по координатам
                    .build()
                    .perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(10000);
            driver.quit(); // Закрываем созданный драйвер
        }

    }
}
