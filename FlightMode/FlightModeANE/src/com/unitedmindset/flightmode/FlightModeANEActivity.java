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
package com.unitedmindset.flightmode;

import java.util.Map;

import com.unitedmindset.flightmode.extensions.FlightModeListener;
import com.unitedmindset.flightmode.R;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class FlightModeANEActivity extends Activity {
    /** Called when the activity is first created. */
    
	private ToggleButton toggleButton;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton1);
        try {
			toggleButton.setChecked( Settings.System.getInt( getContentResolver(), Settings.System.AIRPLANE_MODE_ON) != 0 );
		} catch (SettingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //add status change listener
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        FlightModeListener receiver = new FlightModeListener() {
			
			@Override
			public void onReceive(Context context, Intent intent) {
				
				FREContext c = new FREContext() {
					
					@Override
					public Map<String, FREFunction> getFunctions() {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public void dispose() {
						// TODO Auto-generated method stub
						
					}
				};
				
				this.setFREContext(c);
				
				super.onReceive(context, intent);
				
				respondToAirplaneModeChange(context, intent);
			}
		};
		getApplicationContext().registerReceiver(receiver, intentFilter);
        
        //add click listener
        OnCheckedChangeListener listener = new OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				handleToggleButtonClick(isChecked);
			}
		};
		toggleButton.setOnCheckedChangeListener(listener);
    }

    public void handleToggleButtonClick(boolean isChecked)
    {
    	int value = (isChecked)?1:0;
    	Settings.System.putInt(getContentResolver(),Settings.System.AIRPLANE_MODE_ON, value);
    	
    	Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
    	intent.putExtra("state", !isChecked);
    	sendBroadcast(intent);
    }
    
    public void respondToAirplaneModeChange(Context context, Intent intent)
    {
    	Boolean extra = intent.getBooleanExtra("state", false);
    	toggleButton.setChecked( extra );
    }
}