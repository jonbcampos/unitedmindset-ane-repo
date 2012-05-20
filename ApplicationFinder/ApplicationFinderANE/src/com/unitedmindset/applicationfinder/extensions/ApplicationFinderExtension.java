package com.unitedmindset.applicationfinder.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ApplicationFinderExtension implements FREExtension {

	public FREContext createContext(String contextType)
	{
		return new ApplicationFinderContext();
	}

	public void dispose() { }

	public void initialize() { }

}
