package com.unitedmindset.extensions.applicationfinder.vos
{
	/**
	 * Reflection class to take an Android
	 * <code>ApplicationInfo</code> class to
	 * ActionScript.
	 * 
	 * <p>Information you can retrieve about a 
	 * particular application. This corresponds 
	 * to information collected from the 
	 * AndroidManifest.xml's <application> tag.</p>
	 * 
	 * @author jonbcampos
	 * 
	 */	
	public class ApplicationInfo
	{
		public function ApplicationInfo()
		{
		}
		
		/**
		 * Optional name of a permission required 
		 * to be able to access this application's 
		 * components. 
		 */		
		public var permission:String;
		/**
		 * Full path to a directory assigned to 
		 * the package for its persistent data. 
		 */		
		public var dataDir:String;
		/**
		 * Name of the package that this item is in. 
		 */		
		public var packageName:String;
		/**
		 * The name of the process this 
		 * application should run in. 
		 */		
		public var processName:String;
		/**
		 * Full path to the location of 
		 * the publicly available parts 
		 * of this package 
		 */		
		public var publicSourceDir:String;
		/**
		 * Full path to the location of 
		 * this package. 
		 */		
		public var sourceDir:String;
		/**
		 * The minimum SDK version this 
		 * application targets. 
		 */		
		public var targetSdkVersion:int;
		/**
		 * Default task affinity of all 
		 * activities in this application. 
		 */		
		public var taskAffinity:String;
		/**
		 * The kernel user-ID that has been assigned 
		 * to this application; currently this is not 
		 * a unique ID (multiple applications can 
		 * have the same uid). 
		 */		
		public var uid:int;
		/**
		 * A drawable resource identifier (in 
		 * the package's resources) of this 
		 * component's icon. 
		 */		
		public var icon:int;
	}
}