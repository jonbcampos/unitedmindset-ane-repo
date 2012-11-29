package com.unitedmindset.batterymanager.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class BatteryManagerExtension implements FREExtension {

	private BatteryManagerContext cmContext;
	
	public FREContext createContext(String contextRequest) {
		if(cmContext==null)
			cmContext = new BatteryManagerContext();
		return cmContext;
	}

	public void dispose() {
		cmContext = null;
	}

	public void initialize() {
		//do nothing
	}

}
