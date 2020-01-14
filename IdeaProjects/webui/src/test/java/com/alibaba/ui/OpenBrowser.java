package com.alibaba.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    static WebDriver driver = null;
    public static WebDriver openBrowser(){
        //设置谷歌浏览器的路径
        System.setProperty("webdriver.chrome.driver", ConstantManager.chromeAddress);
        driver = new ChromeDriver();
        return driver;
    }



    public static void quit(){
        //关闭浏览器
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    //全局等待
    public static void implicitlyWait(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    //显示等待
    public static void presenceOfWait(int time, By locate){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(locate));
    }

    public static WebElement getElementById(String arg){
        return driver.findElement(By.id(arg));
    }

    public static WebElement getElementByName(String arg){
        return driver.findElement(By.name(arg));
    }

    public static WebElement getElementByClassName(String arg){
        return driver.findElement(By.className(arg));
    }

    public static WebElement getElementByLinkText(String arg){
        return driver.findElement(By.linkText(arg));
    }

    public static WebElement getElementByPartialLinkText(String arg){
        return driver.findElement(By.partialLinkText(arg));
    }

    public static WebElement getElementByTagName(String arg){
        return driver.findElement(By.tagName(arg));
    }

    public static WebElement getElementByXPath(String arg){
        return driver.findElement(By.xpath(arg));
    }

    public static WebElement getElementByCssSelector(String arg){
        return driver.findElement(By.cssSelector(arg));
    }

}
