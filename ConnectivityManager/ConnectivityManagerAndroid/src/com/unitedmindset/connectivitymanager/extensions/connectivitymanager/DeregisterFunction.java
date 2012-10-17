package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import android.app.Activity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class DeregisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		ConnectivityManagerContext cmc = (ConnectivityManagerContext) context;
		Activity activity = cmc.getActivity();
		
		ConnectivityListener listener = cmc.getConnectivityListener();
		if(listener != null)
		{
			activity.unregisterReceiver(listener);
			cmc.setConnectivityListener(null);
		}
		
		return null;
	}

}
