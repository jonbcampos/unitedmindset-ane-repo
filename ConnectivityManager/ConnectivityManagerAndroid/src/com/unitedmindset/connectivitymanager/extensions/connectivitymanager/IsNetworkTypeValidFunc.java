package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import android.net.ConnectivityManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class IsNetworkTypeValidFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		//ConnectivityManagerContext c = (ConnectivityManagerContext) context;
		//ConnectivityManager cm = c.connectivityManager;
		
		int networkType = convertFreObjectToInt(args[0]);
		boolean valid = ConnectivityManager.isNetworkTypeValid(networkType);
		
		FREObject returnValue = null;
		try {
			returnValue = FREObject.newObject(valid);
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
