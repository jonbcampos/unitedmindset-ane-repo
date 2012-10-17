package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import android.net.ConnectivityManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class StopUsingNetworkFeatureFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		ConnectivityManagerContext c = (ConnectivityManagerContext) context;
		ConnectivityManager cm = c.connectivityManager;
		
		int networkType = convertFreObjectToInt(args[0]);
		String feature = convertFreObjectToString(args[1]);
		
		int data = cm.stopUsingNetworkFeature(networkType, feature);
		FREObject returnValue = null;
		try {
			returnValue = FREObject.newObject(data);
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
