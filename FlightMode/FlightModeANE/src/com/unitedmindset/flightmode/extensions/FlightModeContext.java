package com.unitedmindset.flightmode.extensions;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class FlightModeContext extends FREContext {

	private FlightModeListener connectivityListener;
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		map.put("isAirplaneModeOn", new IsAirplaneModeOnFunction());
		map.put("setAirplaneMode", new SetAirplaneModeFunction());
		map.put("register", new RegisterFunction());
		map.put("deregister", new DeregisterFunction());
		map.put("isSupported", new IsSupportedFunction());
		
		return map;
	}
	
	public void setConnectivityListener(FlightModeListener listener)
	{
		connectivityListener = listener;
	}
	
	public FlightModeListener getConnectivityListener()
	{
		return connectivityListener;
	}

}
