package com.huawei.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest {
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
    public void loginTest() throws InterruptedException {
        webDriver.get("https://mail.163.com/");

        webDriver.findElement(By.id("switchAccountLogin")).click();
        Thread.sleep(1000);
        webDriver.switchTo().frame("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        webDriver.findElement(By.name("email")).sendKeys("wuliehaoqqq");
        System.out.println("#######################");
        webDriver.findElement(By.name("password")).sendKeys("8318225zc");
        webDriver.findElement(By.id("dologin")).click();

        Thread.sleep(5000);
       String s =  webDriver.findElement(By.xpath("//*[@id=\"_dvModuleContainer_welcome.WelcomeModule_0\"]/div[1]/div[2]/div[1]/div[2]/span[1]/span[1]")).getText();
        assertEquals("wuliehaoqqq", s);
    }

    @AfterMethod
    public void endCase() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
