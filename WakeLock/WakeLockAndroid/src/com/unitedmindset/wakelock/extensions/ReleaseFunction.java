package com.unitedmindset.wakelock.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class ReleaseFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WakeLockContext c = (WakeLockContext)context;
		c.getWakeLock().release();
		
		return null;
	}

}
