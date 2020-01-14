package com.huawei.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSTest {
    WebDriver webDriver;
    @BeforeMethod
    public void before(){
        //设置版本浏览器的webdriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\39738\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //等待时间
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void test(){
        webDriver.get("https://www.baidu.com");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"asdfdsa\");");
    }

    @Test
    public void phantomjsTest(){
        System.setProperty("phantomjs.binary.path", "C:\\Users\\39738\\IdeaProjects\\Selenium\\drivers\\phantomjs.exe");
        WebDriver webDriver = new PhantomJSDriver();
        webDriver.get("https://www.baidu.com");

        webDriver.findElement(By.id("kw")).sendKeys("火影忍者");
        System.out.println(webDriver.getTitle());
    }
    @AfterMethod
    public void endCase() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
