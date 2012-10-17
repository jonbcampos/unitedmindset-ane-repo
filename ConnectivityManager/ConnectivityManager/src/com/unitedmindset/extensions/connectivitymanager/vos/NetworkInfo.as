package com.unitedmindset.extensions.connectivitymanager.vos
{
	[RemoteClass(alias="com.unitedmindset.extensions.connectivitymanager.vos.NetworkInfo")]
	/**
	 *
	 * @see http://developer.android.com/reference/android/net/NetworkInfo.html
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class NetworkInfo
	{
		public function NetworkInfo()
		{
		}
		
		public var detailedState:String;
		public var extraInfo:String;
		public var reason:String;
		public var state:String;
		public var subType:int;
		public var subTypeName:String;
		public var type:int;
		public var typeName:String;
		public var isAvailable:Boolean;
		public var isConnected:Boolean;
		public var isConnectedOrConnecting:Boolean;
		public var isFailover:Boolean;
		public var isRoaming:Boolean;
	}
}