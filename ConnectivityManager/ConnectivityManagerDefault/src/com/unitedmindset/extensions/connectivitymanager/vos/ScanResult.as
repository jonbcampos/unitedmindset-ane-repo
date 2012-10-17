package com.unitedmindset.extensions.connectivitymanager.vos
{
	[RemoteClass(alias="com.unitedmindset.extensions.connectivitymanager.vos.ScanResult")]
	/**
	 *
	 * @see http://developer.android.com/reference/android/net/wifi/ScanResult.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class ScanResult
	{
		public function ScanResult()
		{
		}
		
		public var BSSID:String;
		public var SSID:String;
		public var capabilities:String;
		public var frequency:int;
		public var level:int;
	}
}