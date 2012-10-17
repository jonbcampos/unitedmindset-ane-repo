package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.unitedmindset.connectivitymanager.extensions.ConnectivityManagerContext;

public class RegisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		ConnectivityManagerContext cmc = (ConnectivityManagerContext) context;
		Activity activity = cmc.getActivity();
		cmc.connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
		
		ConnectivityListener listener = new ConnectivityListener();
		listener.setFREContext(context);
		cmc.setConnectivityListener(listener);
		activity.registerReceiver(listener, filter);
		
		return null;
	}

}
