package Smoke;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {

    // Провайдер позволяет использовать набор тестовых данных
    @DataProvider (name = "provider")
    public static Object[][] dbData () {
        return new Object[][] {
                {"SQL", new Integer(1)},
                {"noSQL", new Integer(2)}
        };
    }


    @Test (dataProvider = "provider", // Подключение провайдера и использование данных из него
            retryAnalyzer = Retry.class) // Подключаем написанный retryAnalyzer
    public void test2 (String elem1, int elem2) {
        System.out.println("Test 2" + " " + elem1 + " " + elem2);
        Assert.fail(); // Ломаем наш тест
    }



}
