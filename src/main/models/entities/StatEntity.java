package main.models.entities;

import main.models.meta.StatBlock;

public abstract class StatEntity extends Entity {
    protected StatBlock statBlock;

    protected StatEntity(){}

    protected StatEntity(StatBlock statBlock, String name) {
        super(name);
        this.statBlock = statBlock;
    }
}
