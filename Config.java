package com.ctrip.view.LearnTest;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Config {
	public static  AndroidDriver driver; 
	public void setUp() throws Exception {
		
        //配置从XML读取appium参数
	Config config = new Config();
        String BrowserName = config.readxml("BrowserName");
        String platformName = config.readxml("PlatformName");
        String deviceName = config.readxml("DeviceName");
        String platformVersion = config.readxml("PlatformVersion");
        String app = config.readxml("ApkPath");
        String appPackage = config.readxml("appPackage");
        String appActivity = config.readxml("appActivity");
        //String automationName = config.readxml("automationName");
        DesiredCapabilities capabilities = new DesiredCapabilities();  
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserName);  
        capabilities.setCapability("platformName", platformName);  
        capabilities.setCapability("deviceName", deviceName);  
        capabilities.setCapability("platformVersion", platformVersion);  
        capabilities.setCapability("app", app);  
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        //capabilities.setCapability("automationName", automationName); 
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
    }
	
	public String readxml(String key) throws Exception {  
		SAXReader reader = new SAXReader();
		File classpathRoot = new File(System.getProperty("user.dir"));   
		File file = new File(classpathRoot, "Config.xml");//创建file对象
		Document document = reader.read(file);// 读取XML文件
		Element root = document.getRootElement();// 得到根节点
		String value = null;
		for (Iterator i = root.elementIterator("add"); i.hasNext();) {
			Element account = (Element) i.next();//遍历整个XML
			if (account.attributeValue("key").equals(key)) {
				// 读取value
				value = account.attributeValue("value");
				break;
				}
			}
		return value;
		}
}


