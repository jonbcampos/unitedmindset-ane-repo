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
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, EXTENSION_TYPE);
			if(!_registered)
			{
				_context.call(REGISTER_FUNC);
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
				_context.dispose();
				_registered = false;
				_context = null;
			}
		}
		
		/**
		 * Let's you know if ANE is supported.
		 * @return 
		 * 
		 */		
		public function isSupported():Boolean
		{
			return _context.call(IS_SUPPORTED_FUNC) as Boolean;
		}
		
		//---------------------------------------------------------------------
		//
		//  Android Vibration Methods
		//
		//---------------------------------------------------------------------
		public function vibrate(duration:int):void
		{
			register();
			_context.call(VIBRATE_FUNC, duration);
		}
	}
}