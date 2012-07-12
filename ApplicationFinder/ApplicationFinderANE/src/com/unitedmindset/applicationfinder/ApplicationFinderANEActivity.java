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