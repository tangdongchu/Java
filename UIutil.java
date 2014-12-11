package com.ctrip.view.LearnTest;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UIutil {
	
	//判断元素是否存在	
    public boolean IsExistElement(String str)
    {
        try{
        	
            Thread.sleep(3000);
            WebElement el = Config.driver.findElement(By.name(str));  
            if (el.isEnabled())
            {
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
    //判断是否存在更新
    public void IsExistUpdate()
    {
    if (IsExistElement("以后再说"))
    {
    	Config.driver.findElement(By.name("以后再说")).click();
    }
    }
    //判断是否登录
    public boolean IsLogin()
    {
    	try{
        	
            Thread.sleep(3000);
            WebElement el = Config.driver.findElement(By.name("登录/注册"));  
            if (el.isEnabled())
            {
                return false;
            }
            return true;
        }catch(Exception e){
            return true;
        }
    }
    //用户登录
    public void UserLogin()
    {
    	WebElement el = Config.driver.findElement(By.name("登录/注册"));
    	el.click();
        List<WebElement> textFieldsList = Config.driver.findElementsByClassName("android.widget.EditText");  
        /*
        appium不支持中文输入 参考了robotium的以js方式为元素直接设置value的做法
                利用Selenium中Webdriver执行js方法实现中文输入
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('word').value='输入法'");
        */
        textFieldsList.get(0).sendKeys("wwwwww");  
        textFieldsList.get(1).sendKeys("www");  
        Config.driver.findElementByName("登录").click(); 
    }
}
