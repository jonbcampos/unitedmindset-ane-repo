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