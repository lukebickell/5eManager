package models.character.enums;

public enum Skill {
    ACROBATICS(Attribute.DEXTERITY),
    ANIMAL_HANDLING(Attribute.WISDOM),
    ARCANA(Attribute.INTELLIGENCE),
    ATHLETICS(Attribute.STRENGTH),
    DECEPTION(Attribute.CHARISMA),
    HISTORY(Attribute.INTELLIGENCE),
    INSIGHT(Attribute.WISDOM),
    INTIMIDATION(Attribute.CHARISMA),
    INVESTIGATION(Attribute.INTELLIGENCE),
    MEDICINE(Attribute.WISDOM),
    NATURE(Attribute.INTELLIGENCE),
    PERCEPTION(Attribute.WISDOM),
    PERFORMANCE(Attribute.CHARISMA),
    PERSUASION(Attribute.CHARISMA),
    RELIGION(Attribute.INTELLIGENCE),
    SLEIGHT_OF_HAND(Attribute.DEXTERITY),
    STEALTH(Attribute.DEXTERITY),
    SURVIVAL(Attribute.WISDOM);

    private Attribute attribute;

    Skill(Attribute attribute) {
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }
}
