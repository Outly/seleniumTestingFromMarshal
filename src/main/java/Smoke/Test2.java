package Smoke;

import org.testng.annotations.Test;

public class Test2 {

    @Test
    public void test2 () {
        System.out.println("Test 2");
    }

    @Test (groups = {"smokeTest"})
    public void test22 () {
        System.out.println("Test 22");
    }
}
