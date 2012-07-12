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
package com.unitedmindset.extensions.applicationfinder
{
	import com.unitedmindset.extensions.applicationfinder.vos.ApplicationInfo;
	import com.unitedmindset.extensions.applicationfinder.vos.PackageInfo;
	
	import flash.external.ExtensionContext;
	/**
	 * ANE that provides Package and Application
	 * Information from the Device.
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class ApplicationFinder
	{
		private var _context:ExtensionContext;
		private var _registered:Boolean;
		
		private const EXTENSION_ID:String = "com.unitedmindset.extensions.ApplicationFinder";
		private const GET_APPLICATION_INFO:String = "getApplicationInfo";
		private const GET_INSTALLED_APPLICATIONS:String = "getInstalledApplications";
		private const GET_INSTALLED_PACKAGES:String = "getInstalledPackages";
		private const GET_PACKAGE_INFO:String = "getPackageInfo";
		private const REGISTER:String = "register";
		private const DEREGISTER:String = "deregister";
		private const GET_ICON_BY_ID:String = "getIconById";
		
		public function ApplicationFinder()
		{
			
		}
		
		/**
		 * Registers the ANE with the Native Process.
		 */		
		public function register():void
		{
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);
			if(!_registered)
				_context.call(REGISTER);
			_registered = true;
		}
		
		/**
		 * Deregisters the ANE with the Native Process.
		 */		
		public function dispose():void
		{
			if(_registered)
				_context.call(DEREGISTER);
			_registered = false;
			_context.dispose();
			_context = null;
		}
		
		/**
		 * Denotes if the device supports this feature. 
		 * @return 
		 * 
		 */		
		public static function isSupported():Boolean{ return true; }
		
		/**
		 * Returns the application information for a specific uri.
		 * Returns <code>null</code> if no application exists 
		 * on the device.
		 *  
		 * @param uri
		 * @return 
		 * 
		 */		
		public function getApplicationInfo(uri:String):ApplicationInfo
		{
			if(!_registered) register();
			return _context.call(GET_APPLICATION_INFO, uri) as ApplicationInfo;
		}
		
		/**
		 * Returns the package information for a specific uri.
		 * Returns <code>null</code> if no package exists 
		 * on the device.
		 *  
		 * @param uri
		 * @return 
		 * 
		 */
		public function getPackageInfo(uri:String):PackageInfo
		{
			if(!_registered) register();
			return _context.call(GET_PACKAGE_INFO, uri) as PackageInfo;
		}
		
		/**
		 * Returns a list of all the installed applications
		 * on the device.
		 *  
		 * @return 
		 * 
		 */		
		public function getInstalledApplications():Array
		{
			if(!_registered) register();
			return _context.call(GET_INSTALLED_APPLICATIONS) as Array;
		}
		
		/**
		 * Returns a list of all the installed packages
		 * on the device.
		 *  
		 * @return 
		 * 
		 */		
		public function getInstalledPackages():Array
		{
			if(!_registered) register();
			return _context.call(GET_INSTALLED_PACKAGES) as Array;
		}
		
		/**
		 * Was trying to come up with a way to pull
		 * the icon from the system. Incomplete.
		 * @param id
		 * @return 
		 * 
		 */
		/*
		public function getIconById(id:String):Object
		{
			if(!_registered) register();
			var obj:Object = _context.call(GET_ICON_BY_ID);
			return obj;
		}
		*/
	}
}