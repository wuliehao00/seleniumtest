package com.alibaba.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.alibaba.ui.OpenBrowser.*;
import static com.alibaba.ui.OpenBrowser.quit;

public class Demo2 {
    WebDriver driver = null;
    @BeforeTest(description = "打开浏览器")
    public void openChrome(){
        driver = openBrowser();
        driver.get(ConstantManager.baiduAddress);
    }

    @Test(description = "id查找")
    public void test(){
        WebElement element = getElementById("kw" );
        element.sendKeys("火影忍者");
        //后退
        driver.navigate().back();
    }

    @Test(description = "标签查找")
    public void test2(){
        WebElement element = getElementByLinkText("新闻");
        element.click();
    }

    @Test(description = "部分标签查找")
    public void test3(){
        WebElement element = getElementByPartialLinkText("学");
        element.click();
    }

    @Test(description = "name查找")
    public void test4(){
        WebElement element = getElementByName("wd");
        element.sendKeys("张子枫");
    }

    @Test(description = "tag查找")
    public void test5(){
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"u1\"]"));
        System.out.println(elementList.size()+"***************");
        for(WebElement element: elementList){
            System.out.println(element.getText()+"##################");
        }

    }


    @AfterTest
    public void clear(){
        quit();
    }

}
