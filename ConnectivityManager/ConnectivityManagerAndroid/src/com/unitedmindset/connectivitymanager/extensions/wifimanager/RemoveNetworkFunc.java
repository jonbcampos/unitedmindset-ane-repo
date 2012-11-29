package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.net.wifi.WifiManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.WifiManagerContext;

public class RemoveNetworkFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WifiManagerContext c = (WifiManagerContext) context;
		WifiManager w = c.wifiManager;
		
		int netId = convertFreObjectToInt(args[0]);
		
		boolean successful = w.removeNetwork(netId);
		
		FREObject result = null;
		try {
			result = FREObject.newObject(successful);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private int convertFreObjectToInt(FREObject object){
		int i = -1;
		try {
			i = object.getAsInt();
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
		return i;
	}

}
