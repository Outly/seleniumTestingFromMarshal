package PageObject;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class WorkPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");
            Thread.sleep(5000);

            // Создаём экземпляр класса
            LoginPage lp = new LoginPage();

            // Реализовываем логику из класса LoginPage в классе WorkPage
            lp.login("admin", "admin");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
