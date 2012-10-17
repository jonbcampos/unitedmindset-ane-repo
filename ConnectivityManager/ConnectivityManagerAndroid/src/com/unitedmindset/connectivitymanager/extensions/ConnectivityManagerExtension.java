package com.unitedmindset.connectivitymanager.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ConnectivityManagerExtension implements FREExtension {

	public FREContext createContext(String arg0) {
		return new ConnectivityManagerContext();
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void initialize() {
		// TODO Auto-generated method stub

	}

}
