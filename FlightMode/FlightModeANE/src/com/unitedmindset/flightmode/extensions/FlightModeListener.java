package com.unitedmindset.flightmode.extensions;

import com.adobe.fre.FREContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FlightModeListener extends BroadcastReceiver {

	private FREContext freContext;
	
	public void setFREContext(FREContext context)
	{
		freContext = context;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Boolean inAirplaneMode = intent.getBooleanExtra("state", false);
		String s = (inAirplaneMode)?"true":"false";
		freContext.dispatchStatusEventAsync("connectivityChange", s);
	}

}
