package com.unitedmindset.connectivitymanager.extensions;

import java.util.HashMap;
import java.util.Map;

import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.ConnectivityListener;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetActiveNetworkInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetAllNetworkInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetNetworkInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.GetNetworkPreferenceFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.IsNetworkTypeValidFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.RequestRouteToHostFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.SetNetworkPreferenceFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.StartUsingNetworkFeatureFunc;
import com.unitedmindset.connectivitymanager.extensions.connectivitymanager.StopUsingNetworkFeatureFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.CalculateSignalLevelFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.CompareSignalLevelFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.DisconnectFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.EnableNetworkFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.GetConfiguredNetworksFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.GetConnectionInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.GetDhcpInfoFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.GetScanResultsFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.GetWifiStateFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.IsWifiEnabledFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.LaunchWifiSettingsFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.PingSupplicantFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.ReassociateFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.ReconnectFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.RemoveNetworkFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.SaveConfigurationFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.SetWifiEnabledFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.StartScanFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.UpdateNetworkFunc;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.WifiListener;
import com.unitedmindset.connectivitymanager.extensions.wifimanager.WifiScanListener;

public class ConnectivityManagerContext extends FREContext {

	public ConnectivityManager connectivityManager;
	public WifiManager wifiManager;
	
	private ConnectivityListener connectivityListener;
	private WifiListener wifiListener;
	private WifiScanListener wifiScanListener;
	
	@Override
	public void dispose() {
		connectivityManager = null;
		wifiManager = null;
		connectivityListener = null;
		wifiListener = null;
		wifiScanListener = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		//connection manager
		map.put("registerConnectivityManager", new com.unitedmindset.connectivitymanager.extensions.connectivitymanager.RegisterFunction());
		map.put("deregisterConnectivityManager", new com.unitedmindset.connectivitymanager.extensions.connectivitymanager.DeregisterFunction());
		map.put("getActiveNetworkInfo", new GetActiveNetworkInfoFunc());
		map.put("getAllNetworkInfo", new GetAllNetworkInfoFunc());
		map.put("getNetworkInfo", new GetNetworkInfoFunc());
		map.put("getNetworkPreference", new GetNetworkPreferenceFunc());
		map.put("isNetworkTypeValid", new IsNetworkTypeValidFunc());
		map.put("requestRouteToHost", new RequestRouteToHostFunc());
		map.put("setNetworkPreference", new SetNetworkPreferenceFunc());
		map.put("startUsingNetworkFeature", new StartUsingNetworkFeatureFunc());
		map.put("stopUsingNetworkFeature", new StopUsingNetworkFeatureFunc());
		
		//wifi manager
		map.put("registerWifiManager", new com.unitedmindset.connectivitymanager.extensions.wifimanager.RegisterFunction());
		map.put("deregisterWifiManager", new com.unitedmindset.connectivitymanager.extensions.wifimanager.DeregisterFunction());
		//map.put("addNetwork", new AddNetworkFunc());
		map.put("calculateSignalLevel", new CalculateSignalLevelFunc());
		map.put("compareSignalLevel", new CompareSignalLevelFunc());
		//map.put("createMulticastLock", new CreateMulticastLockFunc());
		//map.put("createWifiLock", new CreateWifiLockFunc());
		//map.put("disableNetwork", new DisableNetworkFunc());
		map.put("disconnect", new DisconnectFunc());
		map.put("enableNetwork", new EnableNetworkFunc());
		map.put("getConfiguredNetworks", new GetConfiguredNetworksFunc());
		map.put("getConnectionInfo", new GetConnectionInfoFunc());
		map.put("getDhcpInfo", new GetDhcpInfoFunc());
		map.put("getScanResults", new GetScanResultsFunc());
		map.put("getWifiState", new GetWifiStateFunc());
		map.put("isWifiEnabled", new IsWifiEnabledFunc());
		map.put("pingSupplicant", new PingSupplicantFunc());
		map.put("reassociate", new ReassociateFunc());
		map.put("reconnect", new ReconnectFunc());
		map.put("removeNetwork", new RemoveNetworkFunc());
		map.put("saveConfiguration", new SaveConfigurationFunc());
		map.put("setWifiEnabled", new SetWifiEnabledFunc());
		map.put("startScan", new StartScanFunc());
		map.put("updateNetwork", new UpdateNetworkFunc());
		map.put("launchWifiSettings", new LaunchWifiSettingsFunc());
		
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

	public void setWifiListener(WifiListener listener) {
		wifiListener = listener;
	}

	public WifiListener getWifiListener() {
		return wifiListener;
	}
	
	public void setWifiScanListener(WifiScanListener listener) {
		wifiScanListener = listener;
	}
	
	public WifiScanListener getWifiScanListener() {
		return wifiScanListener;
	}
	

}
