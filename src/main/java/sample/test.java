package sample;

import exceptions.FormFieldDoesNotExistException;
import models.character.entities.PlayerCharacter;
import models.character.enums.Attribute;
import models.character.enums.Skill;
import outputTemplates.PdfTemplate;
import outputs.PdfForm;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        printFileFields();
        writeCharacterSheet();
    }

    private static void printFileFields() {
        try {
            File pdfFile = new File("src/main/resources/Character Sheet - Form Fillable.pdf");
            PdfForm pdfForm = new PdfForm(pdfFile);
            pdfForm.printFields();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFileStuff() {
        try {
            File pdfFile = new File("src/main/resources/Character Sheet - Form Fillable.pdf");
            PdfForm pdfForm = new PdfForm(pdfFile);
            pdfForm.printFields();
            pdfForm.setFieldValue("PlayerName", "Luke");
            pdfForm.setFieldValue("ClassLevel", "Druid 8");
            pdfForm.setFieldValue("Background", "Hermit");
            pdfForm.setFieldValue("Race", "Earth Genasi");
            pdfForm.setFieldValue("Alignment", "Chaotic Neutral");
            pdfForm.setFieldValue("XP", "27000");
            pdfForm.setFieldValue("STR", "20");
            pdfForm.setFieldValue("STRmod", "5");
            pdfForm.save("edited.pdf", false);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FormFieldDoesNotExistException e) {
            e.printStackTrace();
        }
    }

    private static void writeCharacterSheet() {
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.getStatBlock().setSkillProficiency(Skill.INSIGHT, true);
        playerCharacter.getStatBlock().setSkillProficiency(Skill.NATURE, true);
        playerCharacter.getStatBlock().setSkillProficiency(Skill.ATHLETICS, true);
        playerCharacter.getStatBlock().setSavingThrowProficiency(Attribute.CONSTITUTION, true);

        File pdfFile = new File("src/main/resources/Character Sheet - Form Fillable.pdf");
        try {
            PdfTemplate pdfTemplate = new PdfTemplate(pdfFile, playerCharacter);
            pdfTemplate.write();
            pdfTemplate.save("edited2.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
