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
package com.unitedmindset.extensions.opendocument
{
	import flash.events.EventDispatcher;
	import flash.net.URLRequest;
	import flash.net.navigateToURL;
	
	public class OpenDocument extends EventDispatcher
	{
		public function OpenDocument()
		{
		}
		
		//---------------------------------------------------------------------
		//
		//  Private Properties
		//
		//---------------------------------------------------------------------
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.OpenDocument";
		
		private static const REGISTER_FUNC:String = "register";
		private static const DEREGISTER_FUNC:String = "deregister";
		private static const OPEN_DOCUMENT_FUNC:String = "openDocument";
		//---------------------------------------------------------------------
		//
		//  Public Properties
		//
		//---------------------------------------------------------------------
		
		//---------------------------------------------------------------------
		//
		//  Public Methods
		//
		//---------------------------------------------------------------------
		/**
		 * Registers the ANE with the Native Process.
		 */		
		public function register():void
		{
			
		}
		
		/**
		 * Deregisters and disconnects the ANE from the Native Process.
		 */		
		public function deregister():void
		{
			
		}
		
		/**
		 * Let's you know if ANE is supported.
		 * For now, just returns <code>true</code>. 
		 * @return 
		 * 
		 */		
		public static function isSupported():Boolean
		{
			return false;
		}
		
		public function openDocument(path:String, extension:String):void
		{
			navigateToURL( new URLRequest(path) );
		}
	}
}