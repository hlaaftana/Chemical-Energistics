package com.thexfactor117.ce.enums;

public enum CompoundEnum {
	WATER("Water", StateEnum.LIQUID, new ElementEnum[]{ElementEnum.HYDROGEN, ElementEnum.OXYGEN}, new int[]{2, 1});

	public StateEnum stateAtRoomTemperature;
	public ElementEnum[] elements;
	public int[] elementAmounts;
	public String name, formula = "";
	public String[] components;

	CompoundEnum(String name, StateEnum stateAtRoomTemperature, ElementEnum[] elements, int[] elementAmounts) {
		this.name = name;
		this.stateAtRoomTemperature = stateAtRoomTemperature;
		this.elements = elements;
		this.elementAmounts = elementAmounts;
		this.components = new String[elements.length];
		for (int i = 0; i < elements.length; i++) {
			components[i] = elements[i].name;
			if (elementAmounts[i] > 1) {
				this.formula = String.format("%s%s%d", formula, elements[i].formula, elementAmounts[i]);
			} else {
				this.formula += elements[i].formula;
			}
		}
	}
}