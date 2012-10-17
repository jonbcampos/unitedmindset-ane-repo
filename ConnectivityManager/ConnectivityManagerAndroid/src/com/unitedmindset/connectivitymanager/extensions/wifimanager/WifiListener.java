package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import com.adobe.fre.FREContext;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

public class WifiListener extends BroadcastReceiver {

	private FREContext freContext;

	public void setFREContext(FREContext context) {
		freContext = context;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		ConnectivityManagerContext c = (ConnectivityManagerContext) freContext;
		WifiManager w = c.wifiManager;
		
		int wifiState = w.getWifiState();
		String wifiStateString = Integer.toString(wifiState);
		
		freContext.dispatchStatusEventAsync("wifiChange", wifiStateString);
	}

}
