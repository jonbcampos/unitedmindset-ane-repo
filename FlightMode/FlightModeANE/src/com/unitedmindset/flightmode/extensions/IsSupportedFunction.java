package com.unitedmindset.flightmode.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class IsSupportedFunction implements FREFunction {

	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		FREObject result = null;
		try {
			result = FREObject.newObject(true);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
