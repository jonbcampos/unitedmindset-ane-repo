package com.unitedmindset.extensions.enablegps
{
	import flash.events.EventDispatcher;
	import flash.external.ExtensionContext;
	
	public class EnableGps extends EventDispatcher
	{
		public function EnableGps()
		{
			
		}
		
		//---------------------------------------------------------------------
		//
		//  Private Properties
		//
		//---------------------------------------------------------------------
		private static var _context:ExtensionContext = null;
		private static var _registered:Boolean = false;
		
		private static const EXTENSION_ID:String = "com.unitedmindset.extensions.EnableGps";
		
		private static const REGISTER_FUNC:String = "register";
		private static const DEREGISTER_FUNC:String = "deregister";
		private static const ENABLE_GPS_FUNC:String = "enableGps";
		//---------------------------------------------------------------------
		//
		//  Public Properties
		//
		//---------------------------------------------------------------------
		
		//---------------------------------------------------------------------
		//
		//  Public Methods
		//
		//---------------------------------------------------------------------
		/**
		 * Registers the ANE with the Native Process.
		 */		
		public function register():void
		{
			if(!_context)
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);
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
			}
		}
		
		/**
		 * Let's you know if ANE is supported.
		 * For now, just returns <code>true</code>. 
		 * @return 
		 * 
		 */		
		public static function isSupported():Boolean
		{
			return true;
		}
		
		public function enableGps():void
		{
			if(!_registered)
				register();
			_context.call( ENABLE_GPS_FUNC );
		}
	}
}