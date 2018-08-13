package models.character.meta;

import models.character.enums.Attribute;
import models.character.enums.Size;
import models.character.enums.Skill;
import java.util.EnumMap;

public class StatBlock {

    // Attributes
    private EnumMap<Attribute, Integer> attributes;
    private EnumMap<Skill, SkillMeta> skills;

    private int passivePerception;

    private int proficiency;
    private int armorClass;
    private int maxHitPoints;
    private int speed;
    private Size size;

    public StatBlock() {
        attributes = new EnumMap<>(Attribute.class);
        for (Attribute attribute : Attribute.values()) {
            attributes.put(attribute, 10);
        }

        skills = new EnumMap<>(Skill.class);
        for (Skill type: Skill.values()) {
            skills.put(type, new SkillMeta());
        }

        this.passivePerception = 10;
        this.proficiency = 0;
        this.armorClass = 10;
        this.maxHitPoints = 0;
        this.speed = 30;
        this.size = Size.MEDIUM;
    }

    private int getModifier(int value) {
        return (value - 10) / 2;
    }

    public int getModifier(Attribute attribute) {
        return getModifier(attributes.get(attribute));
    }

    public int getSkillModifier(Skill type) {
        int totalModifier = 0;
        if (!skills.containsKey(type)) {
            //throw new InvalidSkillException(String.format("%s does not have skill %s", this.toString(), type));
            return -1;
        }

        totalModifier += getModifier(type.getAttribute());
        if (skills.get(type).isProficient()) {
            totalModifier += proficiency;
            if (skills.get(type).isDoubleProficient()) {
                totalModifier += proficiency;
            }
        }
        return totalModifier;
    }

    public void setSkillProficiency(Skill type, boolean value) {
        SkillMeta skillMeta = skills.get(type);
        skillMeta.setProficient(value);
        skills.replace(type, skillMeta);
    }

    public void setSkillDoubleProficiency(Skill type, boolean value) {
        SkillMeta skillMeta = skills.get(type);
        if (!skillMeta.isProficient()) {
            // throw new RuleException(String.format("Skill %s cannot be double proficient without being proficient.", type));
            return;
        }
        skillMeta.setDoubleProficient(value);
        skills.replace(type, skillMeta);
    }

    public int getAttributeValue(Attribute attribute) {
        return attributes.get(attribute);
    }

    public void setAttributeValue(Attribute attribute, int value) {
        attributes.replace(attribute, value);
    }

    public int getInitiativeBonus() {
        return getModifier(Attribute.DEXTERITY);
    }

    public int getPassivePerception() {
        return 10 + getSkillModifier(Skill.PERCEPTION);
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public EnumMap<Attribute, Integer> getAttributes() {
        return attributes;
    }

    public EnumMap<Skill, SkillMeta> getSkills() {
        return skills;
    }
}
