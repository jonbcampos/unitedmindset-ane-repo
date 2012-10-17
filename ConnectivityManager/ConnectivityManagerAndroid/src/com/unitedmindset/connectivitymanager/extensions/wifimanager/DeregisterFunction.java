package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.app.Activity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class DeregisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		ConnectivityManagerContext cmc = (ConnectivityManagerContext) context;
		Activity activity = cmc.getActivity();
		
		WifiListener listener = cmc.getWifiListener();
		if(listener != null)
		{
			activity.unregisterReceiver(listener);
			cmc.setWifiListener(null);
		}
		
		WifiScanListener scanListener = cmc.getWifiScanListener();
		if(scanListener != null)
		{
			activity.unregisterReceiver(scanListener);
			cmc.setWifiScanListener(null);
		}
		
		return null;
	}

}
