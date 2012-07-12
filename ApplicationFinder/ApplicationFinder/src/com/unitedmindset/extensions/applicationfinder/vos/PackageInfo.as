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