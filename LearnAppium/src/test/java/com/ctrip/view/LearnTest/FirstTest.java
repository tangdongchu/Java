package com.ctrip.view.LearnTest; 


import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;  
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;  

public class FirstTest extends TestBase{    
    UIutil  UIutil = new UIutil();
    
    @BeforeClass
    public void initializtion() throws Exception {  
        // 初始化
        setUp();
    }
    
    @AfterClass  
    public void tearDown() throws Exception {  	
    	driver.quit(); 
    	P.destroy();
    }  
   
    @Test
    public void TestCase1() throws Exception{
    	Thread.sleep(3000);
    	UIutil.IsExistUpdate();
    	//滑动新功能介绍
    	Thread.sleep(1000);
    	driver.swipe(500, 75, 0, 75, 800);
    	//进入我的携程
        WebElement el = driver.findElement(By.name("我 的"));  
        el.click();
        //用户登录
        if (UIutil.IsLogin() == false)
        {
        	UIutil.UserLogin();
        }
        //点击全部订单,进入订单详情再返回
        driver.findElementByName("全部订单").click();
        Thread.sleep(10000);
        //4.3以下设备需设置成selendroid模式，并获取context
        /*
        Set<String> contextNames = Config.driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            Config.driver.context(contextName);
            }
        */
        driver.context("WEBVIEW");
        List<WebElement> Order = driver.findElements(By.className("order-cont"));
        Order.get(1).click();
        //截图
        File screenShotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(screenShotFile, new File("\\"+"20"+ new Date().getTime() + "-No contacts.png"));
		} 
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.context("NATIVE_APP");
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    } 
}  