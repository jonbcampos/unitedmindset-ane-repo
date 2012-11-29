package com.unitedmindset.batterymanager.extensions;

import android.app.Activity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DeregisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		BatteryManagerContext c = (BatteryManagerContext)context;
		Activity activity = c.getActivity();
		
		BatteryManagerListener listener = c.getBatteryManagerListener();
		if(listener!=null)
		{
			activity.unregisterReceiver(listener);
			c.setBatteryManagerListener( null );
		}
		
		return null;
	}

}
