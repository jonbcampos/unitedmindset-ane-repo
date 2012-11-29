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
