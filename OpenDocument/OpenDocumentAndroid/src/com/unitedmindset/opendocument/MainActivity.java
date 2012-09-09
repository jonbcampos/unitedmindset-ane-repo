package com.unitedmindset.opendocument;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
