package Annotations;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAnnotationAttributes {

    @DataProvider
    private Object[][] dummyDataprovider() {
        return new Object[][]{{}};
    }

    @Test(dataProvider = "dummyDataprovider")
    public void test1() {
        System.out.println("===> Test1 Output");
    }

    @Test(description = "This string will be displayed in the test report")
    public void test2() {
        System.out.println("===> Test2 Output");
    }

    @Test(timeOut = 5000)
    public void test3() {
        System.out.println("===> Test3 Output");
    }

    @Test(enabled = false)
    public void brokenTest() throws Exception {
        throw new Exception("I am broken!");
    }

    @Test(priority = 0)
    public void testSum() {
        Assert.assertEquals(unit.Calculator.add(10, 12), 22,
                "Houston we have problems!\n");
    }

    @Test(priority = 1)
    public void testSub() {
        Assert.assertEquals(unit.Calculator.sub(0, 64), -64,
                "Houston we have problems!\n");
    }

    @Test(priority = 2)
    public void testMul() {
        Assert.assertEquals(unit.Calculator.mul(0, 112358), 0,
                "Houston we have problems!\n");
    }

    @Test(priority = 3)
    public void testDiv() {
        Assert.assertEquals(unit.Calculator.div(25, 5), 5,
                "Houston we have problems!\n");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivNegative() {
        int divByZero = unit.Calculator.div(123, 0);
        System.out.println(divByZero);
    }

    @AfterMethod(alwaysRun = true)
    private void afterMethod() {
        System.out.println("Print this string after each test method no matter what");
    }
}
