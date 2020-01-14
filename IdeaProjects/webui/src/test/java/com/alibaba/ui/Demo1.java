package com.alibaba.ui;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.alibaba.ui.OpenBrowser.*;
import static org.testng.Assert.*;

public class Demo1 {
    @BeforeTest
    public void beforetest(){
        System.out.println("before test");
    }

    @BeforeClass
    public void beforeclass1(){
        System.out.println("beforeclass1");
    }

    @BeforeMethod
    public void method(){
        System.out.println("method");
    }

    @Test
    public void test3(){
        System.out.println("test3");
        assertEquals(2,1);
        assertNull(null);
        assertTrue(true);
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test4() throws InterruptedException {
        //打开百度首页
        WebDriver driver = openBrowser();
        driver.get("https://www.baidu.com");

        //后退
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().back();

        //前进
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().forward();

        //刷新
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();

        //设置浏览器最大化
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //设置浏览器大小
        Thread.sleep(2000);
        Dimension dimension = new Dimension(100,100);
        driver.manage().window().setSize(dimension);

        //获取浏览器地址
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test5(){
        WebDriver driver = openBrowser();
    }

    @AfterTest
    public void after(){
        System.out.println("after test");
        quit();
    }

    @AfterMethod
    public void afterme(){
        System.out.println("after method");
    }

    @AfterClass
    public void afterclas(){
        System.out.println("after class");
    }
}
