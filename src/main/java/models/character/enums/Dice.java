package models.character.enums;

public enum Dice {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    D100(100);

    private int value;

    private Dice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
