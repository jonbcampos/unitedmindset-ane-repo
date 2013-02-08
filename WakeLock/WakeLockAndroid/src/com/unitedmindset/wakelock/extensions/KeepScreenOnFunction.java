package com.unitedmindset.wakelock.extensions;

import android.view.WindowManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class KeepScreenOnFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WakeLockContext c = (WakeLockContext)context;
		
		c.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		return null;
	}

}
