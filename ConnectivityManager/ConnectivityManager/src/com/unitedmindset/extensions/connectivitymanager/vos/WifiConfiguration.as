package com.unitedmindset.extensions.connectivitymanager.vos
{
	[RemoteClass(alias="com.unitedmindset.extensions.connectivitymanager.vos.WifiConfiguration")]
	/**
	 *
	 * @see http://developer.android.com/reference/android/net/wifi/WifiConfiguration.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class WifiConfiguration
	{
		public function WifiConfiguration()
		{
		}
		
		public var BSSID:String;
		public var SSID:String;
		public var allowedAuthAlgorithms:String;
		public var allowedGroupCiphers:String;
		public var allowedKeyManagement:String;
		public var allowedPairwiseCiphers:String;
		public var allowedProtocols:String;
		public var hiddenSSID:Boolean;
		public var networkId:int;
		public var preSharedKey:String;
		public var priority:int;
		public var status:int;
		public var wepKeys:String;
		public var wepTxKeyIndex:int;
	}
}