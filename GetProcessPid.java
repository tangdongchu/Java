package com.ctrip.view.LearnTest;

import java.util.Iterator;
import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
 
public class GetProcessPid {
	private Context context;
	public int getProcessPid() {
		ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
	      List<RunningAppProcessInfo>   procList = null;
	      int result=-1;
	       
	      procList = activityManager.getRunningAppProcesses();
	      for (Iterator<RunningAppProcessInfo> iterator = procList.iterator(); iterator.hasNext();) 
	       {
	        RunningAppProcessInfo procInfo = iterator.next();
	        System.out.println("proc_name:"+procInfo.processName);
	        System.out.println("proc_id:"+procInfo.pid);
	        if(procInfo.processName.equals("ctrip.android.view"))
	         {  
	          result=procInfo.pid;
	          break;
	         } 
	      }
	     return result;
	  }
}        