package com.unitedmindset.extensions.connectivitymanager.events
{
	import flash.events.Event;
	
	public class ConnectivityEvent extends Event
	{
		public static const CONNECTIVITY_CHANGE:String = "connectivityChange";
		public static const WIFI_SCAN_CHANGE:String = "wifiScanChange";
		
		private var _result:Object;
		public function get result():Object { return _result; }
		
		public function ConnectivityEvent(type:String, result:Object, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			_result = result;
		}
		
		override public function clone():Event
		{
			return new ConnectivityEvent(type, result, bubbles, cancelable);
		}
	}
}