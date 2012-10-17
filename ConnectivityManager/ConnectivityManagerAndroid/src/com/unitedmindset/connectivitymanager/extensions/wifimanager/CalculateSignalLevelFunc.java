package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.net.wifi.WifiManager;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class CalculateSignalLevelFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		//ConnectivityManagerContext c = (ConnectivityManagerContext) context;
		//WifiManager w = c.wifiManager;
		
		int rssi = convertFreObjectToInt(args[0]);
		Log.i("CalculateSignalLevelFunc", ""+rssi);
		int numLevels = convertFreObjectToInt(args[1]);
		
		int signalLevel = WifiManager.calculateSignalLevel(rssi, numLevels);
		
		FREObject returnValue = null;
		try {
			returnValue = FREObject.newObject(signalLevel);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
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
