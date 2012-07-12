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

import java.util.List;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class GetInstalledPackagesFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args)
	{
		ApplicationFinderContext c = (ApplicationFinderContext)context;
		PackageManager pm = c.packageManager;
		
		List<PackageInfo> packs = pm.getInstalledPackages(0);
		int size = packs.size();
		
		FREArray results = null;
		try {
			results = FREArray.newArray(size);
		} catch (FREASErrorException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<size;i++)
		{
			PackageInfo p = packs.get(i);
			
			if(p.versionName == null)
				continue;
			
			FREObject info = null;
			//new object
			try {
				info = FREObject.newObject("com.unitedmindset.extensions.applicationfinder.vos.PackageInfo", null);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (FRETypeMismatchException e1) {
				e1.printStackTrace();
			} catch (FREInvalidObjectException e1) {
				e1.printStackTrace();
			} catch (FREASErrorException e1) {
				e1.printStackTrace();
			} catch (FRENoSuchNameException e1) {
				e1.printStackTrace();
			} catch (FREWrongThreadException e1) {
				e1.printStackTrace();
			}
			//packageName:String
			try {
				_setProperty(info, "packageName", FREObject.newObject( p.packageName ));
			} catch (FREWrongThreadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//versionName:String
			try {
				_setProperty(info, "versionName", FREObject.newObject( p.versionName ));
			} catch (FREWrongThreadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//versionCode:String
			try {
				_setProperty(info, "versionCode", FREObject.newObject( p.versionCode ));
			} catch (FREWrongThreadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//applicationInfo:ApplicationInfo
			_setApplicationInfo(info, p.applicationInfo);
			//set object to array
			try {
				results.setObjectAt(i, info );
			} catch (FREInvalidObjectException e) {
				e.printStackTrace();
			} catch (FRETypeMismatchException e) {
				e.printStackTrace();
			} catch (FREWrongThreadException e) {
				e.printStackTrace();
			}
		}
		
		return results;
	}
	
	private void _setProperty(FREObject data, String propertyLabel, FREObject object)
	{
		try {
			data.setProperty(propertyLabel, object);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}
	
	private void _setApplicationInfo(FREObject data, ApplicationInfo applicationInfo)
	{
		//no applicationInfo? return now
		if(applicationInfo==null)
			return;
		
		FREObject result = null;
		//new object
		try {
			result = FREObject.newObject("com.unitedmindset.extensions.applicationfinder.vos.ApplicationInfo", null);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
		//name
		try {
			_setProperty(result, "permission", FREObject.newObject( applicationInfo.permission ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dataDir:String
		try {
			_setProperty(result, "dataDir", FREObject.newObject( applicationInfo.dataDir ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//packageName:String
		try {
			_setProperty(result, "packageName", FREObject.newObject( applicationInfo.packageName ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//processName:String
		try {
			_setProperty(result, "processName", FREObject.newObject( applicationInfo.processName ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//publicSourceDir:String
		try {
			_setProperty(result, "publicSourceDir", FREObject.newObject( applicationInfo.publicSourceDir ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sourceDir:String
		try {
			_setProperty(result, "sourceDir", FREObject.newObject( applicationInfo.sourceDir ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//targetSdkVersion:int
		try {
			_setProperty(result, "targetSdkVersion", FREObject.newObject( applicationInfo.targetSdkVersion ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//taskAffinity:String
		try {
			_setProperty(result, "taskAffinity", FREObject.newObject( applicationInfo.taskAffinity ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//uid:Number
		try {
			_setProperty(result, "uid", FREObject.newObject( applicationInfo.uid ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//icon:Number
		try {
			_setProperty(result, "icon", FREObject.newObject( applicationInfo.icon ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set to packageInfo
		try {
			data.setProperty("applicationInfo", result);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}

}
