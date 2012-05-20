package com.unitedmindset.extensions.flightmode
{
	import flash.events.Event;
	
	public class FlightModeEvent extends Event
	{
		public static const CONNECTIVITY_CHANGE:String = "connectivityChange";
		
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