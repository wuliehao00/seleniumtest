package com.huawei.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Register163Test {
    WebDriver webDriver;
    /**
     *
     */
    @BeforeMethod
    public void openChrome(){
        //设置版本浏览器的webdriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\39738\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //等待时间
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void open163(){
        webDriver.get("https://mail.163.com/");
        //点击注册按钮
        webDriver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
        String handle1 = webDriver.getWindowHandle();

        //切换页面
        for(String handle2 : webDriver.getWindowHandles()){
            if(handle2.equals(handle1)){
                continue;
            }
            webDriver.switchTo().window(handle2);
        }

        //输入邮箱地址
        webDriver.findElement(By.id("nameIpt")).sendKeys("wuliehao000");
        //输入密码
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("123123123");
        //输入确认密码
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123123");

        webDriver.findElement(By.id("mainAcceptIpt")).click();

    }

    @AfterMethod
    public void endCase() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
