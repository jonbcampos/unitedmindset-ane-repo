package com.unitedmindset.extensions.connectivitymanager.vos
{
	[RemoteClass(alias="com.unitedmindset.extensions.connectivitymanager.vos.WifiInfo")]
	/**
	 *
	 * @see http://developer.android.com/reference/android/net/wifi/WifiInfo.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class WifiInfo
	{
		public function WifiInfo()
		{
		}
		
		public var BSSID:String;
		public var hiddenSSID:Boolean;
		public var ipAddress:int;
		public var linkSpeed:int;
		public var macAddress:String;
		public var networkId:int;
		public var rssi:int;
		public var SSID:String;
		
	}
}