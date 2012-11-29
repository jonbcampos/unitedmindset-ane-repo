package com.unitedmindset.extensions.batterymanager
{
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	[Event(name="batteryChanged", type="com.unitedmindset.extensions.batterymanager.BatteryEvent")]
	
	/**
	 * Interface to the Android ConnectivityManager class.
	 * 
	 * @see http://developer.android.com/reference/android/os/BatteryManager.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class BatteryManager extends EventDispatcher
	{
		//---------------------------------------------------------------------
		//
		//  Constructor
		//
		//---------------------------------------------------------------------
		public function BatteryManager(target:IEventDispatcher=null)
		{
			super(target);
		}
		
		//---------------------------------------------------------------------
		//
		//  Constants
		//
		//---------------------------------------------------------------------
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.BatteryManager";
		private static const EXTENSION_TYPE:String = "BatteryManager";
		
		private static const REGISTER_FUNC:String = "register";
		private static const DEREGISTER_FUNC:String = "deregister";
		
		public static const BATTERY_HEALTH_COLD:int = 7;
		public static const BATTERY_HEALTH_DEAD:int = 4;
		public static const BATTERY_HEALTH_GOOD:int = 2;
		public static const BATTERY_HEALTH_OVERHEAT:int = 3;
		public static const BATTERY_HEALTH_OVER_VOLTAGE:int = 5;
		public static const BATTERY_HEALTH_OVER_UNKNOWN:int = 1;
		public static const BATTERY_HEALTH_OVER_UNSPECIFIED_FAILURE:int = 6;
		
		public static const BATTERY_PLUGGED_AC:int = 1;
		public static const BATTERY_PLUGGED_USB:int = 2;
		public static const BATTERY_PLUGGED_WIRELESS:int = 4;
		
		public static const BATTERY_STATUS_CHARING:int = 2;
		public static const BATTERY_STATUS_DISCHARING:int = 3;
		public static const BATTERY_STATUS_FULL:int = 5;
		public static const BATTERY_STATUS_NOT_CHARGING:int = 4;
		public static const BATTERY_STATUS_UNKNOWN:int = 1;
		//---------------------------------------------------------------------
		//
		//  Properties
		//
		//---------------------------------------------------------------------
		private static var _context:ExtensionContext = null;
		private static var _registered:Boolean = false;
		
		//---------------------------------------------------------------------
		//
		//  Public Methods
		//
		//---------------------------------------------------------------------
		//-----------------------------
		//  ANE template stuff
		//-----------------------------
		/**
		 * Registers the ANE with the Native Process.
		 */		
		public function register():void
		{
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, EXTENSION_TYPE);
			if(!_registered)
			{
				_context.call(REGISTER_FUNC);
				_context.addEventListener(StatusEvent.STATUS, _onStatus_StatusChangeHandler);
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
				_context.removeEventListener(StatusEvent.STATUS, _onStatus_StatusChangeHandler);
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
		
		//---------------------------------------------------------------------
		//
		//  Handler Methods
		//
		//---------------------------------------------------------------------
		private function _onStatus_StatusChangeHandler(event:StatusEvent):void
		{
			if(event.code == BatteryEvent.BATTERY_CHANGED)
			{
				var level:String = event.level;
				if(hasEventListener(BatteryEvent.BATTERY_CHANGED) && level && level!="")
				{
					var levelArray:Array = level.split(",");
					if(levelArray.length==9)
					{
						//split the parts
						var isPresent:Boolean = (levelArray[0] == "true")?true:false;
						var technology:String = levelArray[1] as String;
						var plugged:int = int(levelArray[2]);
						var scale:int = int(levelArray[3]);
						var health:int = int(levelArray[4]);
						var status:int = int(levelArray[5]);
						var rawLevel:int = int(levelArray[6]);
						var temperature:int = int(levelArray[7]);
						var voltage:int = int(levelArray[8]);
						
						dispatchEvent(new BatteryEvent(BatteryEvent.BATTERY_CHANGED, isPresent, technology, 
							plugged, scale, health, status, rawLevel, temperature, voltage));
					}
				}
			}
		}
	}
}