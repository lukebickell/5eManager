package models.character.entities;

import models.character.enums.DNDClass;
import models.character.meta.StatBlock;

public class Character extends StatEntity {
    protected String firstName;
    protected String lastName;

    protected int level;
    protected DNDClass dndClass;

    public Character() {}

    public Character(StatBlock statBlock, String name, String firstName, String lastName, int level, DNDClass dndClass) {
        super(statBlock, name);
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.dndClass = dndClass;
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
}
