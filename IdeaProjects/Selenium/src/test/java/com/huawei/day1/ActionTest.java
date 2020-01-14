package com.huawei.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {

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
    public void rightClick() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement button = webDriver.findElement(By.id("su"));
        Actions actions = new Actions(webDriver);
        actions.contextClick(button).perform();//右键
        //actions.doubleClick().perform();双击
        Thread.sleep(3000);
    }

    @Test
    public void movemouse() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement button = webDriver.findElement(By.xpath("//*[text()='更多产品']"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(button).perform();//移动鼠标
        //actions.dragAndDrop().perform() //拖拽
        Thread.sleep(3000);
    }

    @Test
    public void mutiselectTest() throws InterruptedException {
        webDriver.get("file:///C:/移动办公/web自动化测试/index.html");
        WebElement element = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        List<WebElement> list = element.findElements(By.tagName("option"));
        System.out.println(list.size()+"********************");
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(3000);
    }

    @Test
    public void RobotTest() throws AWTException {
        webDriver.get("https://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    @Test
    public void upload(){
        webDriver.get("file:///C:/移动办公/web自动化测试/index.html");
        webDriver.findElement(By.id("load")).sendKeys("C:\\Users\\39738\\Desktop\\阿里巴巴java开发手册.pdf");
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
