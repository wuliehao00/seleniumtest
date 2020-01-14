package com.huawei.day1;


import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FindElementsTest {
    WebDriver webDriver;
    /**
     * 打开百度页面
     * 定位搜索文本框
     */
    @BeforeMethod
    public void openChrome(){
        //设置版本浏览器的webdriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\39738\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //等待时间
       // webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void byIDTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.id("kw"));
        element.sendKeys("www.asdfga.com");
        Thread.sleep(5000);
    }

    @Test
    public void byNameTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.name("tj_trnews"));
        element.click();
        Thread.sleep(5000);
    }

    @Test
    public void byClassNameTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.className("s_ipt"));
        element.sendKeys("火影忍者");
        Thread.sleep(5000);
        element.clear();
        Thread.sleep(2000);
        WebElement test = webDriver.findElement(By.xpath("//*[@id=\"1\"]/div/article/header/div/a/h3/span/em"));
        assertEquals("火影忍者", test.getText());
        Thread.sleep(5000);
    }

    @Test
    public void byLinkTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.linkText("新闻"));
        element.click();
        //获取URL地址
        assertEquals("http://news.baidu.com/", webDriver.getCurrentUrl());
        Thread.sleep(5000);
    }

    /**
     * 截图打开百度首页
     */
    @Test
    public void screenshotFile() throws IOException {
        webDriver.get("https://www.baidu.com");

        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(file, new File("C:\\移动办公\\web自动化测试\\PPT\\a.png"));
    }

    /**
     * 打开UI自动化测试
     * 点击alert按钮
     * 在alert警告框点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        webDriver.get("https://www.runoob.com/try/try.php?filename=tryjs_output_alert");
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();//将控制权转交
        alert.accept();//点击确定按钮
        Thread.sleep(3000);
        webDriver.findElement(By.id("submitBTN")).click();
        Thread.sleep(3000);
    }

    @Test
    public void confirmTest(){

    }
    @Test
    public void iframeTest(){
        webDriver.get("file:///C:/移动办公/web自动化测试/index.html");
        //控制权转交
        webDriver.switchTo().frame("");//传nameorId

        //控制权解除
        webDriver.switchTo().defaultContent();//driver控制权转交原来界面
    }
    @Test
    public void selectTest() throws InterruptedException {
        webDriver.get("https://www.runoob.com/try/try.php?filename=tryhtml_select");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"textareaCode\"]/text()"));
        Select select = new Select(element);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByValue("Saab");
        Thread.sleep(3000);
        select.selectByVisibleText("Opel");
        Thread.sleep(3000);

    }
    @Test
    public void openWindowTest() throws InterruptedException {
        webDriver.get("file:///C:/移动办公/web自动化测试/index.html");
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //控制权移交
        String handle1 = webDriver.getWindowHandle();
        for(String handles:webDriver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }else{
                webDriver.switchTo().window(handles);
            }
        }

        webDriver.findElement(By.id("kw")).sendKeys("火影忍者");
        Thread.sleep(3000);
    }

    @Test
    public void WaitTest() throws InterruptedException {
        webDriver.get("file:///C:/移动办公/web自动化测试/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //Thread.sleep(6000);
        String str = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        assertEquals("wait for display", str);

    }

    @Test
    public void WaitTest2() throws InterruptedException {
        webDriver.get("file:///C:/移动办公/web自动化测试/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //Thread.sleep(6000);
        //显示等待
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String str = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        assertEquals("wait for display", str);

    }

    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }
}
