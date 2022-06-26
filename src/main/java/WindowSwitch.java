import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowSwitch {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");
            Thread.sleep(5000);

            // Сохраняем идентификатор текущего окна (дискриптор)
            String window1 = driver.getWindowHandle();

            // Через JavaScript открываем новое окно
            js.executeScript("window.open()");

            // Сохраняем в набор все дискрипторы открытых (на текущий момент) окон
            Set<String> currentWindows = driver.getWindowHandles();

            String window2 = null;

            // В переменную window2 запишем дискриптор нового окна
            for (String window: currentWindows) {
                if (!(window.equals(window1))) {
                    window2 = window;
                    break;
                }
            }

            Thread.sleep(3000);

            // Переключаемся на новое окно
            driver.switchTo().window(window2);
            Thread.sleep(2000);
            // В новом окне можем открыть какой-нибудь url
            driver.get("D:\\Programming\\seleniumTestingFromMarshal\\src\\main\\resources\\forAlert.html");
            Thread.sleep(2000);
            // Закрываем текущую вкладку
            driver.close();
            // Переключаемся на первое окно
            Thread.sleep(3000);
            driver.switchTo().window(window1);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
