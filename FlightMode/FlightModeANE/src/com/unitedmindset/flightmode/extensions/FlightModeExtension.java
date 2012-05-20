package com.unitedmindset.flightmode.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class FlightModeExtension implements FREExtension {

	public FREContext createContext(String arg0) {
		return new FlightModeContext();
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void initialize() {
		// TODO Auto-generated method stub

	}

}
