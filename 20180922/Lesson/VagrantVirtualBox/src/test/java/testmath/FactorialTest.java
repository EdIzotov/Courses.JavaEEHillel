package testmath;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void test1() {
        int fact = 3;
        int actualResult = Factorial.factorial(fact);
        Assert.assertEquals(6, actualResult);
    }
    @Test
    public void test2() {
        int fact = 4;
        int actualResult = Factorial.factorial(fact);

        assert actualResult == 24 : "Invalid value for 3!";
    }
    @Test
    public void test3() {
        int fact = 5;
        int actualResult = Factorial.factorial(fact);

        assert actualResult == 120 : "Invalid value for 3!";
    }
}
