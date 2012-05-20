package com.unitedmindset.applicationfinder.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DeregisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] arg0)
	{
		ApplicationFinderContext c = (ApplicationFinderContext)context;
		c.dispose();
		return null;
	}

}
