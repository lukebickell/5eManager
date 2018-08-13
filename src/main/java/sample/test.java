package sample;

import outputs.PdfForm;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        try {
            File pdfFile = new File("src/main/resources/Character Sheet - Form Fillable.pdf");

            PdfForm pdfForm = new PdfForm(pdfFile);
            pdfForm.printFields();
            pdfForm.setFieldValue("PlayerName", "Luke");
            pdfForm.setFieldValue("ClassLevel", "Druaid 8");
            pdfForm.setFieldValue("Background", "Heremit");
            pdfForm.setFieldValue("Race", "Earth Gsenasi");
            pdfForm.setFieldValue("Alignment", "Chaotic aNeutral");
            pdfForm.setFieldValue("XP", "27000");
            pdfForm.setFieldValue("STR", "20");
            pdfForm.setFieldValue("STRmod", "5");
            pdfForm.save("edited.pdf", false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
