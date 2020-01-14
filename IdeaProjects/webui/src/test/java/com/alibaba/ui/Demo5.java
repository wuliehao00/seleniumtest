package com.alibaba.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.alibaba.ui.OpenBrowser.*;
import static org.testng.Assert.assertEquals;

public class Demo5 {
    WebDriver webDriver = null;

    @BeforeTest
    public void setUp(){
        webDriver = openBrowser();
        implicitlyWait(10);
    }

    @Test(description = "JS执行")
    public void test1(){
        webDriver.get(ConstantManager.baiduAddress);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"aaaaaa\")");
    }

    @Test(description = "163邮箱注册")
    public void register() throws InterruptedException {
        webDriver.get(ConstantManager.mail_163);

        WebElement element = getElementByXPath("//*[@id=\"commonOperation\"]/a[2]");
        element.click();

        String currentHandle = driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(!handle.equals(currentHandle)){
                driver.switchTo().window(handle);
            }
        }

        WebElement username = getElementById("username");
        username.sendKeys("z"+System.currentTimeMillis()+"");

        WebElement password = getElementById("password");
        password.sendKeys("8318225zc");

        WebElement phone = getElementById("phone");
        phone.sendKeys("17898440922");
        Thread.sleep(500);
        WebElement checkboc = getElementByXPath("/html/body/div[2]/div/div/div[2]/div[4]/span");
        checkboc.click();
        Thread.sleep(500);
        WebElement submit = getElementByXPath("/html/body/div[2]/div/div/div[2]/div[5]/a[1]");
        submit.click();
    }

    @Test(description = "邮箱登录")
    public void login() throws InterruptedException {
        webDriver.get(ConstantManager.mail_163);
        WebElement switchLogin = getElementById("switchAccountLogin");
        switchLogin.click();
        Thread.sleep(500);
        WebElement iframe = getElementByXPath("//*[@id=\"loginDiv\"]/iframe");
        webDriver.switchTo().frame(iframe);
        Thread.sleep(500);
        WebElement username = getElementByName("email");
        username.sendKeys(ConstantManager.username);
        WebElement password = getElementByName("password");
        password.sendKeys(ConstantManager.password);
        WebElement submit = getElementById("dologin");
        submit.click();
        Thread.sleep(1000);
        WebElement text = getElementByXPath("//*[@id=\"_dvModuleContainer_welcome.WelcomeModule_0\"]/div/div[2]/div[1]/div[2]/span[1]/span[1]");
        assertEquals(text.getText(), ConstantManager.username);
    }

    @Test(description = "邮箱账号错误")
    public void login_error() throws InterruptedException {
        webDriver.get(ConstantManager.mail_163);
        WebElement switchLogin = getElementById("switchAccountLogin");
        switchLogin.click();
        Thread.sleep(500);
        WebElement iframe = getElementByXPath("//*[@id=\"loginDiv\"]/iframe");
        webDriver.switchTo().frame(iframe);
        Thread.sleep(500);
        WebElement username = getElementByName("email");
        username.sendKeys(ConstantManager.errorUserName);
        WebElement password = getElementByName("password");
        password.sendKeys(ConstantManager.password);
        WebElement submit = getElementById("dologin");
        submit.click();
        Thread.sleep(500);
        WebElement error = getElementByClassName("ferrorhead");
        assertEquals(error.getText(), "帐号或密码错误");
    }

    @Test(description = "发送邮件")
    public void sendMail() throws InterruptedException {
        webDriver.get(ConstantManager.mail_163);
        WebElement switchLogin = getElementById("switchAccountLogin");
        switchLogin.click();
        Thread.sleep(500);
        WebElement iframe = getElementByXPath("//*[@id=\"loginDiv\"]/iframe");
        webDriver.switchTo().frame(iframe);
        Thread.sleep(500);
        WebElement username = getElementByName("email");
        username.sendKeys(ConstantManager.username);
        WebElement password = getElementByName("password");
        password.sendKeys(ConstantManager.password);
        WebElement submit = getElementById("dologin");
        submit.click();
        Thread.sleep(1000);
        WebElement text = getElementByXPath("//*[@id=\"_dvModuleContainer_welcome.WelcomeModule_0\"]/div/div[2]/div[1]/div[2]/span[1]/span[1]");
        Thread.sleep(500);
        assertEquals(text.getText(), ConstantManager.username);
        Thread.sleep(500);

        //发送邮件
        WebElement WriteLetter = getElementByXPath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]");
        WriteLetter.click();
        presenceOfWait(30, By.className("nui-editableAddr-ipt"));
        WebElement recevier = getElementByClassName("nui-editableAddr-ipt");
        recevier.sendKeys(ConstantManager.receiver);
        WebElement topic = getElementByXPath("//*[@id=\"_dvModuleContainer_compose.ComposeModule_0\"]/div[1]/section/header/div[2]/div[1]/div/div/input");
        topic.sendKeys("测试测试");
        //添加附件fatal
        WebElement fujian = getElementByClassName("O0");
        fujian.sendKeys(ConstantManager.fujian);

        //文本内容
        WebElement iframe2 = getElementByClassName("APP-editor-iframe");
        webDriver.switchTo().frame(iframe2);
        WebElement textarea = getElementByClassName("nui-scroll");
        textarea.sendKeys("1212121212121");
        //控制权撤回
        webDriver.switchTo().defaultContent();
        Thread.sleep(300);
        //点击发送
        WebElement sendMain = getElementByXPath("//*[@id=\"_dvModuleContainer_compose.ComposeModule_0\"]/div[1]/section/footer/div[1]/span[2]");
        sendMain.click();
        Thread.sleep(1000);
        WebElement result = getElementByXPath("//*[@id=\"_dvModuleContainer_compose.ComposeModule_0\"]/div[2]/section/h1");
        System.out.println(result.getText()+"$$$$$$$$$$$$$$$$$$$$");
    }

    @Test(description = "selenium Grid,作用是让脚本在各个平台上运行")
    public void test5() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //System.setProperty("webdriver.chrome.driver", ConstantManager.chromeAddress);
        driver = new RemoteWebDriver(new URL("http://192.168.0.100:5555/wd/hub"), dc);

        driver.get(ConstantManager.baiduAddress);
    }

    @DataProvider(name = "data")
    public Object[][] data1(){
        return new Object[][]{
                {"firefox","11111","222222"},{"chrome"}
        };
    }

    @Test(description = "数据驱动", dataProvider = "data")
    public void testdriven(String name, String number, String aa){
        System.out.println(name+","+number+","+aa);
    }

    @AfterTest
    public void endUp(){
        quit();
    }
}
