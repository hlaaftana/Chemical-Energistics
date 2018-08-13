package com.thexfactor117.ce.enums;

public enum ElementEnum {
	HYDROGEN("Hydrogen", StateEnum.GAS, "H", 1, false),
	LITHIUM("Lithium", StateEnum.SOLID, "Li", 4, false),
	CARBON("Carbon", StateEnum.SOLID, "C", 6, false),
	NITROGEN("Nitrogen", StateEnum.GAS, "N", 7, false),
	OXYGEN("Oxygen", StateEnum.GAS, "O", 8, false),
	SODIUM("Sodium", StateEnum.SOLID, "Na", 11, false),
	ALUMINUM("Aluminum", StateEnum.SOLID, "Al", 13, false),
	SILICON("Silicon", StateEnum.SOLID, "Si", 14, false),
	PHOSPHORUS("Phosphorus", StateEnum.SOLID, "P", 15, false),
	SULFUR("Sulfur", StateEnum.SOLID, "S", 16, false),
	IRON("Iron", StateEnum.SOLID, "Fe", 26, false),
	COPPER("Copper", StateEnum.SOLID, "Cu", 29, false),
	SILVER("Silver", StateEnum.SOLID, "Ag", 47, false),
	TIN("Tin", StateEnum.SOLID, "Sn", 50, false),
	IODINE("Iodine", StateEnum.SOLID, "I", 53, false),
	IRIDIUM("Iridium", StateEnum.SOLID, "Ir", 77, false),
	GOLD("Gold", StateEnum.SOLID, "Au", 79, false),
	MERCURY("Mercury", StateEnum.LIQUID, "Hg", 80, false),
	LEAD("Lead", StateEnum.SOLID, "Pb", 82, false),
	RADON("Radon", StateEnum.GAS, "Rn", 86, true),
	URANIUM("Uranium", StateEnum.SOLID, "U", 92, true),
	//I know these are potential, but I'm keeping these in
	HELIUM("Helium", StateEnum.GAS, "He", 2, false),
	BORON("Boron", StateEnum.SOLID, "B", 5, false),
	FLUORINE("Fluorine", StateEnum.GAS, "F", 9, false),
	NEON("Neon", StateEnum.GAS, "Ne", 10, false),
	MAGNESIUM("Magnesium", StateEnum.SOLID, "Mg", 12, false),
	CHLORINE("Chlorine", StateEnum.GAS, "Cl", 17, false),
	ARGON("Argon", StateEnum.GAS, "Ar", 18, false),
	TITANIUM("Titanium", StateEnum.SOLID, "Ti", 22, false),
	CHROMIUM("Chromium", StateEnum.SOLID, "Cr", 24, false),
	COBALT("Cobalt", StateEnum.SOLID, "Co", 27, false),
	NICKEL("Nickel", StateEnum.SOLID, "Ni", 28, false),
	ZINC("Zinc", StateEnum.SOLID, "Zn", 30, false),
	KRYPTON("Krypton", StateEnum.GAS, "Kr", 36, false),
	XENON("Xenon", StateEnum.GAS, "Xe", 54, false),
	OSMIUM("Osmium", StateEnum.SOLID, "Os", 76, false),
	PLATINUM("Platinum", StateEnum.SOLID, "Pt", 78, false),
	THORIUM("Thorium", StateEnum.SOLID, "Th", 90, true),
	PLUTONIUM("Plutonium", StateEnum.SOLID, "Pu", 94, true),
	EMPTY("Notexistium", StateEnum.PLASMA, "Not", 0, false);

	public String formula, name;
	public StateEnum stateAtRoomTemperature;
	public int atomicNumber;
	public boolean isRadioactive;

	//If you want, I'll add melting, freezing and maybe boiling points.
	ElementEnum(String name, StateEnum stateAtRoomTemperature, String formula, int atomicNumber, boolean isRadioactive) {
		this.name = name;
		this.stateAtRoomTemperature = stateAtRoomTemperature;
		this.formula = formula;
		this.atomicNumber = atomicNumber;
		this.isRadioactive = isRadioactive;
	}
}