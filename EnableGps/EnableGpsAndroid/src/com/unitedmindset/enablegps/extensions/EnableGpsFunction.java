package com.unitedmindset.enablegps.extensions;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class EnableGpsFunction implements FREFunction {

	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		EnableGpsContext context = (EnableGpsContext)arg0;
		Activity activity = context.getActivity();
		
		Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		activity.startActivity(intent);
		return null;
	}

}
