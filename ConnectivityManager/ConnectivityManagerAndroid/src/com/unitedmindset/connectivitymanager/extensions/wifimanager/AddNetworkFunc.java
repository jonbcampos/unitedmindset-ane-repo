package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.WifiManagerContext;

public class AddNetworkFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WifiManagerContext c = (WifiManagerContext) context;
		WifiManager w = c.wifiManager;
		
		WifiConfiguration wc = new WifiConfiguration();
		wc.BSSID = convertFreObjectToString(args[0]);
		wc.SSID = convertFreObjectToString(args[1]);
		
		return null;
	}
	
	private String convertFreObjectToString(FREObject object){
		String s = "";
		try {
			s = object.getAsString();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}