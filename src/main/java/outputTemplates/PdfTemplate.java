package outputTemplates;

import exceptions.FormFieldDoesNotExistException;
import outputs.PdfForm;
import models.character.entities.Character;

import java.io.File;
import java.io.IOException;

public class PdfTemplate implements OutputTemplate {
    private PdfForm pdfForm;

    public PdfTemplate(File pdfFile) throws IOException {
        this.pdfForm = new PdfForm(pdfFile);
    }

    @Override
    public void write(Character character) {
        //TODO complete
        String classLevel = String.format("%s %s", character.getDndClass().name(), character.getLevel());
        String fullName = String.format("%s %s", character.getFirstName(), character.getLastName());

        try {
            pdfForm.setFieldValue("ClassLevel", classLevel);
            //pdfForm.setFieldValue("Background", );
            pdfForm.setFieldValue("PlayerName", ""); //TODO
            pdfForm.setFieldValue("CharacterName", fullName);
            //pdfForm.setFieldValue("Race", character.race);
            //pdfForm.setFieldValue("Alignment", character.alignment);
            //pdfForm.setFieldValue("XP", character.inspiration);
            //pdfForm.setFieldValue("STR", character.strength);
            //pdfForm.setFieldValue("Background", character.background);
        } catch (FormFieldDoesNotExistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() throws IOException {
        pdfForm.save("New Pdf File.pdf", true);
    }
}
