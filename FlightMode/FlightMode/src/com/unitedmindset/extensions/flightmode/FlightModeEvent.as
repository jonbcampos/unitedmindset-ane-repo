/*

Copyright (C) 2012 Jonathan Campos

Permission is hereby granted, free of charge, to any person 
obtaining a copy of this software and associated documentation 
files (the "Software"), to deal in the Software without 
restriction, including without limitation the rights to use, 
copy, modify, merge, publish, distribute, sublicense, and/or 
sell copies of the Software, and to permit persons to whom 
the Software is furnished to do so, subject to the following 
conditions:

The above copyright notice and this permission notice shall 
be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
OTHER DEALINGS IN THE SOFTWARE.

*/
package com.unitedmindset.extensions.flightmode
{
	import flash.events.Event;
	/**
	 * Event to give information from the
	 * device about the status of the 
	 * Device's connectivity.
	 * @author jonbcampos
	 * 
	 */	
	public class FlightModeEvent extends Event
	{
		/**
		 * Fired when the FlightMode changes on the device
		 * due to any other application or internal change. 
		 */		
		public static const CONNECTIVITY_CHANGE:String = "connectivityChange";
		
		private var _inAirplaneMode:Boolean;
		/**
		 * <code>true</code> denotes the device is in Airplane Mode. 
		 * @return 
		 * 
		 */		
		public function get inAirplaneMode():Boolean { return _inAirplaneMode; }
		
		public function FlightModeEvent(type:String, inAirplaneMode:Boolean, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			_inAirplaneMode = inAirplaneMode
		}
		
		override public function clone():Event
		{
			return new FlightModeEvent(type, inAirplaneMode, bubbles, cancelable);
		}
	}
}