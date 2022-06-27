package Smoke;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    // Группируем тест с помощью groups
    // В параметрах указываем переменную db
    @Parameters ("db")
    @Test (groups = {"smokeTest"})
    public void test1 (String db) {
        System.out.println("Test 1" + db);
    }

    @Test (groups = {"regress"})
    public void test11 () {
        System.out.println("Test 11");
    }

    @Test (groups = {"regress"},
            // dependsOnGroups = "smokeTest", // Делает данный тест зависимым от группы тестов smokeTest
            dependsOnMethods = "test11", // Делает данный тест зависимым от теста test11
            alwaysRun = true) // С данной настройкой зависимый тест выполняется всегда, если false, то выполняется в случае пройденного test11
    public void test111 () {
        System.out.println("Test 111");
    }
}
