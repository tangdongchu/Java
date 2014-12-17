package com.ctrip.view.LearnTest;


import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class UIutil {
	
	private String username;
	private String password;
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
  //寻找元素超时时间,单位s
    public void TimeOutTryAgain(String str,int time) throws InterruptedException
    {
        for(int i=0;i<100;i++){
        	if (IsExistElement(str)==false)
            {
                Thread.sleep(time*10);
            }
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
    public void UserLogin() throws Exception
    {
    	//从XML读取用户名密码
    	SAXReader reader = new SAXReader();
        String filePath = "D:/java file/student.xml";//设置文件路径
        File file = new File(filePath);//创建file对象
        Document document = reader.read(file);// 读取XML文件
        Element root = document.getRootElement();// 得到根节点
        for (Iterator i = root.elementIterator("账户"); i.hasNext();) {
            Element account = (Element) i.next();//遍历整个XML
            if (account.attributeValue("id").equals("001")) {
                // 读取id=001的账号信息
            	username = account.selectSingleNode("用户名").getText();
            	password = account.selectSingleNode("密码").getText();
                break;
            }
        }
    	WebElement el = Config.driver.findElement(By.name("登录/注册"));
    	el.click();
        List<WebElement> textFieldsList = Config.driver.findElementsByClassName("android.widget.EditText");  
        /*
        appium不支持中文输入 参考了robotium的以js方式为元素直接设置value的做法
                利用Selenium中Webdriver执行js方法实现中文输入
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('word').value='输入法'");
        */
        textFieldsList.get(0).sendKeys(username);  
        textFieldsList.get(1).sendKeys(password);  
        Config.driver.findElementByName("登录").click();
    }
    // 验证页面标题
    public static void ValidatePageTitle(String expectedValue) throws Exception
    {
        Thread.sleep(3000);
        List<WebElement> pageTitle =Config.driver.findElementsById("ctrip.android.view:id/common_titleview_text");
        assertEquals(expectedValue, pageTitle.get(0).getText());
    }

}
