package com.unitedmindset.extensions.applicationfinder
{
	import com.unitedmindset.extensions.applicationfinder.vos.ApplicationInfo;
	import com.unitedmindset.extensions.applicationfinder.vos.PackageInfo;
	
	import flash.external.ExtensionContext;

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
		
		public function register():void
		{
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);
			if(!_registered)
				_context.call(REGISTER);
			_registered = true;
		}
		
		public function dispose():void
		{
			if(_registered)
				_context.call(DEREGISTER);
			_registered = false;
			_context.dispose();
			_context = null;
		}
		
		public static function isSupported():Boolean{ return true; }
		
		public function getApplicationInfo(uri:String):ApplicationInfo
		{
			if(!_registered) register();
			return _context.call(GET_APPLICATION_INFO, uri) as ApplicationInfo;
		}
		
		public function getPackageInfo(uri:String):PackageInfo
		{
			if(!_registered) register();
			return _context.call(GET_PACKAGE_INFO, uri) as PackageInfo;
		}
		
		public function getInstalledApplications():Array
		{
			if(!_registered) register();
			return _context.call(GET_INSTALLED_APPLICATIONS) as Array;
		}
		
		public function getInstalledPackages():Array
		{
			if(!_registered) register();
			return _context.call(GET_INSTALLED_PACKAGES) as Array;
		}
		
		public function getIconById(id:String):Object
		{
			if(!_registered) register();
			var obj:Object = _context.call(GET_ICON_BY_ID);
			return obj;
		}
		
	}
}