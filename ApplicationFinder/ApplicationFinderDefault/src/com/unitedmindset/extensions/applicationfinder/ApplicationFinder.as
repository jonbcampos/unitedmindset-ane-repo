package com.unitedmindset.extensions.applicationfinder
{
	import com.unitedmindset.extensions.applicationfinder.vos.PackageInfo;
	
	import flash.external.ExtensionContext;

	public class ApplicationFinder
	{
		public function ApplicationFinder()
		{
		}
		
		public function register():void
		{
		}
		
		public function dispose():void
		{
		}
		
		public static function isSupported():Boolean{ return false; }
		
		public function getApplicationInfo(uri:String):PackageInfo
		{
			return null;
		}
		
		public function getPackageInfo(uri:String):PackageInfo
		{
			return null;
		}
		
		public function getInstalledApplications():Array
		{
			return null
		}
		
		public function getInstalledPackages():Array
		{
			return null;
		}
		
	}
}