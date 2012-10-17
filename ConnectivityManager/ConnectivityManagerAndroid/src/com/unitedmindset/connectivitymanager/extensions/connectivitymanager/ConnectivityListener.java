package com.unitedmindset.connectivitymanager.extensions.connectivitymanager;

import com.adobe.fre.FREContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConnectivityListener extends BroadcastReceiver {

	private FREContext freContext;

	public void setFREContext(FREContext context) {
		freContext = context;
	}
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		
		freContext.dispatchStatusEventAsync("connectivityChange", "");
	}

}
