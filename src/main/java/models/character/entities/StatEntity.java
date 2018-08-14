package models.character.entities;

import models.character.meta.StatBlock;

public abstract class StatEntity extends Entity {
    protected StatBlock statBlock;

    protected StatEntity(){}

    protected StatEntity(StatBlock statBlock, String name) {
        super(name);
        this.statBlock = statBlock;
    }

    public StatBlock getStatBlock() {
        return statBlock;
    }

    public void setStatBlock(StatBlock statBlock) {
        this.statBlock = statBlock;
    }
}
