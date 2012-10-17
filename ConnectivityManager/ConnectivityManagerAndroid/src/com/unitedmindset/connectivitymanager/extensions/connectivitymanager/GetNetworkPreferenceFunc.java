package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import android.net.ConnectivityManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class GetNetworkPreferenceFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		ConnectivityManagerContext c = (ConnectivityManagerContext) context;
		ConnectivityManager cm = c.connectivityManager;
		
		int networkPreference = cm.getNetworkPreference();
		
		FREObject returnValue = null;
		try {
			returnValue = FREObject.newObject(networkPreference);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

}
