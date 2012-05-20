package com.unitedmindset.flightmode.extensions;

import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class IsAirplaneModeOnFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		Boolean isAirplaneModeOn = false;
		try {
			isAirplaneModeOn = Settings.System.getInt(context.getActivity().getContentResolver(), Settings.System.AIRPLANE_MODE_ON) != 0;
		} catch (SettingNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FREObject result = null;
		try {
			result = FREObject.newObject( isAirplaneModeOn );
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
