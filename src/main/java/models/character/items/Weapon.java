package models.character.items;

import models.character.enums.DamageType;
import models.character.enums.Dice;

public class Weapon extends Item {

    protected int numberDamageDie;
    protected Dice damageDie;
    protected int modifier;
    protected DamageType damageType;

    public Weapon() {
    }

    public Weapon(String name, String description, String image) {
        super(name, description, image);
    }
}
