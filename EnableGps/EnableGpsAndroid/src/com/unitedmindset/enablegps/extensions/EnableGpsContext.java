package com.unitedmindset.enablegps.extensions;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class EnableGpsContext extends FREContext {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		map.put("register", new RegisterFunction());
		map.put("deregister", new DeregisterFunction());
		map.put("enableGps", new EnableGpsFunction());
		
		return map;
	}

}
