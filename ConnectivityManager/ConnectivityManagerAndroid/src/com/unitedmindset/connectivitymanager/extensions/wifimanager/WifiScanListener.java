package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.adobe.fre.FREContext;

public class WifiScanListener extends BroadcastReceiver {

	private FREContext freContext;

	public void setFREContext(FREContext context) {
		freContext = context;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		//ConnectivityManagerContext c = (ConnectivityManagerContext) freContext;
		//WifiManager w = c.wifiManager;
		
		freContext.dispatchStatusEventAsync("wifiScanChange", "");
	}

}
