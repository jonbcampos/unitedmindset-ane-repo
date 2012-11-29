package com.unitedmindset.connectivitymanager.extensions;

import java.util.HashMap;
import java.util.Map;

import android.net.ConnectivityManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.ConnectivityListener;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.DeregisterFunction;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetActiveNetworkInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetAllNetworkInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetNetworkInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetNetworkPreferenceFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.IsNetworkTypeValidFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.RegisterFunction;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.RequestRouteToHostFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.SetNetworkPreferenceFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.StartUsingNetworkFeatureFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.StopUsingNetworkFeatureFunc;

public class ConnectivityManagerContext extends FREContext {

	public ConnectivityManager connectivityManager;
	
	private ConnectivityListener connectivityListener;
	
	@Override
	public void dispose() {
		connectivityManager = null;
		connectivityListener = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		//connection manager
		map.put("registerConnectivityManager", new RegisterFunction());
		map.put("deregisterConnectivityManager", new DeregisterFunction());
		map.put("getActiveNetworkInfo", new GetActiveNetworkInfoFunc());
		map.put("getAllNetworkInfo", new GetAllNetworkInfoFunc());
		map.put("getNetworkInfo", new GetNetworkInfoFunc());
		map.put("getNetworkPreference", new GetNetworkPreferenceFunc());
		map.put("isNetworkTypeValid", new IsNetworkTypeValidFunc());
		map.put("requestRouteToHost", new RequestRouteToHostFunc());
		map.put("setNetworkPreference", new SetNetworkPreferenceFunc());
		map.put("startUsingNetworkFeature", new StartUsingNetworkFeatureFunc());
		map.put("stopUsingNetworkFeature", new StopUsingNetworkFeatureFunc());
		
		return map;
	}
	
	//listener hold area
	//to make sure none
	//lose scope
	public void setConnectivityListener(ConnectivityListener listener) {
		connectivityListener = listener;
	}

	public ConnectivityListener getConnectivityListener() {
		return connectivityListener;
	}

}
