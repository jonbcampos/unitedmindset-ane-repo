package com.unitedmindset.batterymanager.extensions;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class BatteryManagerContext extends FREContext {

	private BatteryManagerListener listener;
	public BatteryManagerListener getBatteryManagerListener()
	{
		return listener;
	}
	
	public void setBatteryManagerListener(BatteryManagerListener value)
	{
		listener = value;
	}
	
	@Override
	public void dispose() {
		listener = null;
		
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		map.put("register", new RegisterFunction());
		map.put("deregister", new DeregisterFunction());
		return map;
	}

}
