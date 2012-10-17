package com.unitedmindset.extensions.connectivitymanager
{
	import com.unitedmindset.extensions.connectivitymanager.events.ConnectivityEvent;
	import com.unitedmindset.extensions.connectivitymanager.vos.DhcpInfo;
	import com.unitedmindset.extensions.connectivitymanager.vos.WifiInfo;
	
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	[Event(name="wifiScanChange", type="com.unitedmindset.extensions.connectivitymanager.events.ConnectivityEvent")]
	
	/**
	 * 
	 * @see http://developer.android.com/reference/android/net/wifi/WifiManager.html
	 * @see http://developer.android.com/reference/android/net/wifi/WifiInfo.html
	 * @see http://developer.android.com/reference/android/net/wifi/WifiConfiguration.html
	 * 
	 * @see http://stackoverflow.com/questions/9434235/android-i-want-to-set-listener-to-listen-on-wireless-state-can-anyone-help-me-w
	 * 
	 * @author jonbcampos
	 * 
	 */	
	public class WifiManager extends EventDispatcher
	{
		//---------------------------------------------------------------------
		//
		//  Constructor
		//
		//---------------------------------------------------------------------
		public function WifiManager()
		{
			super();
		}
		
		//---------------------------------------------------------------------
		//
		//  Constants
		//
		//---------------------------------------------------------------------
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.connectivitymanager.ConnectivityManager";
		private static const EXTENSION_TYPE:String = "WifiManager";
		
		private static const REGISTER_FUNC:String = "registerWifiManager";
		private static const DEREGISTER_FUNC:String = "deregisterWifiManager";
		
		public static const WIFI_STATE_DISABLED:int = 1;
		public static const WIFI_STATE_DISABLING:int = 0;
		public static const WIFI_STATE_ENABLED:int = 3;
		public static const WIFI_STATE_ENABLING:int = 2;
		public static const WIFI_STATE_UNKNOWN:int = 4;
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
			/*
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, EXTENSION_TYPE);
			if(!_registered)
			{
				_context.call(REGISTER_FUNC);
				_context.addEventListener(StatusEvent.STATUS, _onStatus_StatusChangeHandler);
				_registered = true;
			}
			*/
		}
		
		/**
		 * Deregisters and disconnects the ANE from the Native Process.
		 */		
		public function deregister():void
		{
			/*
			if(_registered)
			{
				_context.call(DEREGISTER_FUNC);
				_context.removeEventListener(StatusEvent.STATUS, _onStatus_StatusChangeHandler);
				_context.dispose();
				_registered = false;
			}
			*/
		}
		
		/**
		 * Let's you know if ANE is supported.
		 * For now, just returns <code>true</code>. 
		 * @return 
		 * 
		 */		
		public static function isSupported():Boolean
		{
			return false;
		}
		
		//---------------------------------------------------------------------
		//
		//  Android WifiManager Methods
		//
		//---------------------------------------------------------------------
		/*
		public function addNetwork(config:WifiConfiguration):int
		{
			return -1;
		}
		*/
		public function calculateSignalLevel(rssi:int, numLevels:int):int
		{
			//return _context.call("calculateSignalLevel", rssi, numLevels) as int;
			return -1;
		}
		
		public function compareSignalLevel(rssiA:int, rssiB:int):int
		{
			//return _context.call("compareSignalLevel", rssiA, rssiB) as int;
			return -1;
		}
		/*
		public function createMulticastLock(tag:String):Object
		{
			return null;
		}
		
		public function createWifiLock(lockType:int, tag:String):Object
		{
			return null;
		}
		*/
		
		public function disableNetwork(netId:int):Boolean
		{
			//return _context.call("disableNetwork", netId) as Boolean;
			return false;
		}
		
		public function disconnect():Boolean
		{
			//return _context.call("disconnect") as Boolean;
			return false;
		}
		
		public function enableNetwork(netId:int, disableOthers:Boolean):Boolean
		{
			//return _context.call("enableNetwork", netId, disableOthers) as Boolean;
			return false;
		}
		
		public function getConfiguredNetworks():Array
		{
			//return _context.call("getConfiguredNetworks") as Array;
			return null;
		}
		
		public function getConnectionInfo():WifiInfo
		{
			//return _context.call("getConnectionInfo") as WifiInfo;
			return null;
		}
		
		public function getDhcpInfo():DhcpInfo
		{
			//return _context.call("getDhcpInfo") as DhcpInfo;
			return null;
		}
		
		public function getScanResults():Array /* of ScanResult Vos */
		{
			//return _context.call("getScanResults") as Array;
			return null;
		}
		
		public function getWifiState():int
		{
			//return _context.call("getWifiState") as int;
			return WIFI_STATE_UNKNOWN;
		}
		
		public function isWifiEnabled():Boolean
		{
			//return _context.call("isWifiEnabled") as Boolean;
			return false;
		}
		
		public function pingSupplicant():Boolean
		{
			//return _context.call("pingSupplicant") as Boolean;
			return false;
		}
		
		public function reassociate():Boolean
		{
			//return _context.call("reassociate") as Boolean;
			return false;
		}
		
		public function reconnect():Boolean
		{
			//return _context.call("reconnect") as Boolean;
			return false;
		}
		
		public function removeNetwork(netId:int):Boolean
		{
			//return _context.call("removeNetwork", netId) as Boolean;
			return false;
		}
		
		public function saveConfiguration():Boolean
		{
			//return _context.call("saveConfiguration") as Boolean;
			return false;
		}
		
		public function setWifiEnabled(enabled:Boolean):Boolean
		{
			//return _context.call("setWifiEnabled", enabled) as Boolean;
			return false;
		}
		
		public function startScan():Boolean
		{
			//return _context.call("startScan") as Boolean;
			return false;
		}
		/*
		public function updateNetwork(config:WifiConfiguration):int
		{
			return -1;
		}
		*/
		public function launchWifiSettings():void
		{
			//_context.call("launchWifiSettings");
		}
		//---------------------------------------------------------------------
		//
		//  Handler Methods
		//
		//---------------------------------------------------------------------
		private function _onStatus_StatusChangeHandler(event:StatusEvent):void
		{
			switch(event.code)
			{
				case ConnectivityEvent.WIFI_SCAN_CHANGE:
					if(hasEventListener(ConnectivityEvent.WIFI_SCAN_CHANGE))
					{
						var scanResults:Array = getScanResults();
						dispatchEvent(new ConnectivityEvent(ConnectivityEvent.WIFI_SCAN_CHANGE, scanResults));
					}
					break;
				default:
					//do nothing
					break;
			}
		}
	}
}