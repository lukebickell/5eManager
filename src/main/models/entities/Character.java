package main.models.entities;

import main.models.enums.DNDClass;
import main.models.meta.StatBlock;

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
}
