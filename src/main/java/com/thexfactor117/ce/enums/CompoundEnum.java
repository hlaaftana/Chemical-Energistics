package com.thexfactor117.ce.enums;

/**
 * @author Hlaaftana
 * I plan to add a "compound of compound" enum, in which compounds can be components of compounds! You'll see.
 */
public enum CompoundEnum{
	WATER("Water", "Liquid", new ElementEnum[]{ElementEnum.HYDROGEN, ElementEnum.OXYGEN}, new int[]{2, 1});
	
    public String stateAtRoomTemperature;
    public ElementEnum[] elements;
    public int[] elementAmounts;
    public String name = "";
    public String formula = "";
    public String[] components = {"", "", "", "", ""};
    //If you want, I'll add melting, freezing and maybe boiling points.
    CompoundEnum(String name, String stateAtRoomTemperature, ElementEnum[] elements, int[] elementAmounts) {
        if (elements.length == elementAmounts.length){
    		this.name = name;
    		this.stateAtRoomTemperature = stateAtRoomTemperature;
    		this.elements = elements;
    		this.elementAmounts = elementAmounts;
    		for (int i = 0; i < elements.length; i++){
    			components[i] = elements[i].name;
    			if (elementAmounts[i] > 1){
    				this.formula = String.format("%s%s%d", formula, elements[i].formula, elementAmounts[i]);
    			}else{
    				this.formula = formula + elements[i].formula;
    			}
    		}
        }else{
        	try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
}