package testcases;

import base.BaseClass;
import org.testng.annotations.Test;

public class SampleTest extends BaseClass {

    @Test
    public void testCase1(){
        System.out.println("This is testCase1");
//        System.out.println("This is New Comment");
//        System.out.println("This is New Comment2");
    }

    @Test
    public void testCase2(){
        System.out.println("This is testCase2");
    }

    @Test
    public void testCase3(){
        System.out.println("This is testCase3");
    }
}
