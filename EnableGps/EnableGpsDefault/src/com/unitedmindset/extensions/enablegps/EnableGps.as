package com.unitedmindset.extensions.enablegps
{
	import flash.events.EventDispatcher;
	
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
		}
		
		/**
		 * Deregisters and disconnects the ANE from the Native Process.
		 */		
		public function deregister():void
		{
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
		
		public function enableGps():void
		{
			
		}
	}
}