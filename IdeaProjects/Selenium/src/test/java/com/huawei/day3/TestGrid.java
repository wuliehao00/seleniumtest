package com.huawei.day3;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class TestGrid {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\39738\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        System.out.println("333333333333333333");
        WebDriver  driver = new RemoteWebDriver(new URL("http://192.168.1.102:4444/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
}
