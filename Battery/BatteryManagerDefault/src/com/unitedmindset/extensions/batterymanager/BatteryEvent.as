package com.unitedmindset.extensions.batterymanager
{
	import flash.events.Event;
	
	public class BatteryEvent extends Event
	{
		public static const BATTERY_CHANGED:String = "batteryChanged";
		
		private var _isPresent:Boolean;
		public function get isPresent():Boolean { return _isPresent; }
		
		private var _technology:String;
		public function get technology():String { return _technology; }
		
		private var _plugged:int;
		public function get plugged():int { return _plugged; }
		
		private var _scale:int;
		public function get scale():int { return _scale; }
		
		private var _health:int;
		public function get health():int { return _health; }
		
		private var _status:int;
		public function get status():int { return _status; }
		
		private var _rawLevel:int;
		public function get rawLevel():int { return _rawLevel; }
		
		private var _temperature:int;
		public function get temperature():int { return _temperature; }
		
		private var _voltage:int;
		public function get voltage():int { return _voltage; }
		
		public function BatteryEvent(type:String, isPresent:Boolean, technology:String, 
									 plugged:int, scale:int, health:int, status:int, 
									 rawLevel:int, temperature:int, voltage:int, 
									 bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			_isPresent = isPresent;
			_technology = technology;
			_plugged = plugged;
			_scale = scale;
			_health = health;
			_status = status;
			_rawLevel = rawLevel;
			_temperature = temperature;
			_voltage = voltage;
		}
		
		override public function clone():Event
		{
			return new BatteryEvent(type, isPresent, technology, plugged, scale, health, status, rawLevel, temperature, voltage, bubbles, cancelable);
		}
	}
}