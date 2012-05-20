package com.unitedmindset.applicationfinder;

import java.util.List;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ApplicationFinderANEActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button appButton;
	private Button packageButton;
	private ListView listView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        appButton = (Button)findViewById(R.id.button1);
        packageButton = (Button)findViewById(R.id.button2);
        listView = (ListView)findViewById(R.id.mylist);
        
        //add button listeners
        OnClickListener listener1 = new OnClickListener() {
			
			public void onClick(View arg0) {
				handleAppButtonClick();
			}
		};
		appButton.setOnClickListener(listener1);
		
		OnClickListener listener2 = new OnClickListener() {
			
			public void onClick(View arg0) {
				handlePackageButtonClick();
			}
		};
		packageButton.setOnClickListener(listener2);
    }
    
    public void handleAppButtonClick()
    {
    	List<ApplicationInfo> list = getPackageManager().getInstalledApplications(0);
    	ArrayAdapter<ApplicationInfo> adaptor = new ArrayAdapter<ApplicationInfo>(this, android.R.layout.simple_list_item_1, list);
    	listView.setAdapter( adaptor );
    }
    
    public void handlePackageButtonClick()
    {
    	List<PackageInfo> list = getPackageManager().getInstalledPackages(0);
    	ArrayAdapter<PackageInfo> adaptor = new ArrayAdapter<PackageInfo>(this, android.R.layout.simple_list_item_1, list);
    	listView.setAdapter( adaptor );
    }
}