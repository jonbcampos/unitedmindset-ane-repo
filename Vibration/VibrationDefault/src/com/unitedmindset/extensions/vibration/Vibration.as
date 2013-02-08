package com.unitedmindset.extensions.vibration
{
	import flash.external.ExtensionContext;
	
	
	/**
	 * Interface to the Android Vibrator class.
	 * 
	 * Make sure to include the following permissions:
	 * <pre>
	 * &lt;uses-permission android:name="android.permission.VIBRATE"/&gt;
	 * </pre>
	 * 
	 * @author jonbcampos
	 * 
	 */	
	public class Vibration
	{
		//---------------------------------------------------------------------
		//
		//  Constructor
		//
		//---------------------------------------------------------------------
		public function Vibration()
		{
			super();
		}
		
		//---------------------------------------------------------------------
		//
		//  Constants
		//
		//---------------------------------------------------------------------
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.Vibration";
		private static const EXTENSION_TYPE:String = null;
		
		private static const REGISTER_FUNC:String = "register";
		private static const DEREGISTER_FUNC:String = "deregister";
		private static const IS_SUPPORTED_FUNC:String = "isSupported";
		private static const VIBRATE_FUNC:String = "vibrate";
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
			
		}
		
		/**
		 * Deregisters and disconnects the ANE from the Native Process.
		 */		
		public function deregister():void
		{
			
		}
		
		/**
		 * Let's you know if ANE is supported.
		 * @return 
		 * 
		 */		
		public function isSupported():Boolean
		{
			return false;
		}
		
		//---------------------------------------------------------------------
		//
		//  Android Vibration Methods
		//
		//---------------------------------------------------------------------
		public function vibrate(duration:int):void
		{
			
		}
	}
}