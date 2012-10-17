package com.unitedmindset.extensions.connectivitymanager
{
	import com.unitedmindset.extensions.connectivitymanager.events.ConnectivityEvent;
	import com.unitedmindset.extensions.connectivitymanager.vos.NetworkInfo;
	
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	[Event(name="connectivityChange", type="com.unitedmindset.extensions.connectivitymanager.events.ConnectivityEvent")]
	
	/**
	 *
	 * Make sure to include the following permissions:
	 * <pre>
	 * &lt;uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/&gt;
	 * </pre>
	 * 
	 * @see http://developer.android.com/reference/android/net/ConnectivityManager.html
	 * @see http://developer.android.com/reference/android/net/NetworkInfo.DetailedState.html
	 * @see http://developer.android.com/reference/android/net/NetworkInfo.State.html
	 * @see http://developer.android.com/reference/android/net/NetworkInfo.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class ConnectivityManager extends EventDispatcher
	{
		//---------------------------------------------------------------------
		//
		//  Constructor
		//
		//---------------------------------------------------------------------
		public function ConnectivityManager()
		{
			super();
		}
		
		//---------------------------------------------------------------------
		//
		//  Constants
		//
		//---------------------------------------------------------------------
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.connectivitymanager.ConnectivityManager";
		private static const EXTENSION_TYPE:String = "ConnectivityManager";
		
		private static const REGISTER_FUNC:String = "registerConnectivityManager";
		private static const DEREGISTER_FUNC:String = "deregisterConnectivityManager";
		
		public static const TYPE_MOBILE:int = 0;
		public static const TYPE_MOBILE_DUN:int = 4;
		public static const TYPE_MOBILE_HI_PRIORITY:int = 5;
		public static const TYPE_MOBILE_MMS:int = 2;
		public static const TYPE_MOBILE_SUPL:int = 3;
		public static const TYPE_WIFI:int = 1;
		public static const TYPE_WIMAX:int = 6;
		
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
		//  Android ConnectivityManager Methods
		//
		//---------------------------------------------------------------------
		public function getActiveNetworkInfo():NetworkInfo
		{
			//return _context.call("getActiveNetworkInfo") as NetworkInfo;
			return null;
		}
		
		public function getAllNetworkInfo():Array
		{
			//return _context.call("getAllNetworkInfo") as Array;
			return null;
		}
		
		public function getNetworkInfo(networkType:int):NetworkInfo
		{
			//return _context.call("getNetworkInfo", networkType) as NetworkInfo;
			return null;
		}
		
		public function getNetworkPreference():int
		{
			//return _context.call("getNetworkPreference") as int;
			return -1;
		}
		
		public function isNetworkTypeValid(networkType:int):Boolean
		{
			//return _context.call("isNetworkTypeValid", networkType) as Boolean;
			return false;
		}
		
		public function requestRouteToHost(networkType:int, hostAddress:int):Boolean
		{
			//return _context.call("requestRouteToHost", networkType, hostAddress) as Boolean;
			return false;
		}
		
		public function setNetworkPreference(preference:int):void
		{
			//_context.call("setNetworkPreference", preference);
		}
		
		public function startUsingNetworkFeature(networkType:int, feature:String):int
		{
			//return _context.call("startUsingNetworkFeature", networkType, feature) as int;
			return -1;
		}
		
		public function stopUsingNetworkFeature(networkType:int, feature:String):int
		{
			//return _context.call("stopUsingNetworkFeature", networkType, feature) as int;
			return -1;
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
				case ConnectivityEvent.CONNECTIVITY_CHANGE:
					if(hasEventListener(ConnectivityEvent.CONNECTIVITY_CHANGE))
					{
						var networkInfo:NetworkInfo = getActiveNetworkInfo();
						dispatchEvent(new ConnectivityEvent(ConnectivityEvent.CONNECTIVITY_CHANGE, networkInfo));
					}
					break;
				default:
					//do nothing
					break;
			}
		}
	}
}