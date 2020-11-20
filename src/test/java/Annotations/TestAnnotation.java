package Annotations;

import org.testng.annotations.Test;

public class TestAnnotation {

    @Test
    public void test1() {
        System.out.println("===> Test1 Output");
    }

    @Test
    public void test2() {
        System.out.println("===> Test2 Output");
    }


    public void notATest() {
        System.out.println("===> Not a test");
    }
}
