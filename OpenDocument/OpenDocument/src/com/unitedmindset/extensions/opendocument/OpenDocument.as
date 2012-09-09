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
	import flash.external.ExtensionContext;
	
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
		private static var _context:ExtensionContext = null;
		private static var _registered:Boolean = false;
		private static var _checkForSupported:Boolean = true;
		
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
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);
			if(!_registered)
			{
				_context.call(REGISTER_FUNC);
				_registered = true;
			}
		}
		
		/**
		 * Deregisters and disconnects the ANE from the Native Process.
		 */		
		public function deregister():void
		{
			if(_registered)
			{
				_context.call(DEREGISTER_FUNC);
				_context.dispose();
				_registered = false;
			}
		}
		
		/**
		 * Let's you know if ANE is supported.
		 * For now, just returns <code>true</code>. 
		 * @return 
		 * 
		 */		
		public static function isSupported():Boolean
		{
			return true;
		}
		
		public function openDocument(path:String, extension:String):void
		{
			if(!_registered)
				register();
			_context.call( OPEN_DOCUMENT_FUNC, path, extension);
		}
	}
}