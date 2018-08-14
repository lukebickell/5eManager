package models.character.enums;

public enum Race {
    // TODO complete
    HUMAN("Human"),
    ELF("Elf"),
    HALF_ELF("Half-elf"),
    HALF_ORC("Half-orc"),
    DWARF("Dwarf"),
    DRAGONBORN("Dragonborn"),
    TIEFLING("Tiefling"),
    HALFLING("Halfling");

    private String value;

    private Race(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
