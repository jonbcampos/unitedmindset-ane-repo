package com.unitedmindset.extensions.wakelock
{
	import flash.external.ExtensionContext;
	
	/**
	 * Wake Lock Ane to control the screen.
	 * 
	 * Make sure to include the following permissions:
	 * <pre>
	 * &lt;uses-permission android:name="android.permission.WAKE_LOCK"/&gt;
	 * </pre>
	 *  
	 * @author jonbcampos
	 * 
	 */	
	public class WakeLock
	{
		//---------------------------------------------------------------------
		//
		//  Constructor
		//
		//---------------------------------------------------------------------
		public function WakeLock()
		{
			super();
		}
		
		//---------------------------------------------------------------------
		//
		//  Constants
		//
		//---------------------------------------------------------------------
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.WakeLock";
		private static const EXTENSION_TYPE:String = null;
		
		private static const REGISTER_FUNC:String = "register";
		private static const DEREGISTER_FUNC:String = "deregister";
		private static const IS_SUPPORTED_FUNC:String = "isSupported";
		
		private static const ACQUIRE_FUNC:String = "acquire";
		private static const GET_SCREEN_TIMEOUT_FUNC:String = "getScreenTimeout";
		private static const SET_SCREEN_TIMEOUT_FUNC:String = "setScreenTimeout";
		private static const RELEASE_FUNC:String = "release";
		private static const IS_HELD_FUNC:String = "isHeld";
		private static const GO_TO_SLEEP_FUNC:String = "goToSleep";
		private static const IS_SCREEN_ON_FUNC:String = "isScreenOn";
		private static const KEEP_SCREEN_ON_FUNC:String = "keepScreenOn";
		
		/**
		 * Wake lock level: Ensures that the CPU is running; the 
		 * screen and keyboard backlight will be allowed to go off. 
		 * 
		 * <p>If the user presses the power button, then the screen 
		 * will be turned off but the CPU will be kept on until 
		 * all partial wake locks have been released.</p>
		 */		
		public static const PARTIAL_WAKE_LOCK:int = 1;
		/**
		 * Wake lock level: Ensures that the screen is on (but may 
		 * be dimmed); the keyboard backlight will be allowed to go off.
		 * 
		 * <p>If the user presses the power button, then the 
		 * SCREEN_DIM_WAKE_LOCK will be implicitly released by 
		 * the system, causing both the screen and the CPU to be 
		 * turned off. Contrast with PARTIAL_WAKE_LOCK.</p>
		 */		
		public static const SCREEN_DIM_WAKE_LOCK:int = 6;
		/**
		 * Wake lock level: Ensures that the screen is on at 
		 * full brightness; the keyboard backlight will be allowed to go off.
		 * 
		 * <p>If the user presses the power button, then the 
		 * SCREEN_BRIGHT_WAKE_LOCK will be implicitly released by the system, 
		 * causing both the screen and the CPU to be turned off. 
		 * Contrast with PARTIAL_WAKE_LOCK. </p>
		 */		
		public static const SCREEN_BRIGHT_WAKE_LOCK:int = 10;
		/**
		 * Wake lock level: Ensures that the screen and 
		 * keyboard backlight are on at full brightness.
		 * 
		 * <p>If the user presses the power button, then 
		 * the FULL_WAKE_LOCK will be implicitly released 
		 * by the system, causing both the screen and the 
		 * CPU to be turned off. Contrast with PARTIAL_WAKE_LOCK.</p>
		 */		
		public static const FULL_WAKE_LOCK:int = 26;
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
		public function register(flag:int, tag:String, referenceCounted:Boolean):void
		{
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, EXTENSION_TYPE);
			if(!_registered)
			{
				_context.call(REGISTER_FUNC, flag, tag, referenceCounted);
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
		public static function isSupported():Boolean
		{
			return true;
		}
		
		//---------------------------------------------------------------------
		//
		//  Android Vibration Methods
		//
		//---------------------------------------------------------------------
		/**
		 * Acquires the wake lock. 
		 * @param timeout
		 * 
		 */		
		public function acquire(timeout:Number=-1):void
		{
			if(timeout>0)
				_context.call(ACQUIRE_FUNC, timeout);
			else
				_context.call(ACQUIRE_FUNC);
		}
		
		/**
		 * Returns the current screen timeout value. 
		 * @return 
		 * 
		 */		
		public function getScreenTimeout():int
		{
			return _context.call(GET_SCREEN_TIMEOUT_FUNC) as int;
		}
		
		/**
		 * Sets the screen timeout value. 
		 * @param value
		 * 
		 */		
		public function setScreenTimeout(value:int):void
		{
			_context.call(SET_SCREEN_TIMEOUT_FUNC, value);
		}
		
		/**
		 * Releases the wake lock. 
		 */		
		public function release():void
		{
			_context.call(RELEASE_FUNC);
		}
		
		/**
		 * Returns true if the wake lock has been acquired but not yet released. 
		 * @return 
		 * 
		 */		
		public function isHeld():Boolean
		{
			return _context.call(IS_HELD_FUNC) as Boolean;
		}
		
		/**
		 * Forces the device to go to sleep.
		 * 
		 * <pre>
		 * &lt;uses-permission android:name="android.permission.DEVICE_POWER"/&gt;
		 * </pre> 
		 * 
		 */		
		public function goToSleep():void
		{
			_context.call(GO_TO_SLEEP_FUNC);
		}
		
		/**
		 * Returns whether the screen is currently on. 
		 * @return 
		 * 
		 */		
		public function isScreenOn():Boolean
		{
			return _context.call(IS_SCREEN_ON_FUNC) as Boolean;
		}
		
		/**
		 * Window flag: as long as this window is visible 
		 * to the user, keep the device's screen turned 
		 * on and bright. 
		 * 
		 */		
		public function keepScreenOn():void
		{
			_context.call(KEEP_SCREEN_ON_FUNC);
		}
	}
}