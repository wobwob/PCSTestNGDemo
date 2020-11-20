package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import unit.Calculator;

public class TestAssertion {

    @Test
    public void testAdd() {
        int firstNumber = 30;
        int secondNumber = 12;

        int expectedResult = 42;

        int actualResult = Calculator.add(firstNumber, secondNumber);
        Assert.assertEquals(actualResult, expectedResult, "Houston we have problems!\n");
    }
}
