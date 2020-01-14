package com.huawei.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    @Test
    public void openFireFox(){
        //如果火狐浏览器不是默认安装再C盘，需要设置火狐浏览器路径
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openChrome() throws InterruptedException {
        //设置版本浏览器的webdriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\39738\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        //设置浏览器大小
        Dimension dimension = new Dimension(500,500);

        WebDriver webDriver = new ChromeDriver();

        //webDriver.manage().window().setSize(dimension);
        webDriver.manage().window().maximize();

        //后台不关闭webdriver进程
       // webDriver.close();
        //后台想要关闭webdriver进程的话
        //webDriver.quit()
        //设置浏览器地址
        webDriver.get("https://www.baidu.com");
        Thread.sleep(5000);
        //浏览器后退
        webDriver.navigate().back();
        Thread.sleep(3000);
        //浏览器前进
        webDriver.navigate().forward();
        Thread.sleep(3000);
        //刷新
        webDriver.navigate().refresh();
        Thread.sleep(3000);
        //获取当前页面的URL
        System.out.println(webDriver.getCurrentUrl());
        //后台想要关闭webdriver进程的话
        webDriver.quit();
    }

    //设置IE

    //设置Edge
}
