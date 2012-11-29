package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import java.util.List;

import android.net.wifi.ScanResult;
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
import com.unitedmindset.connectivitymanager.extensions.WifiManagerContext;

public class GetScanResultsFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WifiManagerContext c = (WifiManagerContext) context;
		WifiManager w = c.wifiManager;
		
		List<ScanResult> list = w.getScanResults();
		if(list == null)
			return null;
		
		//vars
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
			ScanResult scanResult = list.get(i);
			if(scanResult == null)
				continue;
			
			FREObject result = null;
			try {
				result = FREObject.newObject("com.unitedmindset.extensions.connectivitymanager.vos.ScanResult", null);
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
			
			_setStringProperty(result, "BSSID", scanResult.BSSID);
			_setStringProperty(result, "SSID", scanResult.SSID);
			_setStringProperty(result, "capabilities", scanResult.capabilities);
			_setIntProperty(result, "frequency", scanResult.frequency);
			_setIntProperty(result, "level", scanResult.level);
			
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
