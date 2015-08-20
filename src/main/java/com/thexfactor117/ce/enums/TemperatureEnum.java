package com.thexfactor117.ce.enums;

import com.thexfactor117.ce.handlers.ConfigHandler;

/**
 * @author Hlaaftana
 *
 */
public enum TemperatureEnum {
	ROOMTEMP(295);
	public int value;
	TemperatureEnum(int value){
		switch (ConfigHandler.temperatureMeasure){
			case 0: 	
				this.value = value;
				break;
			case 1: 	
				this.value = value - 273;
				break;
			case 2: 	
				this.value = value * 9/5 + 32;
				break;
			default: 
				this.value = value * 5/9;
				break;
		}
	}
}
