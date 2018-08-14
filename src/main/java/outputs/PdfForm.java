package outputs;

import exceptions.FormFieldDoesNotExistException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfForm {

    private PDDocument pdfDocument;
    private PDAcroForm acroForm;

    public PdfForm(File pdfFile) throws IOException {
        this.pdfDocument = PDDocument.load(pdfFile);
        PDDocumentCatalog documentCatalog = pdfDocument.getDocumentCatalog();
        this.acroForm = documentCatalog.getAcroForm();
    }

    public PdfForm(PDDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
        PDDocumentCatalog documentCatalog = pdfDocument.getDocumentCatalog();
        this.acroForm = documentCatalog.getAcroForm();
    }

    public void printFields() {
        List<PDField> fields = acroForm.getFields();
        System.out.println(fields.size() + " top-level fields were found on the form");

        for (PDField field : fields) {
            System.out.println(String.format("'%s'", field.getPartialName()));
        }
    }

    private void normalizeFieldNames() {
        List<PDField> fields = acroForm.getFields();

        for (PDField field : fields) {
            normalizeFieldName(field);
        }
    }

    private void normalizeFieldName(PDField field) {
        String partialName = field.getPartialName();

        if (partialName != null) {
            partialName = partialName.trim();
            field.setPartialName(partialName);
        }
    }

    private PDField getField(String name) throws FormFieldDoesNotExistException{
        PDField field = acroForm.getField(name);
        if (field == null) {
            throw new FormFieldDoesNotExistException(name);
        }
        return field;
    }

    public String getFieldValue(String name) throws FormFieldDoesNotExistException {
        PDField field = getField(name);
        return field.getValueAsString();
    }

    public void setFieldValue(String name, String value) throws FormFieldDoesNotExistException {
        PDField field = getField(name);
        try {
            field.setValue(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFieldValue(String name, boolean value) throws FormFieldDoesNotExistException {
        PDField field = getField(name);
        try {
            if (field instanceof PDCheckBox) {
                if (value) {
                    field.setValue("Yes");
                } else {
                    field.setValue("Off");
                }
            } else {
                //TODO log this
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFieldValue(String name, int value) throws FormFieldDoesNotExistException {
        PDField field = getField(name);
        String stringValue = String.valueOf(value);
        try {
            field.setValue(stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFieldReadOnly(PDField field, boolean value) {
        field.setReadOnly(value);
    }

    public void save(String fileName, boolean readOnly) throws IOException {
        if (readOnly) {
            saveReadOnly(fileName);
        } else {
            pdfDocument.save(fileName);
        }
    }

    private void saveReadOnly(String fileName) throws IOException {
        List<PDField> fields = acroForm.getFields();
        for (PDField field : fields) {
            setFieldReadOnly(field, true);
        }
        pdfDocument.save(fileName);
    }
}
