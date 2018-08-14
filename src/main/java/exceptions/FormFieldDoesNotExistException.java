package exceptions;

import java.io.IOException;

public class FormFieldDoesNotExistException extends Exception {
    public FormFieldDoesNotExistException() {
        super();
    }

    public FormFieldDoesNotExistException(String fieldName) {
        super(String.format("Field named '%s' does not exist in form.", fieldName));
    }
}
