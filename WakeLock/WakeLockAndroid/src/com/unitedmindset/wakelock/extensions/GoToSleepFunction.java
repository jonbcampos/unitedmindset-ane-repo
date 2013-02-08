package com.unitedmindset.wakelock.extensions;

import android.os.SystemClock;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class GoToSleepFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WakeLockContext c = (WakeLockContext)context;
		
		long time = SystemClock.uptimeMillis();
		
		c.getPowerManager().goToSleep(time);
		
		return null;
	}

}
