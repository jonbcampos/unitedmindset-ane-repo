/*

Copyright (C) 2012 Jonathan Campos

Permission is hereby granted, free of charge, to any person 
obtaining a copy of this software and associated documentation 
files (the "Software"), to deal in the Software without 
restriction, including without limitation the rights to use, 
copy, modify, merge, publish, distribute, sublicense, and/or 
sell copies of the Software, and to permit persons to whom 
the Software is furnished to do so, subject to the following 
conditions:

The above copyright notice and this permission notice shall 
be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
OTHER DEALINGS IN THE SOFTWARE.

*/
package com.unitedmindset.flightmode.extensions;

import android.content.Intent;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class SetAirplaneModeFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) 
	{
		//find out current state
		boolean isAirplaneModeOn = false;
		try {
			isAirplaneModeOn = Settings.System.getInt(context.getActivity().getContentResolver(), Settings.System.AIRPLANE_MODE_ON) != 0;
		} catch (SettingNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//get set value
		Boolean value = false;
		try {
			value = args[0].getAsBool();
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
		//if match, stop
		if(isAirplaneModeOn == value)
			return null;
		//find value
		int state = (value)?1:0;
		//set value
		Settings.System.putInt(context.getActivity().getContentResolver(),Settings.System.AIRPLANE_MODE_ON, state);
		//alert system of change
		Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
    	intent.putExtra("state", !value);
    	context.getActivity().sendBroadcast(intent);
		//end
		return null;
	}

}
