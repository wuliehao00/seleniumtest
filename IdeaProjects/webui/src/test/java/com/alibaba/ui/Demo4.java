package com.alibaba.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.alibaba.ui.OpenBrowser.*;
import static org.testng.Assert.assertEquals;


public class Demo4 {
    WebDriver driver = null;

    @BeforeTest
    public void setUp(){
        driver = openBrowser();
    }

    @Test(description = "下拉框")
    public void test(){
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementById("moreSelect");
        Select select = new Select(element);
        //select.selectByIndex(1);
        //select.selectByValue("vivo");
        select.selectByVisibleText("xiaomi");
    }
    @Test(description = "下拉框")
    public void test1(){
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementById("moreSelect");
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        for(WebElement webElement:list){
            System.out.println(webElement.getText());
        }
    }

    @Test(description = "多窗口")
    public void test2() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementByClassName("open");
        element.click();
        Thread.sleep(500);
        //当前driver窗口的句柄
        String currentHandle = driver.getWindowHandle();
        for(String hanle1 : driver.getWindowHandles()){
            if(!hanle1.equals(currentHandle)){
                driver.switchTo().window(hanle1);
            }
        }

        WebElement element1 = getElementById("kw");
        element1.sendKeys("11111111");
        WebElement element2 = getElementById("su");
        element2.click();
    }

    @Test(description = "等待")
    public void test3() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);
        WebElement element = getElementByClassName("wait");
        element.click();
        //Thread.sleep(3000);
        //implicitlyWait(3);
        presenceOfWait(3, By.className("red"));
        WebElement element1 = getElementByClassName("red");
        assertEquals(element1.getText(), "wait for display");
    }

    @Test(description = "右键")
    public void test4() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);

        WebElement element = getElementByClassName("alert");

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    @Test(description = "双击")
    public void test5() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);

        WebElement element = getElementByClassName("alert");

        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    @Test(description = "鼠标移上去")
    public void test6() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);

        WebElement element = getElementByClassName("over");

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        //presenceOfWait(30, );
    }

    @Test(description = "鼠标拖动")
    public void test7() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);

        WebElement element = getElementByClassName("over");

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        System.out.println(getElementById("over").getText()+"&&&&&&&&&&&&");

        //presenceOfWait(30, );
    }

    @Test(description = "多选下拉框")
    public void test8() throws InterruptedException {
        driver.get(ConstantManager.indexAddress);

        WebElement element = getElementById("selectWithMultipleEqualsMultiple");
        List<WebElement> list = element.findElements(By.tagName("option"));
        System.out.println(list.size());
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(list.get(1)).keyUp(Keys.SHIFT).perform();


    }

    @Test(description = "Robot保存ctrl +s")
    public void test9() throws InterruptedException, AWTException {
        driver.get(ConstantManager.indexAddress);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);



    }

    @AfterTest
    public void endUp(){
        quit();
    }

}
