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

import java.util.HashMap;
import java.util.Map;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class WakeLockContext extends FREContext {

	@Override
	public void dispose() {
		wakeLock = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		map.put("register", new RegisterFunction());
		map.put("deregister", new DeregisterFunction());
		//map.put("isSupported", new IsSupportedFunction());
		map.put("acquire", new AcquireFunction());
		map.put("getScreenTimeout", new GetScreenTimeoutFunction());
		map.put("setScreenTimeout", new SetScreenTimeoutFunction());
		map.put("release", new ReleaseFunction());
		map.put("isHeld", new IsHeldFunction());
		map.put("goToSleep", new GoToSleepFunction());
		map.put("isScreenOn", new IsScreenOnFunction());
		map.put("keepScreenOn", new KeepScreenOnFunction());
		
		return map;
	}
	
	private PowerManager powerManager;
	public PowerManager getPowerManager()
	{
		return powerManager;
	}
	
	public void setPowerManager(PowerManager value)
	{
		powerManager = value;
	}
	
	private WakeLock wakeLock;
	public WakeLock getWakeLock()
	{
		return wakeLock;
	}
	
	public void setWakeLock(WakeLock value)
	{
		wakeLock = value;
	}
	
}
