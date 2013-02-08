package com.unitedmindset.wakelock.extensions;

import android.app.Activity;
import android.provider.Settings;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class SetScreenTimeoutFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WakeLockContext c = (WakeLockContext)context;
		Activity activity = c.getActivity();
		
		int timeout = 0;
		if(args!=null && args.length==1)
		{
			try {
				timeout = args[0].getAsInt();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (FRETypeMismatchException e) {
				e.printStackTrace();
			} catch (FREInvalidObjectException e) {
				e.printStackTrace();
			} catch (FREWrongThreadException e) {
				e.printStackTrace();
			}
		}
		
		Settings.System.putInt(activity.getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, timeout);
		
		return null;
	}

}
