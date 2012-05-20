package com.unitedmindset.extensions.flightmode
{
	import flash.events.Event;
	
	/**
	 * Simply a copy from the main ANE
	 * for Default-iness. 
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
		
		public function FlightModeEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		override public function clone():Event
		{
			return new FlightModeEvent(type, bubbles, cancelable);
		}
	}
}