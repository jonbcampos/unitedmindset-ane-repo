package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class GetNetworkInfoFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		ConnectivityManagerContext c = (ConnectivityManagerContext) context;
		ConnectivityManager cm = c.connectivityManager;
		
		int networkType = convertFreObjectToInt(args[0]);
		NetworkInfo ni = cm.getNetworkInfo(networkType);
		
		FREObject result = null;
		try {
			result = FREObject.newObject("com.unitedmindset.extensions.connectivitymanager.vos.NetworkInfo", null);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREASErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRENoSuchNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_setStringProperty(result, "detailedState", ni.getDetailedState().name());
		_setStringProperty(result, "extraInfo", ni.getExtraInfo().toString());
		_setStringProperty(result, "reason", ni.getReason());
		_setStringProperty(result, "state", ni.getState().name());
		_setIntProperty(result, "subType", ni.getSubtype());
		_setStringProperty(result, "subTypeName", ni.getSubtypeName());
		_setIntProperty(result, "type", ni.getType());
		_setStringProperty(result, "typeName", ni.getTypeName());
		_setBooleanProperty(result, "isAvailable", ni.isAvailable());
		_setBooleanProperty(result, "isConnected", ni.isConnected());
		_setBooleanProperty(result, "isConnectedOrConnecting", ni.isConnectedOrConnecting());
		_setBooleanProperty(result, "isFailover", ni.isFailover());
		_setBooleanProperty(result, "isRoaming", ni.isRoaming());
		
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
	
	private void _setStringProperty(FREObject data, String propertyLabel, String propertyData)
	{
		FREObject object = null;
		try {
			object = FREObject.newObject(propertyData);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			data.setProperty(propertyLabel, object);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}
	
	private void _setBooleanProperty(FREObject data, String propertyLabel, Boolean propertyData)
	{
		FREObject object = null;
		try {
			object = FREObject.newObject(propertyData);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			data.setProperty(propertyLabel, object);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}
	
	private void _setIntProperty(FREObject data, String propertyLabel, int propertyData)
	{
		FREObject object = null;
		try {
			object = FREObject.newObject(propertyData);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			data.setProperty(propertyLabel, object);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}

}
