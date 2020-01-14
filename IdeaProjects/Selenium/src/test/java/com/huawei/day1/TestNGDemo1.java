package com.huawei.day1;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGDemo1 {
    //test执行顺序是根据ASCII值大小顺序执行，ASCII值小的先执行
    @Test
    public void testCase3() {
        System.out.println("hello world");
    }

    @Test
    public void testCase2() {
        System.out.println("第二个注解");
        assertEquals("1","2");
    }

    @BeforeClass
    public void beforeClassCase2() {
        System.out.println("beforeClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @BeforeTest
    public void beforeTest1(){
        System.out.println("beforeTest");
    }

}
