package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import java.util.BitSet;
import java.util.List;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class GetConfiguredNetworksFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		ConnectivityManagerContext c = (ConnectivityManagerContext) context;
		WifiManager w = c.wifiManager;
		//get list
		List<WifiConfiguration> list = w.getConfiguredNetworks();
		//null check
		if(list == null) //null check
			return null;
		//get vars
		int i = -1;
		int n = list.size();
		//create array
		FREArray results = null;
		try {
			results = FREArray.newArray(n);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREASErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create translation
		while(++i<n)
		{
			WifiConfiguration configuration = list.get(i);
			if(configuration == null)
				continue;
			
			FREObject result = null;
			try {
				result = FREObject.newObject("com.unitedmindset.extensions.connectivitymanager.vos.WifiConfiguration", null);
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
			_setStringProperty(result, "BSSID", configuration.BSSID);
			_setStringProperty(result, "SSID", configuration.SSID);
			_setBitSetProperty(result, "allowedAuthAlgorithms", configuration.allowedAuthAlgorithms);
			_setBitSetProperty(result, "allowedGroupCiphers", configuration.allowedGroupCiphers);
			_setBitSetProperty(result, "allowedKeyManagement", configuration.allowedKeyManagement);
			_setBitSetProperty(result, "allowedPairwiseCiphers", configuration.allowedPairwiseCiphers);
			_setBitSetProperty(result, "allowedProtocols", configuration.allowedProtocols);
			_setBooleanProperty(result, "hiddenSSID", configuration.hiddenSSID);
			_setIntProperty(result, "networkId", configuration.networkId);
			_setStringProperty(result, "preSharedKey", configuration.preSharedKey);
			_setIntProperty(result, "priority", configuration.priority);
			_setIntProperty(result, "status", configuration.status);
			_setStringArrayProperty(result, "wepKeys", configuration.wepKeys);
			_setIntProperty(result, "wepTxKeyIndex", configuration.wepTxKeyIndex);
			
			try {
				results.setObjectAt(i, result);
			} catch (FREInvalidObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FRETypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FREWrongThreadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return results;
	}
	
	private void _setStringArrayProperty(FREObject data, String propertyLabel, String[] propertyData)
	{
		String s = "";
		if(propertyData != null)
		{
			s = propertyData.toString();
		}
		_setStringProperty(data, propertyLabel, s);
	}
	
	private void _setBitSetProperty(FREObject data, String propertyLabel, BitSet propertyData)
	{
		String s = "";
		if(propertyData != null)
		{
			s = propertyData.toString();
		}
		_setStringProperty(data, propertyLabel, s);
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
