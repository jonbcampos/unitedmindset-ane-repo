package com.unitedmindset.applicationfinder.extensions;

import java.util.List;

import android.content.pm.ApplicationInfo;
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

public class GetInstalledApplicationsFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args)
	{
		ApplicationFinderContext c = (ApplicationFinderContext)context;
		PackageManager pm = c.packageManager;
		
		List<ApplicationInfo> packs = pm.getInstalledApplications(0);
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
			ApplicationInfo applicationInfo = packs.get(i);
			
			if(applicationInfo == null)
				continue;
			
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
			//set object to array
			try {
				results.setObjectAt(i, result );
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

}
