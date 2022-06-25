import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathExamples {
    public static void main(String[] args) {

        // Установка драйвера, открытие сайта с помощью драйвера

        System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        // Создаём элемент и ссылаемся на него по тегу и значению его атрибута
        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));

        // Кликаем на элемент
        input.click();

        /* Примеры xpath
            //div[@class='g'][6] - поиск элемента с тегом div,
                                    атрибутом class,
                                    значением атрибута g,
                                    с порядковым номером 6, если таких несколько
            //h3[contains(@class,'MBeuO')] - поиск элемента по части значения атрибута
            //div[@class='r21Kzd'][last()] - последний, если таких элементов несколько
            //*[text()='Альметьевск - Википедия']- поиск через полный текст, который есть внутри тега
                                    в данном случае, любого тега *
            //h3[contains(text(),'Артемьевск в Тюмени на карте')] - поиск по не полному тексту в рунтри тега
            //div[@class='yuRUbf']//a[@target='_blank'] - поиск элемента внутри другого элемента
            //div[@data-hveid='CDgQAA']/.. - обращение к родителю найденного элемента
            //div[@data-hveid='CDgQAA']/parent::div - - обращение по тегу к родителю найденного элемента
            //div[@data-hveid='CDgQAA']/following-sibling::div - обращение по тегу к соседнему от найденного элемента

         */
    }
}
