package com.thexfactor117.ce.enums;

/**
 * @author Hlaaftana
 *
 */
public enum ElementEnum {
    HYDROGEN ("Hydrogen", "Gas", "H2", 1, false),
    LITHIUM ("Lithium", "Solid", "Li", 4, false),
    CARBON ("Carbon", "Solid", "C", 6, false),
    NITROGEN ("Nitrogen", "Gas", "N2", 7, false),
    OXYGEN ("Oxygen", "Gas", "O2", 8, false),
    SODIUM ("Sodium", "Solid", "Na", 11, false),
    ALUMINUM ("Aluminum", "Solid", "Al", 13, false),
    SILICON ("Silicon", "Solid", "Si", 14, false),
    PHOSPHORUS ("Phosphorus", "Solid", "P", 15, false),
    SULFUR ("Sulfur", "Solid", "S", 16, false),
    IRON ("Iron", "Solid", "Fe", 26, false),
    COPPER ("Copper", "Solid", "Cu", 29, false),
    SILVER ("Silver", "Solid", "Ag", 47, false),
    TIN ("Tin", "Solid", "Sn", 50, false),
    IODINE ("Iodine", "Solid", "I2", 53, false),
    IRIDIUM ("Iridium", "Solid", "Ir", 77, false),
    GOLD ("Gold", "Solid", "Au", 79, false),
    MERCURY ("Mercury", "Liquid", "Hg", 80, false),
    LEAD ("Lead", "Solid", "Pb", 82, false),
    RADON ("Radon", "Gas", "Rn", 86, true),
    URANIUM ("Uranium", "Solid", "U", 92, true),
    //I know these are potential, but I'm keeping these in
    HELIUM ("Helium", "Gas", "He", 2, false),
    BORON ("Boron", "Solid", "B", 5, false),
    FLUORINE ("Fluorine", "Gas", "F2", 9, false),
    NEON ("Neon", "Gas", "Ne", 10, false),
    MAGNESIUM ("Magnesium", "Solid", "Mg", 12, false),
    CHLORINE ("Chlorine", "Gas", "Cl", 17, false),
    ARGON ("Argon", "Gas", "Ar", 18, false),
    TITANIUM ("Titanium", "Solid", "Ti", 22, false),
    CHROMIUM ("Chromium", "Solid", "Cr", 24, false),
    COBALT ("Cobalt", "Solid", "Co", 27, false),
    NICKEL ("Nickel", "Solid", "Ni", 28, false),
    ZINC ("Zinc", "Solid", "Zn", 30, false),
    KRYPTON ("Krypton", "Gas", "Kr", 36, false),
    XENON ("Xenon", "Gas", "Xe", 54, false),
    OSMIUM ("Osmium", "Solid", "Os", 76, false),
    PLATINUM ("Platinum", "Solid", "Pt", 78, false),
    THORIUM ("Thorium", "Solid", "Th", 90, true),
    PLUTONIUM ("Plutonium", "Solid", "Pu", 94, true),
    EMPTY ("Notexistium", "Plasma", "Not", Integer.MAX_VALUE, false);
    
    public String stateAtRoomTemperature;
    public String formula;
    public String name;
    public int atomicNumber;
    public boolean isRadioactive;
    //If you want, I'll add melting, freezing and maybe boiling points. I'd prefer Kelvin.
    ElementEnum(String name, String stateAtRoomTemperature, String formula, int atomicNumber, boolean isRadioactive) {
        this.name = name;
        this.stateAtRoomTemperature = stateAtRoomTemperature;
        this.formula = formula;
        this.atomicNumber = atomicNumber;
        this.isRadioactive = isRadioactive;
    }
}