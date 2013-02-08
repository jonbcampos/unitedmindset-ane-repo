package com.unitedmindset.vibration.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class VibrateFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		VibrationContext c = (VibrationContext)context;
		
		FREObject durationFRE = args[0];
		int duration = 0;
		try {
			duration = durationFRE.getAsInt();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(duration>0)
			c.getVibrator().vibrate(duration);
		
		return null;
	}

}
