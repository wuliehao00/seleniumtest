package com.alibaba.ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.alibaba.ui.OpenBrowser.*;
import static org.testng.Assert.*;

public class Demo3 {
    WebDriver driver = null;
    @BeforeTest
    public void beforeTest(){
        driver = openBrowser();
    }

    @Test(description = "点击新闻")
    public void test(){
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementByName("tj_trnews");
        element.click();
        assertEquals(ConstantManager.newsAddress, driver.getCurrentUrl());
    }

    @Test(description = "输入关键字,点击搜索")
    public void tes2() throws InterruptedException {
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementById("kw");
        element.sendKeys("火影忍者");
        WebElement element1 = getElementById("su");
        element1.click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }

    @Test(description = "输入关键字,点击搜索,然后清空")
    public void tes3() throws InterruptedException {
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementById("kw");
        element.sendKeys("火影忍者");
        WebElement element1 = getElementById("su");
        element1.click();
        element.clear();
        System.out.println(driver.getTitle());
    }

    @Test(description = "输入关键字,点击搜索,然后清空")
    public void tes4() throws InterruptedException {
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementById("kw");
        element.sendKeys("火影忍者");
        WebElement element1 = getElementById("su");
        element1.click();
        Thread.sleep(500);
        assertEquals(element.getText(), "火影忍者");
        element.clear();
        System.out.println(driver.getTitle());
    }

    @Test(description = "获取标签名")
    public void tes5() throws InterruptedException {
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementByName("tj_trnews");
        assertEquals(element.getTagName(), "a");
    }

    @Test(description = "获取元素属性值")
    public void tes6() throws InterruptedException {
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementById("su");
        assertEquals(element.getAttribute("value"), "百度一下");
    }

    @Test(description = "获取元素是否可展示")
    public void tes7() throws InterruptedException {
        driver.get(ConstantManager.baiduAddress);
        WebElement element = getElementByName("rsv_bp");
        assertFalse(element.isDisplayed());
    }

    @Test(description = "获取元素是否被选中")
    public void tes8() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);
        List<WebElement> elementList = driver.findElements(By.name("identity"));
        System.out.println(elementList.size());
        for(WebElement element: elementList){
            assertFalse(element.isSelected());
        }

    }

    @Test(description = "获取元素是否激活")
    public void tes9() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementByName("buttonhtml");
        assertFalse(element.isEnabled());
    }

    @Test(description = "获取截图")
    public void tes10() throws InterruptedException, IOException {
        driver.get(ConstantManager.indexAddress);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(ConstantManager.newindexAddress));
    }

    @Test(description = "alert弹窗")
    public void tes11() throws InterruptedException, IOException {
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementByClassName("alert");
        element.click();
        Thread.sleep(200);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test(description = "Confirm弹窗")
    public void tes12() throws InterruptedException, IOException {
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementByClassName("confirm");
        element.click();
        Thread.sleep(200);
        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();
    }

    @Test(description = "Prompt弹窗")
    public void tes13() throws InterruptedException, IOException {
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementByClassName("prompt");
        element.click();
        Thread.sleep(200);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I am a teacher");
        Thread.sleep(1000);
        System.out.println(alert.getText()+"!!!!!!!!!!!!!!");
        alert.accept();
    }

    @Test(description = "iframe")
    public void tes14() throws InterruptedException, IOException {
        driver.get(ConstantManager.indexAddress);
        WebElement iframe = getElementByName("aa");
        driver = driver.switchTo().frame(iframe);
        //WebElement element = getElementByClassName("prompt");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
        element.click();
        //恢复
        Thread.sleep(1000);
        //driver = driver.switchTo().defaultContent();
        WebElement element1 = driver.findElement(By.className("prompt"));
        element1.click();
    }

    @AfterTest
    public void clearUp(){
        quit();
    }
}
