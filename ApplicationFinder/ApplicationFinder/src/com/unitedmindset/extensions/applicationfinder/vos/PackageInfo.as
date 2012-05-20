package com.unitedmindset.extensions.applicationfinder.vos
{
	/**
	 * Reflection class to take an Android
	 * <code>PackageInfo</code> class to
	 * ActionScript.
	 * 
	 * <p>Overall information about the 
	 * contents of a package. This corresponds 
	 * to all of the information collected 
	 * from AndroidManifest.xml.</p>
	 * 
	 * @author jonbcampos
	 * 
	 */	
	public class PackageInfo
	{
		public function PackageInfo()
		{
		}
		
		/**
		 * The name of this package. 
		 */		
		public var packageName:String;
		/**
		 * The version name of this package, 
		 * as specified by the <manifest> 
		 * tag's versionName attribute. 
		 */		
		public var versionName:String;
		/**
		 * The version number of this 
		 * package, as specified by the 
		 * <manifest> tag's versionCode 
		 * attribute. 
		 */		
		public var versionCode:int;
		/**
		 * Information collected from 
		 * the <application> tag, or null 
		 * if there was none. 
		 */		
		public var applicationInfo:ApplicationInfo;
	}
}