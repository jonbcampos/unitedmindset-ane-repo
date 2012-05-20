package com.unitedmindset.extensions.flightmode
{
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	[Event(name="connectivityChange", type="com.unitedmindset.extensions.flightmode.FlightModeEvent")]
	
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
		
		public static function isSupported():Boolean
		{
			return true;
		}
		
		public function isAirplaneModeOn():Boolean
		{
			if(!_registered)
				register();
			return _context.call(IS_AIRPLANE_MODE_ON_FUNC) as Boolean;
		}
		
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