package com.unitedmindset.batterymanager;

import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.unitedmindset.batterymanager.extensions.BatteryManagerListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        IntentFilter intentFilter = new IntentFilter( Intent.ACTION_BATTERY_CHANGED );
        BatteryManagerListener receiver = new BatteryManagerListener();
        getApplicationContext().registerReceiver(receiver, intentFilter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
