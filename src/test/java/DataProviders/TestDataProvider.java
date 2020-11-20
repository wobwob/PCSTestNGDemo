package DataProviders;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unit.Calculator;

@Test
public class TestDataProvider {

    @DataProvider
    private Object[][] sumDataProvider() {
        return new Object[][]{
                {30, 12, 42},
                {0, 55, 55},
                {-14, -6, -20}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void testSum(int firstNumber, int secondNumber, int expectedResult) {
        Assert.assertEquals(Calculator.add(firstNumber, secondNumber), expectedResult,
                "Houston we have problems!\n");
    }
}
