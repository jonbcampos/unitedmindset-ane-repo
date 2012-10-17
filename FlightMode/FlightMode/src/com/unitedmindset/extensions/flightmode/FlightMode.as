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
package com.unitedmindset.extensions.flightmode
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * Fired when the FlightMode changes on the device
	 * due to any other application or internal change. 
	 */
	[Event(name="connectivityChange", type="com.unitedmindset.extensions.flightmode.FlightModeEvent")]
	
	/**
	 * FlightMode ANE class to give information
	 * about the Device's connectivity. 
	 * 
	 * Required Permissions To Add:
	 * <pre>
	 * &lt;uses-permission android:name="android.permission.WRITE_SETTINGS"/&gt;
	 * &lt;uses-permission android:name="android.permission.READ_PHONE_STATE"/&gt;
	 * </pre>
	 * 
	 * @author jonbcampos
	 * 
	 */	
	public class FlightMode extends EventDispatcher
	{
		//---------------------------------------------------------------------
		//
		//  Constructor
		//
		//---------------------------------------------------------------------
		public function FlightMode()
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
		
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.FlightMode";
		
		private static const REGISTER_FUNC:String = "register";
		private static const DEREGISTER_FUNC:String = "deregister";
		private static const IS_AIRPLANE_MODE_ON_FUNC:String = "isAirplaneModeOn";
		private static const SET_AIRPLANE_MODE_FUNC:String = "setAirplaneMode";
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
				_context.addEventListener(StatusEvent.STATUS, _onStatus_changeHandler);
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
				_context.removeEventListener(StatusEvent.STATUS, _onStatus_changeHandler);
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
		
		/**
		 * Returns <code>true</code> if Airplane Mode is on 
		 * and <code>false</code> if Airplane Mode is off. 
		 * @return 
		 * 
		 */		
		public function isAirplaneModeOn():Boolean
		{
			if(!_registered)
				register();
			return _context.call(IS_AIRPLANE_MODE_ON_FUNC) as Boolean;
		}
		
		/**
		 * Sets Airplane Mode on or off depending on value input. 
		 * @param value
		 * 
		 */		
		public function setAirplaneMode(value:Boolean):void
		{
			if(!_registered)
				register();
			_context.call(SET_AIRPLANE_MODE_FUNC, value);	
		}
		
		//---------------------------------------------------------------------
		//
		//  Private Methods
		//
		//---------------------------------------------------------------------
		private function _onStatus_changeHandler(event:StatusEvent):void
		{
			var inAirplaneMode:Boolean = (event.level == "true")?true:false;
			
			//fire off a change event
			if(event.code == FlightModeEvent.CONNECTIVITY_CHANGE)
			{
				if(hasEventListener(FlightModeEvent.CONNECTIVITY_CHANGE))
					dispatchEvent(new FlightModeEvent(FlightModeEvent.CONNECTIVITY_CHANGE, inAirplaneMode));
			}
		}
	}
}