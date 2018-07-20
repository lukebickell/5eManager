package main.models.meta;

public class SkillMeta {
    private boolean proficient;
    private boolean doubleProficient;

    public SkillMeta() {
        this.proficient = false;
        this.doubleProficient = false;
    }

    public boolean isProficient() {
        return proficient;
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }

    public boolean isDoubleProficient() {
        return doubleProficient;
    }

    public void setDoubleProficient(boolean doubleProficient) {
        this.doubleProficient = doubleProficient;
    }
}
