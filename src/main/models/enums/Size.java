package main.models.enums;

public enum Size {
    TINY(2.5),
    SMALL(5),
    MEDIUM(5),
    LARGE(10),
    HUGE(15),
    GARGANTUAN(20);

    private double sizeInFeet;

    private Size(double size) {
        this.sizeInFeet = size;
    }

    public double getSizeInFeet() {
        return sizeInFeet;
    }
}
