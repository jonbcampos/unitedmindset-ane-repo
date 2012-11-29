package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.WifiManagerContext;

public class GetConnectionInfoFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WifiManagerContext c = (WifiManagerContext) context;
		WifiManager w = c.wifiManager;
		
		WifiInfo wifiInfo = w.getConnectionInfo();
		
		FREObject result = null;
		try {
			result = FREObject.newObject("com.unitedmindset.extensions.connectivitymanager.vos.WifiInfo", null);
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
		
		_setStringProperty(result, "BSSID", wifiInfo.getBSSID());
		_setBooleanProperty(result, "hiddenSSID", wifiInfo.getHiddenSSID());
		_setIntProperty(result, "ipAddress", wifiInfo.getIpAddress());
		_setIntProperty(result, "linkSpeed", wifiInfo.getLinkSpeed());
		_setStringProperty(result, "macAddress", wifiInfo.getMacAddress());
		_setIntProperty(result, "networkId", wifiInfo.getNetworkId());
		_setIntProperty(result, "rssi", wifiInfo.getRssi());
		_setStringProperty(result, "SSID", wifiInfo.getSSID());
		
		return result;
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
