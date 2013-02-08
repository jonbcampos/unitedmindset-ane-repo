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
package com.unitedmindset.wakelock.extensions;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class RegisterFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		WakeLockContext c = (WakeLockContext)context;
		Activity activity = c.getActivity();
		
		PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
		c.setPowerManager(pm);
		
		//get flags
		int flag = PowerManager.FULL_WAKE_LOCK;
		String tag = "WakeLockAne";
		boolean referenceCounted = true;
		if(args!=null && args.length>0)
		{
			try {
				flag = args[0].getAsInt();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FRETypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FREInvalidObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FREWrongThreadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//get tag
			if(args.length>1)
			{
				try {
					tag = args[1].getAsString();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (FRETypeMismatchException e) {
					e.printStackTrace();
				} catch (FREInvalidObjectException e) {
					e.printStackTrace();
				} catch (FREWrongThreadException e) {
					e.printStackTrace();
				}
			}
			
			//get tag
			if(args.length>2)
			{
				try {
					referenceCounted = args[2].getAsBool();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (FRETypeMismatchException e) {
					e.printStackTrace();
				} catch (FREInvalidObjectException e) {
					e.printStackTrace();
				} catch (FREWrongThreadException e) {
					e.printStackTrace();
				}
			}
		}
		
		WakeLock w = pm.newWakeLock(flag, tag);
		w.setReferenceCounted(referenceCounted);
		c.setWakeLock(w);
		
		return null;
	}

}
