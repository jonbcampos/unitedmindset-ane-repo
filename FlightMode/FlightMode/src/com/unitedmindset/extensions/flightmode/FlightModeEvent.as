package com.unitedmindset.extensions.flightmode
{
	import flash.events.Event;
	/**
	 * Event to give information from the
	 * device about the status of the 
	 * Device's connectivity.
	 * @author jonbcampos
	 * 
	 */	
	public class FlightModeEvent extends Event
	{
		/**
		 * Fired when the FlightMode changes on the device
		 * due to any other application or internal change. 
		 */		
		public static const CONNECTIVITY_CHANGE:String = "connectivityChange";
		
		private var _inAirplaneMode:Boolean;
		/**
		 * <code>true</code> denotes the device is in Airplane Mode. 
		 * @return 
		 * 
		 */		
		public function get inAirplaneMode():Boolean { return _inAirplaneMode; }
		
		public function FlightModeEvent(type:String, inAirplaneMode:Boolean, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			_inAirplaneMode = inAirplaneMode
		}
		
		override public function clone():Event
		{
			return new FlightModeEvent(type, inAirplaneMode, bubbles, cancelable);
		}
	}
}