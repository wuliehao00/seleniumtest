package com.alibaba.ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo6 {

    @BeforeTest
    public void setUp(){

    }
    @DataProvider(name = "loginUser")
    public Object[][] data(){
        return new Object[][]{{"aaaa", "bbbb"},{"bbbb","bbbbb"}};
    }
    @Test(dataProvider = "loginUser")
    public void test(String name, String password){
        System.out.println(name+password);
    }

    @AfterTest
    public void endUp(){

    }
}
