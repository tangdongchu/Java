package com.ctrip.view.LearnTest;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Config {
	public static  AndroidDriver driver; 
	public void setUp() throws Exception {  
        //配置appium参数  
        File classpathRoot = new File(System.getProperty("user.dir"));  
        File appDir = new File(classpathRoot, "apps");  
        File app = new File(appDir, "Ctrip_V5.10_SIT7_PRODUCT.apk");  
        DesiredCapabilities capabilities = new DesiredCapabilities();  
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");  
        capabilities.setCapability("platformName", "Android");  
        capabilities.setCapability("deviceName","4df72e3d1fbb30af");  
        capabilities.setCapability("platformVersion", "4.3");  
        capabilities.setCapability("app", app.getAbsolutePath());  
        capabilities.setCapability("appPackage", "ctrip.android.view");
        capabilities.setCapability("appActivity", ".home.CtripSplashActivity");
        //capabilities.setCapability("automationName", "selendroid"); 
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
    }
}
