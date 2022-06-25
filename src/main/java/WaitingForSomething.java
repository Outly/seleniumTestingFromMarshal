import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class WaitingForSomething {
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

            // Ожидаем вхождение значения в атрибуте
            wait.until(ExpectedConditions.attributeContains(elements.get(3), "class", "something"));
            // Ожидаем полного сответствия значения атрибута
            wait.until(ExpectedConditions.attributeToBe(elements.get(2), "class", "something"));
            // Ожидаем непустое значение атрибута
            wait.until(ExpectedConditions.attributeToBeNotEmpty(elements.get(3), "class"));

            // Ожидаем, что элемент выбран (напримен чек-бокс)
            wait.until(ExpectedConditions.elementToBeSelected(elements.get(3)));
            // Ожидаем, что элемент видимый и можно ли по нему кликнуть
            wait.until(ExpectedConditions.elementToBeClickable(elements.get(3)));

            // Ожидаем то, что элемент невидим
            wait.until(ExpectedConditions.invisibilityOf(elements.get(3)));
            // Ожидаем то, что все элементы списка невидимы
            wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
            // Ожидаем то, что элемент невидим или отсутствует в доме по локатору
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='paginationjs-pages']")));
            // Ожидаем то, что элемент невидим или отсутствует в доме по тексту
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@class='paginationjs-pages']"), "Найти"));

            // Все вышеперечисленные методы работают для visibility
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));

            // not делает ожидание противоположным тому, что в скобках
            wait.until(not(ExpectedConditions.elementToBeSelected(elements.get(3))));

            // Ожидаем количество элементов с данным локатором
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='paginationjs-pages']"), 400));
            // Ожидаем количество элементов с данным локатором меньше, чем указанное число
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class='paginationjs-pages']"), 400));
            // Ожидаем количество элементов с данным локатором больше, чем указанное число
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='paginationjs-pages']"), 400));

            // Ожидаем появление всех элементов на web-странице по локатору
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='paginationjs-pages']")));
            // Ожидаем появление элемента в DOMе страницы
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='paginationjs-pages']")));

            // Ожидаем повление элемента, содержащего текст, равный данному
            wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='paginationjs-pages']"), "Найти"));
            // Ожидаем повление элемента, в котором присутствует текст
            wait.until(ExpectedConditions.textToBePresentInElement(elements.get(3), "Найти"));
            // Ожидаем появления элемента, у которого текст атрибута содержит значение
            wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//div[@class='paginationjs-pages']"), "something"));

            // Ожидаем title равный указанному
            wait.until(ExpectedConditions.titleIs("some title"));
            // Ожидаем title, содержащий указанный текст
            wait.until(ExpectedConditions.titleContains("Some part of title"));

            // Ожидаем, что url содержит текст
            wait.until(ExpectedConditions.urlContains("something"));
            // Ожидаем, что url будет равен указанному
            wait.until(ExpectedConditions.urlToBe("some url"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
