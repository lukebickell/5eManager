package outputTemplates;

import exceptions.FormFieldDoesNotExistException;
import models.character.entities.PlayerCharacter;
import models.character.enums.Attribute;
import models.character.enums.Skill;
import outputs.PdfForm;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

public class PdfTemplate implements OutputTemplate {
    private PdfForm pdfForm;
    private PlayerCharacter character;
    private EnumMap<Attribute, String> savingThrowProficiencies = new EnumMap<>(Attribute.class);
    private EnumMap<Skill, String> skillProficiencies = new EnumMap<>(Skill.class);

    public PdfTemplate(File pdfFile, PlayerCharacter character) throws IOException {
        this.pdfForm = new PdfForm(pdfFile);
        this.character = character;

        initSavingThrowProficiencies();
        initSkillProficiencies();
    }

    private void initSavingThrowProficiencies() {
        Attribute[] attributeList = Attribute.values();
        String[] checkBoxSavingThrowStrings =
                {"Check Box 11", "Check Box 18", "Check Box 19", "Check Box 20", "Check Box 21", "Check Box 22"};
        for (int i = 0; i < attributeList.length; i ++) {
            savingThrowProficiencies.put(attributeList[i], checkBoxSavingThrowStrings[i]);
        }
    }

    private void initSkillProficiencies() {
        int checkBoxNumber = 23;
        for (Skill skill : Skill.values()) {
            skillProficiencies.put(skill, "Check Box " + checkBoxNumber);
            checkBoxNumber++;
        }
    }

    @Override
    public void write() {
        //TODO complete
        // 12 13 14 DS Successes
        // 15 16 17 DS Failures
        // 11 18 19 20 21 22 saving throw prof
        // 23-40 skill prof
        try {
            writeSavingThrowProficiencyCheckBoxes();
            writeSkillProficiencyCheckBoxes();
            writeAttributesModsSavingThrows();
            writePersonalityDescription();
            writeHitPointsAndHitDice();
            writeMainFeatures();
            writeMiscStats();
            writeSkills();

        } catch (FormFieldDoesNotExistException e) {
            e.printStackTrace();
        }
    }

    private void writeSavingThrowProficiencyCheckBoxes() throws FormFieldDoesNotExistException {
        for (Attribute key : savingThrowProficiencies.keySet()) {
            String checkBox = savingThrowProficiencies.get(key);
            pdfForm.setFieldValue(checkBox, character.getStatBlock().getSavingThrowProficiency(key));
        }
    }

    private void writeSkillProficiencyCheckBoxes() throws FormFieldDoesNotExistException {
        for (Skill key : skillProficiencies.keySet()) {
            String checkBox = skillProficiencies.get(key);
            pdfForm.setFieldValue(checkBox, character.getStatBlock().getSkillProficiency(key));
        }
    }

    private void writeAttributesModsSavingThrows() throws FormFieldDoesNotExistException {
        pdfForm.setFieldValue("STR", character.getStatBlock().getAttributeValue(Attribute.STRENGTH));
        pdfForm.setFieldValue("DEX", character.getStatBlock().getAttributeValue(Attribute.DEXTERITY));
        pdfForm.setFieldValue("CON", character.getStatBlock().getAttributeValue(Attribute.CONSTITUTION));
        pdfForm.setFieldValue("INT", character.getStatBlock().getAttributeValue(Attribute.INTELLIGENCE));
        pdfForm.setFieldValue("WIS", character.getStatBlock().getAttributeValue(Attribute.WISDOM));
        pdfForm.setFieldValue("CHA", character.getStatBlock().getAttributeValue(Attribute.CHARISMA));

        pdfForm.setFieldValue("STRmod", character.getStatBlock().getModifier(Attribute.STRENGTH));
        pdfForm.setFieldValue("DEXmod", character.getStatBlock().getModifier(Attribute.DEXTERITY));
        pdfForm.setFieldValue("CONmod", character.getStatBlock().getModifier(Attribute.CONSTITUTION));
        pdfForm.setFieldValue("INTmod", character.getStatBlock().getModifier(Attribute.INTELLIGENCE));
        pdfForm.setFieldValue("WISmod", character.getStatBlock().getModifier(Attribute.WISDOM));
        pdfForm.setFieldValue("CHamod", character.getStatBlock().getModifier(Attribute.CHARISMA));

        pdfForm.setFieldValue("ST Strength", character.getStatBlock().getSavingThrowModifier(Attribute.STRENGTH));
        pdfForm.setFieldValue("ST Dexterity", character.getStatBlock().getSavingThrowModifier(Attribute.DEXTERITY));
        pdfForm.setFieldValue("ST Constitution", character.getStatBlock().getSavingThrowModifier(Attribute.CONSTITUTION));
        pdfForm.setFieldValue("ST Intelligence", character.getStatBlock().getSavingThrowModifier(Attribute.INTELLIGENCE));
        pdfForm.setFieldValue("ST Wisdom", character.getStatBlock().getSavingThrowModifier(Attribute.WISDOM));
        pdfForm.setFieldValue("ST Charisma", character.getStatBlock().getSavingThrowModifier(Attribute.CHARISMA));
    }

    private void writeMiscStats() throws FormFieldDoesNotExistException {
        pdfForm.setFieldValue("Passive", character.getStatBlock().getPassivePerception());
        pdfForm.setFieldValue("Speed", character.getStatBlock().getSpeed());
        pdfForm.setFieldValue("ProfBonus", character.getStatBlock().getProficiency());
        pdfForm.setFieldValue("Initiative", character.getStatBlock().getInitiative());
        pdfForm.setFieldValue("AC", character.getStatBlock().getArmorClass());
    }

    private void writeSkills() throws  FormFieldDoesNotExistException {
        pdfForm.setFieldValue("Acrobatics", character.getStatBlock().getSkillModifier(Skill.ACROBATICS));
        pdfForm.setFieldValue("Animal", character.getStatBlock().getSkillModifier(Skill.ANIMAL_HANDLING));
        pdfForm.setFieldValue("Athletics", character.getStatBlock().getSkillModifier(Skill.ATHLETICS));
        pdfForm.setFieldValue("Deception", character.getStatBlock().getSkillModifier(Skill.DECEPTION));
        pdfForm.setFieldValue("History", character.getStatBlock().getSkillModifier(Skill.HISTORY));
        pdfForm.setFieldValue("Insight", character.getStatBlock().getSkillModifier(Skill.INSIGHT));
        pdfForm.setFieldValue("Intimidation", character.getStatBlock().getSkillModifier(Skill.INTIMIDATION));
        pdfForm.setFieldValue("Investigation", character.getStatBlock().getSkillModifier(Skill.INVESTIGATION));
        pdfForm.setFieldValue("Nature", character.getStatBlock().getSkillModifier(Skill.NATURE));
        pdfForm.setFieldValue("Perception", character.getStatBlock().getSkillModifier(Skill.PERCEPTION));
        pdfForm.setFieldValue("Arcana", character.getStatBlock().getSkillModifier(Skill.ARCANA));
        pdfForm.setFieldValue("Performance", character.getStatBlock().getSkillModifier(Skill.PERFORMANCE));
        pdfForm.setFieldValue("Medicine", character.getStatBlock().getSkillModifier(Skill.MEDICINE));
        pdfForm.setFieldValue("Religion", character.getStatBlock().getSkillModifier(Skill.RELIGION));
        pdfForm.setFieldValue("Stealth", character.getStatBlock().getSkillModifier(Skill.STEALTH));
        pdfForm.setFieldValue("Persuasion", character.getStatBlock().getSkillModifier(Skill.PERSUASION));
        pdfForm.setFieldValue("SleightofHand", character.getStatBlock().getSkillModifier(Skill.SLEIGHT_OF_HAND));
        pdfForm.setFieldValue("Survival", character.getStatBlock().getSkillModifier(Skill.SURVIVAL));
    }

    private void writeMainFeatures() throws FormFieldDoesNotExistException {
        String classLevel = String.format("%s %s", character.getDndClass().name(), character.getLevel());
        String fullName = String.format("%s %s", character.getFirstName(), character.getLastName());

        pdfForm.setFieldValue("CharacterName", fullName);
        pdfForm.setFieldValue("ClassLevel", classLevel);
        //pdfForm.setFieldValue("Background", character.getBackground());
        pdfForm.setFieldValue("PlayerName", ""); //TODO
        pdfForm.setFieldValue("Race", character.getRace().getValue());
        //pdfForm.setFieldValue("Alignment", character.getAlignment());
        pdfForm.setFieldValue("XP", character.getXp());
    }

    private void writePersonalityDescription() throws FormFieldDoesNotExistException{
        pdfForm.setFieldValue("PersonalityTraits", character.getPersonalityDescription().traits);
        pdfForm.setFieldValue("Ideals", character.getPersonalityDescription().ideals);
        pdfForm.setFieldValue("Bonds", character.getPersonalityDescription().bonds);
        pdfForm.setFieldValue("Flaws", character.getPersonalityDescription().flaws);
    }

    private void writeHitPointsAndHitDice() throws FormFieldDoesNotExistException{
        pdfForm.setFieldValue("HPMax", character.getStatBlock().getMaxHitPoints());
        pdfForm.setFieldValue("HPCurrent", character.getStatBlock().getCurrentHitPoints());
        pdfForm.setFieldValue("HPTemp", character.getStatBlock().getTemporaryHitPoints());
        pdfForm.setFieldValue("HDTotal", character.getLevel());
        pdfForm.setFieldValue("HD", character.getLevel());
    }

    @Override
    public void save(String fileName) throws IOException {
        pdfForm.save(fileName, true);
    }
}
