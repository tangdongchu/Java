package com.UIAutomator;

import com.android.uiautomator.core.UiObject;  
import com.android.uiautomator.core.UiObjectNotFoundException;  
import com.android.uiautomator.core.UiScrollable;  
import com.android.uiautomator.core.UiSelector;  
import com.android.uiautomator.testrunner.UiAutomatorTestCase;  

public class TestDemo extends UiAutomatorTestCase {
	public void setChineseLan() throws UiObjectNotFoundException {  
	    //�������ǰ������Home�������������  
	    getUiDevice().pressHome();  
	  
	  
	    //���롰ϵͳ���á��˵���Ҳ����ͨ�����menu������ʵ��  
	    UiObject settingApp = new UiObject(new UiSelector().text("Settings"));  
	    settingApp.click();  
	  
	  
	    //�ȴ�3��  
	    try {  
	        Thread.sleep(3000);  
	    } catch (InterruptedException e1) {  
	        e1.printStackTrace();  
	    }  
	  
	  
	    //�ù����ķ�ʽ���Ҳ����롰���Ժ����뷨���á��˵�  
	    UiScrollable settingItems = new UiScrollable(  
	            new UiSelector().scrollable(true));  
	  
	  
	    UiObject languageAndInputItem = settingItems.getChildByText(  
	            new UiSelector().text("Language & input"), "Language & input",  
	            true);  
	    languageAndInputItem.clickAndWaitForNewWindow();  
	  
	  
	    //�ҵ���English���Ŀɵ�����Ϊ��ǰ��Ӣ�Ļ�����  
	    UiObject setLanItem = new UiObject(new UiSelector().text("English"));  
	    setLanItem.clickAndWaitForNewWindow();  
	  
	  
	    //Log���  
	    System.out.println("setLanItem-->" + setLanItem.getPackageName());  
	  
	  
	    //�����޷�ʶ�����ģ������������ʹ������ȥѡ�񡰼������ġ���  
	    getUiDevice().click(350, 250);  
	      
	    //������ؼ����ص���������  
	    getUiDevice().pressBack();  
	    getUiDevice().pressBack();  
	    getUiDevice().pressBack();  
	}
}
