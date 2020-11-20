package TestOrganization.unit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class Calculator {

    @DataProvider
    private Object[][] sumDataProvider() {
        return new Object[][]{
                {30, 12, 42},
                {0, 55, 55},
                {-14, -6, -20}
        };
    }

    @DataProvider
    private Object[][] subDataProvider() {
        return new Object[][]{
                {30, 15, 15},
                {0, 55, -55},
                {-14, -4, -10}
        };
    }

    @DataProvider
    private Object[][] mulDataProvider() {
        return new Object[][]{
                {112358, 0, 0},
                {-1, 243, -243},
        };
    }

    @DataProvider
    private Object[][] divDataProvider() {
        return new Object[][]{
                {0, 12, 0},
                {400, 1, 400},
                {-8, -2, 4},
                {-8, 2, -4},
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void testSum(int firstNumber, int secondNumber, int expectedResult) {
        Assert.assertEquals(unit.Calculator.add(firstNumber, secondNumber), expectedResult,
                "Houston we have problems!\n");
    }

    @Test(dataProvider = "subDataProvider")
    public void testSub(int firstNumber, int secondNumber, int expectedResult) {
        Assert.assertEquals(unit.Calculator.sub(firstNumber, secondNumber), expectedResult,
                "Houston we have problems!\n");
    }

    @Test(dataProvider = "mulDataProvider")
    public void testMul(int firstNumber, int secondNumber, int expectedResult) {
        Assert.assertEquals(unit.Calculator.mul(firstNumber, secondNumber), expectedResult,
                "Houston we have problems!\n");
    }

    @Test(dataProvider = "divDataProvider")
    public void testDiv(int firstNumber, int secondNumber, int expectedResult) {
        Assert.assertEquals(unit.Calculator.div(firstNumber, secondNumber), expectedResult,
                "Houston we have problems!\n");
    }
}
