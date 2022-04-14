package testmath;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FactorialWithParametersTest {
    @Parameters
    public static Collection init() {
        return Arrays.asList(
                new Object[][] {
                        {3, 6},
                        {4, 24},
                        {5, 120}
                }
        );
    }
    @Parameter(0)
    public int numberForFactorialRecalc;
    @Parameter(1)
    public int expectedResult;

    @Test
    public void test1() {
        int actualResult = Factorial.factorial(numberForFactorialRecalc);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
