package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.unitedmindset.connectivitymanager.extensions.WifiManagerContext;

public class RegisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WifiManagerContext cmc = (WifiManagerContext) context;
		Activity activity = cmc.getActivity();
		cmc.wifiManager = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
		
		IntentFilter filter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
		
		WifiListener listener = new WifiListener();
		listener.setFREContext(context);
		cmc.setWifiListener(listener);
		activity.registerReceiver(listener, filter);
		
		IntentFilter scanFilter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
		
		WifiScanListener scanListener = new WifiScanListener();
		scanListener.setFREContext(context);
		cmc.setWifiScanListener(scanListener);
		activity.registerReceiver(scanListener, scanFilter);
		
		return null;
	}

}
