package com.unitedmindset.connectivitymanager.extensions.wifimanager;

import android.content.Intent;
import android.provider.Settings;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class LaunchWifiSettingsFunc implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		//launch activity
		context.getActivity().startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
		
		return null;
	}

}
