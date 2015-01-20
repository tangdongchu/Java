package com.UIAutomator;

import com.android.uiautomator.core.UiObject;  
import com.android.uiautomator.core.UiObjectNotFoundException;  
import com.android.uiautomator.core.UiScrollable;  
import com.android.uiautomator.core.UiSelector;  
import com.android.uiautomator.testrunner.UiAutomatorTestCase;  

public class TestDemo extends UiAutomatorTestCase {
	public void setChineseLan() throws UiObjectNotFoundException {  
	    //进入操作前，先用Home键进入待机界面  
	    getUiDevice().pressHome();  
	  
	  
	    //进入“系统设置”菜单。也可以通过点击menu按键来实现  
	    UiObject settingApp = new UiObject(new UiSelector().text("Settings"));  
	    settingApp.click();  
	  
	  
	    //等待3秒  
	    try {  
	        Thread.sleep(3000);  
	    } catch (InterruptedException e1) {  
	        e1.printStackTrace();  
	    }  
	  
	  
	    //用滚动的方式查找并进入“语言和输入法设置”菜单  
	    UiScrollable settingItems = new UiScrollable(  
	            new UiSelector().scrollable(true));  
	  
	  
	    UiObject languageAndInputItem = settingItems.getChildByText(  
	            new UiSelector().text("Language & input"), "Language & input",  
	            true);  
	    languageAndInputItem.clickAndWaitForNewWindow();  
	  
	  
	    //找到“English”的可点击项（因为当前是英文环境）  
	    UiObject setLanItem = new UiObject(new UiSelector().text("English"));  
	    setLanItem.clickAndWaitForNewWindow();  
	  
	  
	    //Log输出  
	    System.out.println("setLanItem-->" + setLanItem.getPackageName());  
	  
	  
	    //由于无法识别中文，因此我们这里使用坐标去选择“简体中文”项  
	    getUiDevice().click(350, 250);  
	      
	    //点击返回键，回到待机界面  
	    getUiDevice().pressBack();  
	    getUiDevice().pressBack();  
	    getUiDevice().pressBack();  
	}
}
