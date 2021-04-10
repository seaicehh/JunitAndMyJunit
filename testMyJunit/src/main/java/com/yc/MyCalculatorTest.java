package com.yc;

import com.yc.biz.Calculator;
import com.yc.junit.*;

/**
 * @program: MavenTest0329
 * @description:
 * @author: Dasiy
 * @create: 2021-03-31 20:45
 */
public class MyCalculatorTest {
    private  Calculator cal;//测试的单元

    @MyBeforeClass
    public static void bc() throws Exception {
        System.out.println("beforeclass");

    }

    @MyBefore
    public void setUp() throws Exception {
        System.out.println("before");
        cal=new Calculator();
    }

    @MyAfter
    public void tearDown() throws Exception {
        System.out.println("after");
        cal=new Calculator();
    }

    @MyAfterClass
    public static  void ac() throws Exception {
        System.out.println("Afterclass");

    }
    @MyTest
    public void add() {
        System.out.println("add测试");
        //Assert.assertEquals(3,cal.add(2,1));
    }

    @MyTest
    public void sub() {
        System.out.println("sub测试");
        //Assert.assertEquals(3,cal.add(2,1));
    }
}
