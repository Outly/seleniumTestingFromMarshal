package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Создаём класс с функцией авторизации login
// Выносим логику в отдельный класс, реализовывать будем в классе WorkPage
public class LoginPage {
    WebDriver driver = new ChromeDriver();

    WebElement loginInput = driver.findElement(By.id("input"));
    WebElement passInput = driver.findElement(By.id("pass"));
    WebElement enter = driver.findElement(By.id("enter"));

    public void login (String login, String password) {
        loginInput.sendKeys(login);
        passInput.sendKeys(password);
        enter.click();
    }
}
