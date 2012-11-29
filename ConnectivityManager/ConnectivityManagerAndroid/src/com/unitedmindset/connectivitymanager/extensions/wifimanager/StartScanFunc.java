package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.net.wifi.WifiManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.WifiManagerContext;

public class StartScanFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WifiManagerContext c = (WifiManagerContext) context;
		WifiManager w = c.wifiManager;
		
		boolean successful = w.startScan();
		
		FREObject result = null;
		try {
			result = FREObject.newObject(successful);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
