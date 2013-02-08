package com.unitedmindset.wakelock.extensions;

import android.app.Activity;
import android.provider.Settings;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class GetScreenTimeoutFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WakeLockContext c = (WakeLockContext)context;
		Activity activity = c.getActivity();
		
		int screenOffTimeout = Settings.System.getInt(activity.getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, -999);
		
		FREObject result = null;
		try {
			result = FREObject.newObject(screenOffTimeout);
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
