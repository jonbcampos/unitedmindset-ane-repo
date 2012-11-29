package com.unitedmindset.connectivitymanager.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ConnectivityManagerExtension implements FREExtension {

	private ConnectivityManagerContext cmContext;
	private WifiManagerContext wmContext;
	
	public FREContext createContext(String contextRequest) {
		if(contextRequest.equals("WifiManager"))
		{
			if(wmContext==null)
				wmContext = new WifiManagerContext();
			return wmContext;
		} else {
			if(cmContext==null)
				cmContext = new ConnectivityManagerContext();
			return cmContext;
		}
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void initialize() {
		// TODO Auto-generated method stub

	}

}
