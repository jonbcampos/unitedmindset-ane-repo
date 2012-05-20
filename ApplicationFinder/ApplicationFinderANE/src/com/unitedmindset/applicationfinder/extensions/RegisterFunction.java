package com.unitedmindset.applicationfinder.extensions;

import android.app.Activity;
import android.content.Context;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class RegisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] arg0)
	{
		ApplicationFinderContext afc = (ApplicationFinderContext)context;
		Activity activity = afc.getActivity();
		Context applicationContext = activity.getApplicationContext();
		afc.packageManager = applicationContext.getPackageManager();
		
		return null;
	}

}
