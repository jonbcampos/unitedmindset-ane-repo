package com.unitedmindset.extensions.flightmode
{
	import flash.events.Event;
	
	public class FlightModeEvent extends Event
	{
		public static const CONNECTIVITY_CHANGE:String = "connectivityChange";
		
		private var _inAirplaneMode:Boolean;
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