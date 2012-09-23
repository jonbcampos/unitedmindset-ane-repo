package com.unitedmindset.enablegps.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class EnableGpsExtension implements FREExtension {

	@Override
	public FREContext createContext(String arg0) {
		return new EnableGpsContext();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

}
