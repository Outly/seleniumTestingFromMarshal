package Smoke;

import org.testng.annotations.Test;

public class Test1 {

    // Группируем тест с помощью groups
    @Test (groups = {"smokeTest", "regress"})
    public void test1 () {
        System.out.println("Test 1");
    }

    @Test (groups = {"regress"})
    public void test11 () {
        System.out.println("Test 11");
    }

    @Test (groups = {"regress"})
    public void test111 () {
        System.out.println("Test 111");
    }
}
