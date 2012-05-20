package com.unitedmindset.flightmode.extensions;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class RegisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		
		FlightModeContext c = (FlightModeContext)context;
		Activity activity = c.getActivity();
		
		IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
		
		FlightModeListener listener = new FlightModeListener();
		listener.setFREContext(c);
		c.setConnectivityListener(listener);
		activity.registerReceiver(listener, filter);
		
		return null;
	}

}
