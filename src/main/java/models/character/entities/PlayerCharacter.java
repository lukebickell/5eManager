package models.character.entities;

import models.character.enums.DNDClass;
import models.character.enums.Dice;
import models.character.enums.Race;
import models.character.meta.StatBlock;

public class PlayerCharacter extends StatEntity {
    protected String firstName;
    protected String lastName;

    protected PersonalityDescription personalityDescription;
    protected int level;
    protected int xp;
    protected DNDClass dndClass;
    protected Dice hitDie;
    protected Race race;
    //protected Alignment alignment;

    public PlayerCharacter() {
        super(new StatBlock(), "");
        this.firstName = "";
        this.lastName = "";
        this.personalityDescription = new PersonalityDescription();
        personalityDescription.bonds = "";
        personalityDescription.flaws = "";
        personalityDescription.ideals = "";
        personalityDescription.traits = "";
        this.level = 1;
        this.dndClass = DNDClass.BARBARIAN;
        this.hitDie = Dice.D8;
        this.race = Race.HUMAN;
        this.xp = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public DNDClass getDndClass() {
        return dndClass;
    }

    public void setDndClass(DNDClass dndClass) {
        this.dndClass = dndClass;
    }

    public PersonalityDescription getPersonalityDescription() {
        return personalityDescription;
    }

    public void setPersonalityDescription(PersonalityDescription personalityDescription) {
        this.personalityDescription = personalityDescription;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Dice getHitDie() {
        return hitDie;
    }

    public void setHitDie(Dice hitDie) {
        this.hitDie = hitDie;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
