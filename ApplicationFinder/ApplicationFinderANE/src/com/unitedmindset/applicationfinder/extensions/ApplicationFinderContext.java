package com.unitedmindset.applicationfinder.extensions;

import java.util.HashMap;
import java.util.Map;

import android.content.pm.PackageManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class ApplicationFinderContext extends FREContext {
	
	public PackageManager packageManager = null;
	
	@Override
	public void dispose()
	{
		packageManager = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		map.put("getApplicationInfo", new GetApplicationInfoFunction());
		map.put("getInstalledApplications", new GetInstalledApplicationsFunction());
		map.put("getInstalledPackages", new GetInstalledPackagesFunction());
		map.put("getPackageInfo", new GetPackageInfoFunction());
		map.put("register", new RegisterFunction());
		map.put("deregister", new DeregisterFunction());
		
		return map;
	}

}
