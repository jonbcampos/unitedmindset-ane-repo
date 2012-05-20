package com.unitedmindset.extensions.flightmode
{
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
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
			if(event.code == FlightModeEvent.CONNECTIVITY_CHANGE)
			{
				var inAirplaneMode:Boolean = true;
				dispatchEvent(new FlightModeEvent(FlightModeEvent.CONNECTIVITY_CHANGE, inAirplaneMode));
			}
		}
	}
}