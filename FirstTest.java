package com.ctrip.view.LearnTest; 


import io.appium.java_client.android.AndroidKeyCode;
import java.util.List;
import java.util.Set;

import org.testng.annotations.*;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebElement;  

public class FirstTest {    
    UIutil  UIutil = new UIutil();
    
    @BeforeClass
    public void initializtion() throws Exception {  
        // 初始化
    	Config Config = new Config();
    	Config.setUp();
    }
    
    @AfterClass  
    public void tearDown() throws Exception {  
    	Config.driver.quit(); 
    }  
   
    @Test  
    public void TestCase() throws InterruptedException{
    	Thread.sleep(3000);
    	UIutil.IsExistUpdate();
    	//滑动新功能介绍
    	Thread.sleep(1000);
    	Config.driver.swipe(500, 75, 0, 75, 800);
    	//进入我的携程
        WebElement el = Config.driver.findElement(By.name("我 的"));  
        el.click();
        //用户登录
        if (UIutil.IsLogin() == false)
        {
        	UIutil.UserLogin();
        	//如果登录失败，再试几次
            for(int i=0;i<=100;i++){
            	if (UIutil.IsExistElement("我 的"))
                {
                	break;
                }
                else
                {
                	if (UIutil.IsExistElement("知道了"))
                			{
                		Config.driver.findElement(By.name("知道了")).click();
                    	Config.driver.findElementByName("登录").click();
                			}
                	else
                	{
                		Thread.sleep(1000);
                	}
                }
            }
        }
        //点击全部订单,进入订单详情再返回
        Config.driver.findElementByName("全部订单").click();
        Thread.sleep(10000);
        //4.3以下设备需设置成selendroid模式，并获取context
        /*
        Set<String> contextNames = Config.driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            Config.driver.context(contextName);
            }
        */
        Config.driver.context("WEBVIEW");
        List<WebElement> Order = Config.driver.findElements(By.className("order-cont"));
        Order.get(1).click();
        Config.driver.context("NATIVE_APP");
        Config.driver.sendKeyEvent(AndroidKeyCode.BACK);
    } 
}  