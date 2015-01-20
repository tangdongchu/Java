package com.ctrip.view.LearnTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	public static  AndroidDriver driver; 
	Process P;
	public void setUp() throws Exception {
		//启动appium
		try{
			P= Runtime.getRuntime().exec("cmd /c start appium");
			}
		catch (Exception e){
			e.printStackTrace();
			}
        //配置从XML读取appium参数
		TestBase config = new TestBase();
        String BrowserName = config.readxml("BrowserName");
        String platformName = config.readxml("PlatformName");
        String deviceName = config.readDevicesID();
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
	//获取当前插入的设备的devices ID
	public String readDevicesID() throws Exception {
		TestBase config = new TestBase();
		String DevicesID = null;
		try {
        	Process process = Runtime.getRuntime().exec("cmd /c adb devices");
        	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        	String line = null;
            while ((line = reader.readLine()) != null) 
               {
            	if(line.endsWith("device")){
            		String arr[] = line.split("\t");
            		DevicesID=arr[0];
            		}
               }
            } 
		catch (Exception e){
			System.out.println("未找到设备，使用config配置的devices");
			DevicesID = config.readxml("DeviceName");
            e.printStackTrace();
            }
		return DevicesID;
		}
	}


