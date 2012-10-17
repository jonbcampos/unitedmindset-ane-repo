package com.unitedmindset.extensions.connectivitymanager.vos
{
	[RemoteClass(alias="com.unitedmindset.extensions.connectivitymanager.vos.DhcpInfo")]
	/**
	 *
	 * @see http://developer.android.com/reference/android/net/DhcpInfo.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class DhcpInfo
	{
		public function DhcpInfo()
		{
		}
		
		public var dns1:int;
		public var dns2:int;
		public var gateway:int;
		public var ipAddress:int;
		public var leaseDuration:int;
		public var netmask:int;
		public var serverAddress:int;
	}
}