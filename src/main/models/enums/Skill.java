package main.models.enums;

public enum Skill {
    // Strength
    ATHLETICS(Attribute.STRENGTH),
    // Dexterity
    ACROBATICS(Attribute.DEXTERITY),
    SLEIGHT_OF_HAND(Attribute.DEXTERITY),
    STEALTH(Attribute.DEXTERITY),
    // Constitution
    // Intelligence
    ARCANA(Attribute.INTELLIGENCE),
    HISTORY(Attribute.INTELLIGENCE),
    NATURE(Attribute.INTELLIGENCE),
    INVESTIGATION(Attribute.INTELLIGENCE),
    RELIGION(Attribute.INTELLIGENCE),
    // Wisdom
    ANIMAL_HANDLING(Attribute.WISDOM),
    INSIGHT(Attribute.WISDOM),
    MEDICINE(Attribute.WISDOM),
    PERCEPTION(Attribute.WISDOM),
    SURVIVAL(Attribute.WISDOM),
    // Charisma
    DECEPTION(Attribute.CHARISMA),
    INTIMIDATION(Attribute.CHARISMA),
    PERFORMANCE(Attribute.CHARISMA),
    PERSUASION(Attribute.CHARISMA);

    private Attribute attribute;

    Skill(Attribute attribute) {
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }
}
