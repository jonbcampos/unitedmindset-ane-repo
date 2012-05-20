package com.unitedmindset.applicationfinder.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class GetResourceByIdFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args)
	{
		String id = "";
		try{
			id = args[0].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		ApplicationFinderContext c = (ApplicationFinderContext)context;
		int result = 0;
		result = c.getResourceId(id);
		
		FREObject returnObject = null;
		try {
			returnObject = FREObject.newObject(result);
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnObject;
	}

}
