package com.unitedmindset.batterymanager.extensions;

import com.adobe.fre.FREContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class BatteryManagerListener extends BroadcastReceiver {

	private FREContext freContext;
	public void setFREContext(FREContext context)
	{
		freContext = context;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//get info
		boolean isPresent = intent.getBooleanExtra( BatteryManager.EXTRA_PRESENT, false);
		String technology = intent.getStringExtra( BatteryManager.EXTRA_TECHNOLOGY );
		int plugged = intent.getIntExtra( BatteryManager.EXTRA_PLUGGED, -1);
		int scale = intent.getIntExtra( BatteryManager.EXTRA_SCALE, -1);
		int health = intent.getIntExtra( BatteryManager.EXTRA_HEALTH, 0);
		int status = intent.getIntExtra( BatteryManager.EXTRA_STATUS, 0);
		int rawLevel = intent.getIntExtra( BatteryManager.EXTRA_LEVEL, -1);
		int temperature = intent.getIntExtra( BatteryManager.EXTRA_TEMPERATURE, 0);
		int voltage = intent.getIntExtra( BatteryManager.EXTRA_VOLTAGE, 0);
		//make a json string for transfer
		String returnResult = new String();
		returnResult += String.valueOf(isPresent)+",";
		returnResult += technology+",";
		returnResult += plugged+",";
		returnResult += scale+",";
		returnResult += health+",";
		returnResult += status+",";
		returnResult += rawLevel+",";
		returnResult += temperature+",";
		returnResult += voltage;
		//release the hounds!
		if(freContext!=null)
			freContext.dispatchStatusEventAsync("batteryChanged", returnResult);
	}

}
