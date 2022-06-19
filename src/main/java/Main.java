import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        // Установка драйвера, открытие сайта с помощью драйвера

        System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        // Создаём элемент и ссылаемся на него по значению его атрибута
        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));

        // Кликаем на элемент
        input.click();
    }
}
