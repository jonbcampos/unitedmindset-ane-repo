package com.unitedmindset.batterymanager.extensions;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class RegisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		BatteryManagerContext c = (BatteryManagerContext)context;
		Activity activity = c.getActivity();
		
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		
		BatteryManagerListener listener = new BatteryManagerListener();
		listener.setFREContext( c );
		c.setBatteryManagerListener( listener );
		activity.registerReceiver(listener, filter);
		
		return null;
	}

}
