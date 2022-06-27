package Smoke;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// Класс для автоматического повтора тестов (до 3х раз) в том случае, если тест падает
public class Retry implements IRetryAnalyzer {
    private int actualRetry = 0; // Текущее количество повторений
    private static final int maxRetry = 3;

    public boolean retry(ITestResult result) { // На вход подаём результат, который хотим отслеживать
        if (actualRetry < maxRetry) {
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}
