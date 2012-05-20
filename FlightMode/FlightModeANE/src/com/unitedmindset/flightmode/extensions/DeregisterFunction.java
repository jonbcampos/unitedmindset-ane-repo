package com.unitedmindset.flightmode.extensions;

import android.app.Activity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DeregisterFunction implements FREFunction
{
	
	public FREObject call(FREContext context, FREObject[] args) {
		
		FlightModeContext c = (FlightModeContext)context;
		Activity activity = c.getActivity();
		FlightModeListener listener = c.getConnectivityListener();
		if(listener!=null)
		{
			activity.unregisterReceiver(listener);
			c.setConnectivityListener(null);
		}
		return null;
	}

}
